package plic.arbre.expression;

import plic.Entree;
import plic.Symbole;
import plic.Tds;
import plic.arbre.ArbreAbstrait;
import plic.exceptions.AnalyseException;
import plic.exceptions.AnalyseSemantiqueException;

public class Affectation extends Expression{
	protected String acces;
	protected Expression exp;
	protected Symbole symbole;

	protected Affectation(int n, Expression e, String a) {
		super(n);
		acces = a;
		exp = e;
		symbole = Tds.getInstance().identifier(new Entree(acces));
	}

	@Override
	public void verifier() throws AnalyseException {
		if(exp.getType() != symbole.getType()){
			throw new AnalyseSemantiqueException("erreur de type : " + exp.getType() + " & " + symbole.getType());
		}
	}

	public String operateur() {
		return " = ";
	}
	
	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		sb.append(exp.toMIPS());
		sb.append("\n");
		sb.append("sw $v0, 0($sp)\n");
		sb.append("sw $v0, "+symbole.getPlaceDansLaPile()*(-4) +"($s7)\n");
		
		return sb.toString();
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

}
