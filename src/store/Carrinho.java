package store;

import java.util.ArrayList;

import exceptions.ProdutoInexistenteException;

public class Carrinho {
    private ArrayList<int[]> produtos;
    private float precoTotal;
    private int index;

    public Carrinho(){
        produtos = new ArrayList<int[]>();
        precoTotal = 0;
        index = 0;
    }

    private boolean verificaExistecia(int id){
        int[] vetor;
        for(int i = 0; i < produtos.size(); i++){
            vetor = produtos.get(i);
            if(vetor[0] == id){
                index = i;
                return true;
            }
        }
        return false;
    }

    public ArrayList<int[]> getListaProdutos(){
        return this.produtos;
    }

    public void adicionaProduto(Produto produto){
        if(verificaExistecia(produto.getId())){
            int[] vetor = produtos.get(index);
            vetor[1] += 1;
            precoTotal += produto.getPreco();
        }
        else{
            int[] vetor = new int[2];
            vetor[0] = produto.getId();
            vetor[1] = 1;
            precoTotal += produto.getPreco();
            produtos.add(vetor);
        }
    }

    public void removeProduto(Produto produto) throws ProdutoInexistenteException{
        if(verificaExistecia(produto.getId())){
            int[] vetor = produtos.get(index);
            int quantidade = vetor[1];
            precoTotal -= quantidade * produto.getPreco();
            produtos.remove(index);
        }
        else{
            throw new ProdutoInexistenteException();
        }
    }

    public void limparCarrinho(){
        produtos.clear();
        precoTotal = 0;
    }

    public float getTotal(){
        return this.precoTotal;
    }

    public int getQuantidadeTotal() {
    	int resultado = 0;
    	for(int i = 0; i < produtos.size(); i++) {
    		int[] p = produtos.get(i);
    		
    		resultado += p[1];
    	}
    	
    	return resultado;
    }
}
