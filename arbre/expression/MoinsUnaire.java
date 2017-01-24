package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {

	public MoinsUnaire(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return "- " ;
    }

	@Override
	public void verifier() throws AnalyseSemantiqueException {
		if (expression.getType() != ENTIER){
			throw new AnalyseSemantiqueException("erreur de type : " + expression.getType());
		}
		
	}

	@Override
	public String toMIPS() {
		return "li $v0, -" + expression + "\n"
				+ "sw $v0, 0($sp)\n" 
				+ "move $v1, $v0\n"
				+ "li $v0, 10\n"
				+ "syscall\n";
	}

	@Override
	public int getType() {
		return ENTIER;
	}

}
