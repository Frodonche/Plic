package plic.exceptions;

public class DivisionParZeroException extends ExecutionException{
	public DivisionParZeroException(int ligne) {
		super("ERREUR DIVISION PAR ZERO :\n\t"+ligne);
	}
}
