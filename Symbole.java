package plic;

import java.util.ArrayList;

public class Symbole {
	int privPub; //pas sûre
	int type;
	int placeDansLaPile;
	
	int yyline;
	int yycolumn;
	Object value;
	
	public Symbole(int p, int typ, int pile){
		privPub = p;
		type = typ;
		placeDansLaPile = pile;
	}

	public Symbole(int type, int yyline, int yycolumn, Object value) {
		this.type = type;
		this.yyline = yyline;
		this.yycolumn = yycolumn;
		this.value = value;
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
	
	public int getYyline(){
		return this.yyline;
	}
	
	public int getYycolumn(){
		return this.yycolumn;
	}
	
	public Object getValue(){
		return this.value;
	}
	
}
