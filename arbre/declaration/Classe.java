package plic.arbre.declaration;

import java.util.ArrayList;

import plic.arbre.ArbreAbstrait;

public class Classe extends ArbreAbstrait {
	protected String idf;
	protected ListeDeclarations listeDeclarations;

	
	protected Classe(int no, String i, ListeDeclarations ld) {
		super(no);
		idf = i;
		listeDeclarations = ld;
	}
	
	protected Classe(int no, String i) {
		super(no);
		idf = i;
		listeDeclarations = new ListeDeclarations(no);
	}

	@Override
	public void verifier() {
		listeDeclarations.verifier();
		
	}

	@Override
	public String toMIPS() {
		return listeDeclarations.toMIPS();
	}

}
