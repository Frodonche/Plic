package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;

public class Ecrire extends ArbreAbstrait {
	protected String string;
	
	protected Ecrire(int no, String s) {
		super(no);
		string = s;
	}


	public void verifier() {

	}


	public String toMIPS() {
		return null;
	}

}
