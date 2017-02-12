package plic.arbre.expression;

import plic.Entree;
import plic.Symbole;
import plic.Tds;
import plic.exceptions.AnalyseSemantiqueException;

public class Idf extends Expression {
	protected Symbole symbole;
	protected String nom;

	
	public Idf(String text, int n) {
		super(n);
		nom = text;
	}

	@Override
	public int getType() {
		return symbole.getType();
	}

	@Override
	public void verifier() {
		symbole = Tds.getInstance().identifier(new Entree(nom));
		if(symbole == null){
			throw new AnalyseSemantiqueException("La variable " + nom + "n'a pas été déclarée");
		}
	}

	@Override
	public String toMIPS() {
		return null;
	}
	
	public String toString() {
        return nom ;
    }

}
