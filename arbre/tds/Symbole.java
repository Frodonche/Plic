package plic.arbre.tds;

public class Symbole {
	
	private String statut;
	private String type;
	private int d;
	private int valeur;
    
    public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Symbole(String statut, String type, int d) {
    	this.statut = statut;
    	this.type = type;
    	this.d = d;
    }
 
    public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString(){
    	return statut+" "+type;
    }

	public int getDeplacement() {
		return d;
	}

	public void setDeplacement(int d) {
		this.d = d;
	}
}
