package repositorios;

import java.util.ArrayList;

import exceptions.ProdutoExisteException;
import exceptions.ProdutoInexistenteException;
import store.Produto;

public class ProdutosArrayList {
    private ArrayList<Produto> produtos;
    private int index;

    public ProdutosArrayList(){
        produtos = new ArrayList<Produto>();
        index = 0;
    }

    private boolean verificaExistencia(String nome){
        for(int i=0; i < this.produtos.size(); i++){
            String produto = this.produtos.get(i).getNome();
            if(produto.equals(produto)){
                this.index = i;
                return true;
            }
        }
        return false;
    }

    public void adicionaProduto(Produto produto) throws ProdutoExisteException{
        boolean produtoExiste = verificaExistencia(produto.getNome());
        
        if(!produtoExiste){
            this.produtos.add(produto);
        }
        else{
            throw new ProdutoExisteException();
        }
    }

    public void removeProduto(Produto produto) throws ProdutoInexistenteException{
        boolean produtoExiste = verificaExistencia(produto.getNome());

        if(produtoExiste){
            this.produtos.remove(produto);
        }
        else{
            throw new ProdutoInexistenteException();
        }
    }

    //Não implementada, pq n sei se precisa
    /*public void atualizaProduto(Produto produto) throws ProdutoInexistenteException{
        boolean produtoExiste = verificaExistencia(produto.getNome());

        if(produtoExiste){
            
        }
        else{
            throw new ProdutoInexistenteException();
        }
    }*/

    Produto consultaProduto(String usuario) throws ProdutoInexistenteException{
        boolean produtoExiste = verificaExistencia(usuario);

        if(produtoExiste){
            return produtos.get(this.index);
        }
        else{
            throw new ProdutoInexistenteException();
        }
    }

    public ArrayList<Produto> getProdutos(){
        return this.produtos;
    }
}