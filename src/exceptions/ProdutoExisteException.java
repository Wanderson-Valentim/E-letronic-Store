package exceptions;

public class ProdutoExisteException extends Exception{

	private static final long serialVersionUID = 1L;

	public ProdutoExisteException(){
        super("Produto já existe!");
    }
}
