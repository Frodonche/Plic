package plic;

import java.util.ArrayList;

public class Symbole {
	String nom; //pas sûre
	String type;
	int placeDansLaPile;
	
	public Symbole(String n, String typ, int pile){
		nom = n;
		type = typ;
		placeDansLaPile = pile;
	}

	public String getNom() {
		return nom;
	}

	public String getType() {
		return type;
	}

	public int getPlaceDansLaPile() {
		return placeDansLaPile;
	}
	
}
