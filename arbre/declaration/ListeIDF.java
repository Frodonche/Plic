package plic.arbre.declaration;

import java.util.ArrayList;

import plic.arbre.ArbreAbstrait;

public class ListeIDF {
	protected ArrayList<String> listeIDF; 

	public ListeIDF() {
		listeIDF = new ArrayList<String>();
	}
	
	public void ajouter(String s){
		listeIDF.add(s);
	}

	public ArrayList<String> getListeIDF() {
		return listeIDF;
	}
	
}
