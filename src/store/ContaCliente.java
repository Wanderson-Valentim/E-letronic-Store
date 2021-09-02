package store;

import exceptions.ProdutoInexistenteException;

public class ContaCliente extends Conta{
    private Carrinho carrinho;

    public ContaCliente(String[] data){
        super(data, false);
        carrinho = new Carrinho();
    }

    public Carrinho getCarrinho(){
        return this.carrinho;
    }

    public void adicionaProdutoCarrinho(Produto produto){
        carrinho.adicionaProduto(produto);
    }

    public void removeProdutoCarrinho(Produto produto) throws ProdutoInexistenteException{
        carrinho.removeProduto(produto);
    }

    public void finalizaCompra(){
        //ainda n sei como fzr
    }

    public void atualizaEmail(String novoEmail){
        this.setEmail(novoEmail);
    }

    public  void atualizaSenha(String novoSenha){
        this.setSenha(novoSenha);
    }

    public void atualizaEndereco(String novoEndereco){
        this.setEndereco(novoEndereco);
    }
}
