package plic.arbre.expression;

import plic.arbre.tds.EVariable;
import plic.arbre.tds.Symbole;
import plic.arbre.tds.Tds;
import plic.exceptions.AnalyseSemantiqueException;

public class Idf extends Expression {
	
	protected Symbole symbole;
	protected String nom;
	
	public Idf(String text, int n) {
		super(n);
		nom = text;
	}

	@Override
	public String getType() {
		return symbole.getType();
	}

	@Override
	public void verifier() {
		symbole = Tds.getInstance().identifier(new EVariable(nom));
		if (symbole == null) {
			throw new AnalyseSemantiqueException("La variable " + nom + " n'a pas ete declaree");
		}
	}

	@Override
	public String toMIPS() {
		return null;
	}
	
	public String toString() {
        return nom;
    }

	@Override
	public int valeur() {
		return symbole.getValeur();
	}

}
