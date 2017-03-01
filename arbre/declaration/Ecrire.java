package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;

public class Ecrire extends ArbreAbstrait {
	protected String string;
	
	private static int noLabel = 0;
	
	public Ecrire(int no, String s) {
		super(no);
		string = s;
	}


	public void verifier() {

	}


	public String toMIPS() {
		
		String res= "li $v0, 4\n" +
				"la $a0, str"+ noLabel +"\n"+
				"syscall\n" +
				"b fin"+ noLabel +"\n"+
				".data\n" +
				"str"+ noLabel +": .asciiz "+string + "\n" +
				".text\n" +
				"fin"+ noLabel +":\n";
		
		noLabel++;
		return res;
	}

}
