package plic.arbre.expression;

import plic.exceptions.AnalyseException;
import plic.exceptions.AnalyseSemantiqueException;
import plic.exceptions.DivisionParZeroException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Div extends BinaireArithmetique {

    public Div(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " / ";
    }

	@Override
	public void verifier() throws AnalyseException {
		if (gauche.getType() != "entier" || droite.getType() != "entier"){
			throw new AnalyseSemantiqueException("erreur de type : " + gauche.getType() + " & " + droite.getType());
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(gauche.toMIPS());
		sb.append("\n");
		sb.append("sw $v0, 0($sp)\n");
		sb.append("add $sp, $sp, -4\n");
		sb.append(droite.toMIPS());
		sb.append("\n");
		sb.append("add $sp, $sp, 4\n");
		sb.append("lw $t8, ($sp)\n");
		sb.append("div $v0, $t8, $v0\n");
		sb.append("sw $v0, 0($sp)\n");
		
		return sb.toString();
	}

	@Override
	public String getType() {
		return "entier";
	}

	@Override
	public int valeur() {
		if (droite.valeur() != 0){
    		return  (gauche.valeur() / droite.valeur());
    	}
		else
    		throw new DivisionParZeroException(ligne);
	}
    
}
