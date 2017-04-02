package plic.arbre.expression;

import plic.exceptions.AnalyseException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteBool extends Constante {
    
	protected int valeur;
	
    public ConstanteBool(String texte, int n) {
        super(texte, n) ;
        this.type = "bool";
		if(texte.equals("vrai"))
			this.valeur = 1;
		else
			this.valeur = 0;
    }

	@Override
	public void verifier() throws AnalyseException{

		
	}

	@Override
	public String toMIPS() {
		int tmp;
		if(this.cste.equals("true"))
			tmp = 1;
		else
			tmp = 0;
		
		StringBuilder bool = new StringBuilder();
		bool.append("	# Range "+ this.cste+ " ("+tmp+")" +" dans $v0 et l'empile\n"+
						  "	li $v0, " + tmp + "\n" +
						  "	sw $v0,($sp) \n" +
						  "	add $sp ,$sp,-4 \n");
		return bool.toString();	
	}

	@Override
	public String getType() {
		return "bool";
	}

	@Override
	public int valeur() {
		// TODO Auto-generated method stub
		return 0;
	}

}
