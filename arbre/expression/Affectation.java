package plic.arbre.expression;

import plic.arbre.ArbreAbstrait;
import plic.arbre.BlocDInstructions;
import plic.arbre.tds.EVariable;
import plic.arbre.tds.Entree;
import plic.arbre.tds.Symbole;
import plic.arbre.tds.Tds;
import plic.exceptions.AnalyseException;
import plic.exceptions.AnalyseSemantiqueException;

public class Affectation extends BlocDInstructions{
	protected String acces;
	protected Expression exp;
	protected Symbole symbole;
	protected int nbLignes;
	
	public Affectation(int n, Expression e, String a) {
		super(n);
		this.nbLignes = n;
		acces = a;
		exp = e;
		symbole = Tds.getInstance().identifier(new EVariable(acces));
	}

	@Override
	public void verifier() throws AnalyseSemantiqueException {
		Tds.getInstance().verifier(new EVariable(this.acces, this.nbLignes),exp);
		Symbole s = Tds.getInstance().identifier(new EVariable(acces, nbLignes), nbLignes);
		exp.verifier();
		if(!s.getType().equals(exp.getType())){
			throw new AnalyseSemantiqueException("Type non conforme, renseigne:"+Tds.getInstance().identifier(new EVariable(acces),nbLignes).getType()+", attendu :"+ exp.getType()+exp.getLigne());
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
		sb.append("sw $v0, "+symbole.getDeplacement()*(-4) +"($s7)\n");
		
		return sb.toString();
	}

}
