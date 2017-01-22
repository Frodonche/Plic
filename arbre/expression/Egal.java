package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Egal extends Comparaison {

    public Egal(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " == ";
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		return "li $v0, " + gauche + "\n"
				+ "sw $v0, 0($sp)\n"
				+ "add $sp, $sp, -4\n"
				+ "li $v0, " + droite + "\n"
				+ "add $sp, $sp, 4\n"
				+ "lw $t8, ($sp)\n"
				+ "beq $t8, $v0, egalite\n"
				+ "li $v0, 0\n"
				+ "b fin\n"
				+ "\n"
				+ "egalite : $li $v0, 1\n"
				+ "fin : sw $v0, 0($sp)\n";
	}

	@Override
	public int getType() {
		return BOOL;
	}
    
}
