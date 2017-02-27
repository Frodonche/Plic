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
		if (expression.getType() != ENTIER) {
			throw new AnalyseSemantiqueException("erreur de type : " + expression.getType());
		}
		
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("li $v0, -");
		sb.append(expression.toMIPS());
		sb.append("\n");
		sb.append("sw $v0, 0($sp)\n");
		
		return sb.toString();
	}

	@Override
	public int getType() {
		return ENTIER;
	}

}
