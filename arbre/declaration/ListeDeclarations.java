package plic.arbre.declaration;

import java.util.ArrayList;

import plic.arbre.ArbreAbstrait;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ListeDeclarations extends ArbreAbstrait {
	ArrayList<ArbreAbstrait> listeArbresAbstraits;
	
    protected ListeDeclarations(int n) {
        super(n) ;
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
