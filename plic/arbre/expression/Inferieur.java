package plic.arbre.expression;

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
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}
    
}
