package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Different extends Comparaison {

    public Different(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " != ";
    }

	@Override
	public void verifier() throws AnalyseSemantiqueException {
		if (gauche.getType() != droite.getType()){
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
		sb.append("beq $t8, $v0, egalite\n");
		sb.append("li $v0, 1\n");
		sb.append("b fin\n\n");
		sb.append("egalite : li $v0, 0\n");
		sb.append("fin : sw $v0, 0($sp)\n");
		
		return sb.toString();
	}

	@Override
	public String getType() {
		return "bool";
	}

	@Override
	public int valeur() {
		if(gauche.valeur() != droite.valeur())
			return 1;
		else
			return 0;
	}
  
}
