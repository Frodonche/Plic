package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteBool extends Constante {
    
    public ConstanteBool(String texte, int n) {
        super(texte, n) ;
    }

	@Override
	public void verifier() {

		
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder("li $v0, ");
		
	    if (cste.equals("vrai")) {
	    	sb.append("1");	    	
	    }
	    else {
	    	sb.append("0");
	    }
	    
		return sb.toString(); 
	}

	@Override
	public int getType() {
		return BOOL;
	}

}
