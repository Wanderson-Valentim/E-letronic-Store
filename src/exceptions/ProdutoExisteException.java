package exceptions;

public class ProdutoExisteException extends Exception{
    public ProdutoExisteException(){
        super("Produto já existe!");
    }
}
