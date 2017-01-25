package plic.arbre.expression;

import plic.exceptions.AnalyseException;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Different extends Comparaison {

    public Different(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " != ";
    }

	@Override
	public void verifier() throws AnalyseSemantiqueException {
		if ((gauche.getType() != BOOL && droite.getType() != BOOL) || (gauche.getType() != ENTIER && droite.getType() != ENTIER)){
			throw new AnalyseSemantiqueException("erreur de type : " + gauche.getType() + " & " + droite.getType());
		}
		
	}

	@Override
	public String toMIPS() {
		return "" + gauche.toMIPS() + "\n"
		+ "sw $v0, 0($sp)\n"
		+ "add $sp, $sp, -4\n"
		+ "" + droite.toMIPS() + "\n"
		+ "add $sp, $sp, 4\n"
		+ "lw $t8, ($sp)\n"
		+ "beq $t8, $v0, egalite\n"
		+ "li $v0, 1\n"
		+ "b fin\n"
		+ "\n"
		+ "egalite : li $v0, 0\n"
		+ "fin : sw $v0, 0($sp)\n";
	}

	@Override
	public int getType() {
		return BOOL;
	}
  
}
