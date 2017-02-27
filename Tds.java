package plic;

import java.util.HashMap;

import plic.exceptions.DoubleDeclarationException;

public class Tds {
	
	public static Tds instance = new Tds();
	protected HashMap<Entree, Symbole> map;
	protected int tailleZone;
	
	private Tds() {
		map = new HashMap<Entree, Symbole>();
		tailleZone = 0;
	}
	
	public static Tds getInstance() {
		return instance;
	}
	
	public void ajouter(Entree e, Symbole s) throws DoubleDeclarationException {
		if (map.containsKey(e)){
			throw new DoubleDeclarationException("La variable " + e + " a deja ete declaree");
		} 
		else {
			map.put(e, s);
			tailleZone = tailleZone + 1;
		}
	}

	public Symbole identifier(Entree e) {
		Symbole s = map.get(e);
		return s;
	}
	
	public int getTailleZoneDesVariables() {
		return tailleZone;
	}
	
}
