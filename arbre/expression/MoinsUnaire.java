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
	public void verifier() {
		
	}

	@Override
	public String toMIPS() {
		return null;
	}

	@Override
	public int getType() {
		return ENTIER;
	}

}
