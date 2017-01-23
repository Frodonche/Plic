package plic.arbre.expression;

import plic.exceptions.AnalyseException;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Div extends BinaireArithmetique {

    public Div(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " / ";
    }

	@Override
	public void verifier() throws AnalyseException {
		if (gauche.getType() != ENTIER && droite.getType() != ENTIER){
			throw new AnalyseSemantiqueException("erreur de type : " + gauche.getType() + " & " + droite.getType());
		}
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() {
		return ENTIER;
	}
    
}
