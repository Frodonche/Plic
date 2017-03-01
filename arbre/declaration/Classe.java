package plic.arbre.declaration;

import java.util.ArrayList;

import plic.arbre.ArbreAbstrait;

public class Classe extends ArbreAbstrait {
	protected String idf;
	protected ListeDeclarations listeDeclarations;

	
	public Classe(int no, String i, ArbreAbstrait ld) {
		super(no);
		idf = i;
		listeDeclarations = (ListeDeclarations) ld;
	}
	
	public Classe(int no, String i) {
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
