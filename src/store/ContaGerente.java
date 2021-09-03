package store;

import repositorios.ProdutosArrayList;
import exceptions.ProdutoExisteException;
import exceptions.ProdutoInexistenteException;

public class ContaGerente extends Conta{
    
    public ContaGerente(String[] data){
        super(data, true);
    }

    public void cadastraProduto(int id, String nome, String categoria, float preco, int quantidade, ProdutosArrayList repositorio) throws ProdutoExisteException{
        Produto produto = new Produto(id, nome, categoria, preco, quantidade);
        repositorio.adicionaProduto(produto);
    }

    public void removeProduto(Produto produto, ProdutosArrayList repositorio) throws ProdutoInexistenteException{
        repositorio.removeProduto(produto);
    }

    public void aumentaEstoque(Produto produto, int quantidade){
        produto.insereEstoque(quantidade);
    }

    public void editaPreco(Produto produto, int novoPreco){
        produto.setPreco(novoPreco);
    }
}
