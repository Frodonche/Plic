package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Plus extends BinaireArithmetique {

    public Plus(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " + " ;
    }

	@Override
	public void verifier() throws AnalyseSemantiqueException {
		if (gauche.getType() != ENTIER && droite.getType() != ENTIER){
			throw new AnalyseSemantiqueException("erreur de type : " + gauche.getType() + " & " + droite.getType());
		}
		
	}

	@Override
	public String toMIPS() {
		return "li $v0, " + gauche + "\n"
				+ "sw $v0, 0($sp)\n"
				+ "add $sp, $sp, -4\n"
				+ "li $v0, " + droite + "\n"
				+ "add $sp, $sp, 4\n"
				+ "lw $t8, ($sp)\n"
				+ "add $v0, $t8, $v0\n"
				+ "sw $v0, 0($sp)\n" 
				+ "move $v1, $v0\n"
				+ "li $v0, 10\n"
				+ "syscall\n";
	}

	public int getType() {
		return ENTIER;
	}

}
