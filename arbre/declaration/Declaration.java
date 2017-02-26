package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Declaration extends ArbreAbstrait {

	
    protected Declaration(int n) {
        super(n) ;
    }
    
    public abstract int getType();

}
