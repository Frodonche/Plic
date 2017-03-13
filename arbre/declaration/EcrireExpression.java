package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.Expression;

public class EcrireExpression extends ArbreAbstrait {
	protected Expression exp;
	
	private static int noLabel = 0;
	
	public EcrireExpression(int no, Expression s) {
		super(no);
		exp = s;
	}


	public void verifier() {

	}


	public String toMIPS() {
		
	
		return null;
	}

}
