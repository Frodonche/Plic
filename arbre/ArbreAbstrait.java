package plic.arbre;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class ArbreAbstrait {
    
    // numero de ligne du debut de l'instruction
    protected int noLigne ;
    public static final int ENTIER = 0;
    public static final int BOOL = 1;
    
    protected ArbreAbstrait(int no) {
        noLigne = no ;
    }
    
    public int getNoLigne() {
        return noLigne ;
    }

    public abstract void verifier() ; 
    public abstract String toMIPS() ; 

}
