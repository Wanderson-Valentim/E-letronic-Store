package repositorios;

import java.util.ArrayList;

import exceptions.ProdutoExisteException;
import exceptions.ProdutoInexistenteException;
import interfacesRepositorios.IProdutosArrayList;
import store.Produto;

public class ProdutosArrayList implements IProdutosArrayList{
    private ArrayList<Produto> produtos;
    private int index;

    public ProdutosArrayList(){
        produtos = new ArrayList<Produto>();
        index = 0;
    }

    public boolean verificaExistenciaUsuario(String nome){
        for(int i=0; i < this.produtos.size(); i++){
            String produto = this.produtos.get(i).getNome();
            if(produto.equals(nome)){
                this.index = i;
                return true;
            }
        }
        return false;
    }

    public boolean verificaExistenciaId(int id){
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

    public Produto consultaProdutoNomeProduto(String nome) throws ProdutoInexistenteException{
        boolean produtoExiste = verificaExistenciaUsuario(nome);

        if(produtoExiste){
            return produtos.get(this.index);
        }
        else{
            throw new ProdutoInexistenteException();
        }
    }

    public Produto consultaProdutoId(int id) throws ProdutoInexistenteException{
        boolean produtoExiste = verificaExistenciaId(id);

        if(produtoExiste){
            return produtos.get(this.index);
        }
        else{
            throw new ProdutoInexistenteException();
        }
    }

    public ArrayList<Produto> procuraProduto(String str) throws ProdutoInexistenteException {
      ArrayList<Produto> listaFiltrada = new ArrayList<Produto>() ;
      for(int counter = 0; counter < this.produtos.size(); counter++) {
    	  Produto produto = this.produtos.get(counter);
    	  if(produto.getNome().contains(str)) {
    		  listaFiltrada.add(produto);
    	  }
      }
      return listaFiltrada;
    }

    public ArrayList<Produto> getProdutos(){
        return this.produtos;
    }
}