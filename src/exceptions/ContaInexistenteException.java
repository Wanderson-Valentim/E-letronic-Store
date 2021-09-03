package exceptions;

public class ContaInexistenteException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaInexistenteException(){
        super("Conta Inexistente!");
    }
}
