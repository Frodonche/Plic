package plic.arbre.declaration;

import java.beans.Expression;

import plic.Entree;
import plic.Symbole;
import plic.Tds;
import plic.arbre.ArbreAbstrait;
import plic.exceptions.AnalyseException;
import plic.exceptions.AnalyseSemantiqueException;

public class Affectation extends ListeInstructions{
	protected String acces;
	protected Expression exp;

	protected Affectation(int n, Expression e, String a) {
		super(n);
		acces = a;
		exp = e;
	}

	@Override
	public void verifier() throws AnalyseException {
		Symbole s = Tds.getInstance().identifier(new Entree(acces));
//		if(exp.getType() != s.getType()){
//			throw new AnalyseSemantiqueException("erreur de type : " + exp.getType() + " & " + s.getType());
//		}
	}

	public String operateur() {
		return " = ";
	}
	
	@Override
	public String toMIPS() {
		return null;
	}

}
