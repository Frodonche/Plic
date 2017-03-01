package plic.arbre.declaration;

import java.util.ArrayList;

import plic.arbre.ArbreAbstrait;

public class ListeInstructions extends ArbreAbstrait {
	ArrayList<ArbreAbstrait> listeArbresAbstraits;
	
	public ListeInstructions(int no) {
		super(no);
		listeArbresAbstraits = new ArrayList<ArbreAbstrait>();
	}


    public void ajouter(ArbreAbstrait i){
		listeArbresAbstraits.add(i);
	}    

	public void verifier() {
		for(ArbreAbstrait a : listeArbresAbstraits){
			a.verifier();
		}
	}

	public String toMIPS() {
		StringBuilder s = new StringBuilder();
		for(ArbreAbstrait a : listeArbresAbstraits){
			s.append(a.toMIPS());
		}
		return s.toString();
	}

}
