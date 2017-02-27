package plic;

import java.util.ArrayList;

import java_cup.runtime.Symbol;

<<<<<<< HEAD
public class Symbole {
	
	int privPub; //pas s�re
=======
public class Symbole{
	int privPub; 
>>>>>>> 75432ca7ae350fc81389dfdc78dc2ee12f9c8d30
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
