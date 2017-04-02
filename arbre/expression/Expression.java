package plic.arbre.expression;

import plic.arbre.ArbreAbstrait;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Expression extends ArbreAbstrait {
	
	protected int ligne;
	
    protected Expression(int n) {
        super(n) ;
        this.ligne = n;
    }
    
    public abstract String getType();
    public abstract int valeur();
    
    public int getLigne(){ return this.ligne; }
}
