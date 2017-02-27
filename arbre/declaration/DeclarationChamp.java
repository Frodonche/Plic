package plic.arbre.declaration;

import java.util.ArrayList;

import plic.Entree;
import plic.Symbole;
import plic.Tds;

public class DeclarationChamp extends ListeDeclarations {
	protected int status;
	protected int type;
	protected ArrayList<String> listeDeclarations;

	protected DeclarationChamp(int n, String s, String t, ArrayList<String> li) {
		super(n);
		if (s == "public"){
			status = 0;
		} else if(s == "privee"){
			status = 1;
		}

		if (t == "entier"){
			type = 0;
		}
		listeDeclarations = li;
		for(String idf : listeDeclarations){
			Tds.getInstance().ajouter(new Entree(idf), new Symbole(status, type, Tds.getInstance().getTailleZoneDesVariables()*(-4)));
		}
	}

}
