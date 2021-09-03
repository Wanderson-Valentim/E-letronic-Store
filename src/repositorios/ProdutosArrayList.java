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

    private boolean verificaExistenciaUsuario(String nome){
        for(int i=0; i < this.produtos.size(); i++){
            String produto = this.produtos.get(i).getNome();
            if(produto.equals(nome)){
                this.index = i;
                return true;
            }
        }
        return false;
    }

    private boolean verificaExistenciaId(int id){
        for(int i=0; i < this.produtos.size(); i++){
            int produto = this.produtos.get(i).getId();
            if(produto == id){
                this.index = i;
                return true;
            }
        }
        return false;
    }

    public void adicionaProduto(Produto produto) throws ProdutoExisteException{
        boolean produtoExiste = verificaExistenciaUsuario(produto.getNome());
        
        if(!produtoExiste){
            this.produtos.add(produto);
        }
        else{
            throw new ProdutoExisteException();
        }
    }

    public void removeProduto(Produto produto) throws ProdutoInexistenteException{
        boolean produtoExiste = verificaExistenciaUsuario(produto.getNome());

        if(produtoExiste){
            this.produtos.remove(produto);
        }
        else{
            throw new ProdutoInexistenteException();
        }
    }

    //Não implementada, pq n sei se precisa
    /*public void atualizaProduto(Produto produto) throws ProdutoInexistenteException{
        boolean produtoExiste = verificaExistenciaUsuario(produto.getNome());

        if(produtoExiste){
            
        }
        else{
            throw new ProdutoInexistenteException();
        }
    }*/

    Produto consultaProdutoNomeProduto(String nome) throws ProdutoInexistenteException{
        boolean produtoExiste = verificaExistenciaUsuario(nome);

        if(produtoExiste){
            return produtos.get(this.index);
        }
        else{
            throw new ProdutoInexistenteException();
        }
    }

    Produto consultaProdutoId(int id) throws ProdutoInexistenteException{
        boolean produtoExiste = verificaExistenciaId(id);

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