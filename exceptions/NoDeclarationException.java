package plic.exceptions;

public class NoDeclarationException extends AnalyseException{
	public NoDeclarationException(String m) {
		super("ERREUR PAS DE DECLARATION :\n\t" + m);
	}
}
