package plic.arbre.declaration;

import java.util.ArrayList;

import plic.arbre.tds.EVariable;
import plic.arbre.tds.Symbole;
import plic.arbre.tds.Tds;

public class DeclarationChamp extends ListeDeclarations {
	protected String status;
	protected String type;
	protected ListeIDF listeIDF;

	public DeclarationChamp(int n, String s, String t, ListeIDF li) {
		super(n);
		status = s;
		type = t;
		listeIDF = li;
		for(String idf : listeIDF.getListeIDF()){
			Tds.getInstance().ajouterChamp(new EVariable(idf), new Symbole(status, type, Tds.getInstance().getTailleZoneDesVariables()*(-4)));
		}
	}

}
