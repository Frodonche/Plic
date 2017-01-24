package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return " non " ;
    }

	@Override
	public void verifier() throws AnalyseSemantiqueException {
		if (expression.getType() != ENTIER){
			throw new AnalyseSemantiqueException("erreur de type : " + expression.getType());
		}
		
	}

	@Override
	public String toMIPS() {
		return "li $v0, " + expression + "\n"
				+ "sw $v0, 0($sp)\n"
				+ "lw $t8, ($sp)\n"
				+ "beq $t8, 0, egalite\n"
				+ "li $v0, 0\n"
				+ "b fin\n"
				+ "\n"
				+ "egalite : li $v0, 1\n"
				+ "fin : sw $v0, 0($sp)\n";
	}
	
	
	
		
	
	
	
	
	

	@Override
	public int getType() {
		return BOOL;
	}

}
