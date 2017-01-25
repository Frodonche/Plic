package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Inferieur extends Comparaison {

    public Inferieur(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " < ";
    }

	@Override
	public void verifier() throws AnalyseSemantiqueException {
		if (gauche.getType() != ENTIER && droite.getType() != ENTIER){
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
				+ "slt $v0, $t8, $v0\n"
				+ "sw $v0, 0($sp)\n";
	}

	@Override
	public int getType() {
		return BOOL;
	}
    
}
