package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class OuLogique extends BinaireLogique {

    public OuLogique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " ou " ;
    }

	@Override
	public void verifier() throws AnalyseSemantiqueException {
		if (gauche.getType() != "bool" || droite.getType() != "bool"){
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
		sb.append("or $v0, $t8, $v0\n");
		sb.append("sw $v0, 0($sp)\n");
				
		return sb.toString();

	}

	@Override
	public String getType() {
		return "bool";
	}

	@Override
	public int valeur() {
		if(gauche.valeur() + droite.valeur() > 0)
			return 1;
		else
			return 0;
	}

}
