package plic.arbre.tds;

import java.util.HashMap;

import plic.arbre.expression.Expression;
import plic.exceptions.DoubleDeclarationException;
import plic.exceptions.NoDeclarationException;

public class Tds {
	
	private HashMap<Entree, Symbole> tds;
	private HashMap<Entree, Expression> queue;
	private int deplacement;
	private int tailleZone=0;
	
	private Tds(){
		tds =  new HashMap<Entree, Symbole>();
		queue =  new HashMap<Entree, Expression>();
	}
	
	private static Tds instance = new Tds();
	
	public static Tds getInstance(){
		return instance ;
	}
	
	public HashMap<Entree, Symbole> getTds() {
		return tds;
	}

	public HashMap<Entree, Expression> getQueue() {
		return queue;
	}


	public void ajouterChamp(Entree entree, Symbole s) throws DoubleDeclarationException{
		if (tds.containsKey(entree)){
			throw new DoubleDeclarationException(entree.getEntree()+entree.getLigne());
		}else{ 
			s.setDeplacement(deplacement);
			Expression exp = queue.get(entree);
			if(exp != null){
				s.setValeur(exp.valeur());
				tds.put(entree, s);
				queue.remove(entree.getEntree());
			}else{
				tds.put(entree, s);
			}
			switch (s.getType()){
			case "entier":
				deplacement -= 4;
				break;
			case "reel":
				deplacement -= 8;
				break;
			case "bool":
				deplacement -= 4;
				break;
			}
			tailleZone++;
		}
	}
	
	public Symbole identifier(Entree entree, int nbligne){
		Symbole s = tds.get(entree);
		if(s==null){
			throw new NoDeclarationException(entree.getEntree()+nbligne);
		}
		return s;
	}
	
	public Symbole identifier(Entree entree){
		Symbole s = tds.get(entree);
		if(s==null){
			throw new NoDeclarationException(entree.getEntree()+"null");
		}
		return s;
	}
	
	public void verifier(Entree entree, Expression e){
		Symbole s = tds.get(entree);
		if(s==null){
			if(e == null){
				if(queue.get(entree) == null)
					queue.put(entree, e);
			}else{
				queue.put(entree, e);
			}
		}else{
			if(e != null){
				s.setValeur(e.valeur());
			}
		}
	}
	
	/*public void entreeBloc(){
		
	}*/
	
	public int getDeplacement(Entree entree){
		Symbole s = tds.get(entree);
		this.identifier(entree,entree.getLigne());
		return s.getDeplacement();
	}

	public int getTailleZoneDesVariables() {
		return this.tailleZone;
	}
}
