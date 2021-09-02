package store;

import java.util.ArrayList;

import exceptions.ProdutoInexistenteException;

public class Carrinho {
    private ArrayList<Produto> produtos;
    private float precoTotal;

    public Carrinho(){
        produtos = new ArrayList<Produto>();
        precoTotal = 0;
    }

    public ArrayList<Produto> getListaProdutos(){
        return this.produtos;
    }

    //PRECISA SER AJUSTADA
    public void adicionaProduto(Produto produto){
        produtos.add(produto);
    }

    public void removeProduto(Produto produto) throws ProdutoInexistenteException{
        if(produtos.contains(produto)){
            produtos.remove(produto);
        }
        else{
            throw new ProdutoInexistenteException();
        }
    }

    public float getTotal(){
        return this.precoTotal;
    }
}
