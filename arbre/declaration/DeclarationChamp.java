package plic.arbre.declaration;

import java.util.ArrayList;

import plic.Entree;
import plic.Symbole;
import plic.Tds;

public class DeclarationChamp extends ListeDeclarations {
	protected int status;
	protected int type;
	protected ListeIDF listeIDF;

	public DeclarationChamp(int n, String s, String t, ListeIDF li) {
		super(n);
		if (s == "public"){
			status = 0;
		} else if(s == "privee"){
			status = 1;
		}

		if (t == "entier"){
			type = 0;
		}
		listeIDF = li;
		for(String idf : listeIDF.getListeIDF()){
			Tds.getInstance().ajouter(new Entree(idf), new Symbole(status, type, Tds.getInstance().getTailleZoneDesVariables()*(-4)));
		}
	}

}
