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
		StringBuilder sb = new StringBuilder();
		
		sb.append(expression.toMIPS());
		sb.append("\n");
		sb.append("sw $v0, 0($sp)\n");
		sb.append("lw $t8, ($sp)\n");
		sb.append("beq $t8, 0, egalite\n");
		sb.append("li $v0, 0\n");
		sb.append("b fin\n\n");
		sb.append("egalite : li $v0, 1\n");
		sb.append("fin : sw $v0, 0($sp)\n");
		
		return sb.toString();
	}
	
	
	
		
	
	
	
	
	

	@Override
	public int getType() {
		return BOOL;
	}

}
