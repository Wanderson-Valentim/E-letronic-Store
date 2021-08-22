package store;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> produtos;
    private float precoTotal;

    ArrayList<Produto> getListaProdutos(){
        return this.produtos;
    }

    void adicionaProduto(){
        
    }

    void removeProduto(){

    }

    float getTotal(){
        return this.precoTotal;
    }
}
