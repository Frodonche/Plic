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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() {
		return BOOL;
	}

}
