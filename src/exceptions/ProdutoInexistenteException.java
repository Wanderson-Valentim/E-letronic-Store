package exceptions;

public class ProdutoInexistenteException extends Exception{

	private static final long serialVersionUID = 1L;

	public ProdutoInexistenteException(){
        super("Produto Inexistente!");
    }
}
