package plic.arbre.expression;

import plic.exceptions.AnalyseException;
import plic.exceptions.AnalyseSemantiqueException;

public class Affectation extends Binaire {

	protected Affectation(Expression gauche, Expression droite) {
		super(gauche, droite);
	}

	@Override
	public int getType() {
		return 0;
	}

	@Override
	public void verifier() throws AnalyseException {
		gauche.verifier();
		droite.verifier();		
		if (!typesConcordent()) {
			throw new AnalyseSemantiqueException("erreur de type : " + gauche.getType() + " & " + droite.getType());
		}
	}

	@Override
	public String toMIPS() {
		return null;
	}

	@Override
	public String operateur() {
		return " = ";
	}
	
	public boolean typesConcordent(){
		if (gauche.getType() == droite.getType()) {
			return true;
		}
		
		return false;
	}

}
