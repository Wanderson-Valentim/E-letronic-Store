package exceptions;

public class ContaExisteException extends Exception{
    public ContaExisteException(){
        super("Conta já existe!");
    }
}
