package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return " non " ;
    }

	@Override
	public void verifier() throws AnalyseSemantiqueException {
		if (expression.getType() != ENTIER){
			throw new AnalyseSemantiqueException("erreur de type : " + expression.getType());
		}
		
	}

	@Override
	public String toMIPS() {
		return "li $v0, " + expression + "\n"
		+ "sw $v0, 0($sp)\n"
		+ "lw $t8, ($sp)\n"
		+ "not $v0, $t8\n"
		+ "sw $v0, 0($sp)\n";
	}

	@Override
	public int getType() {
		return BOOL;
	}

}
