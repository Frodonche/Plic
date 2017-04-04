package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteEntiere extends Constante {
    protected int nombre;
	
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
        this.nombre = Integer.parseInt(texte);
    }

	@Override
	public void verifier() {

	}

	@Override
	public String toMIPS() {
		return "li $v0, " + cste;
	}

	public String getType() {
		return "entier";
	}

	@Override
	public int valeur() {
		// TODO Auto-generated method stub
		return 0;
	}

}
