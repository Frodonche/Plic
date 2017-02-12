package plic;

import java.util.ArrayList;

public class Symbole {
	int privPub; //pas sûre
	int type;
	int placeDansLaPile;
	
	public Symbole(int p, int typ, int pile){
		privPub = p;
		type = typ;
		placeDansLaPile = pile;
	}

	public int getPrivPub() {
		return privPub;
	}

	public int getType() {
		return type;
	}

	public int getPlaceDansLaPile() {
		return placeDansLaPile;
	}
	
}
