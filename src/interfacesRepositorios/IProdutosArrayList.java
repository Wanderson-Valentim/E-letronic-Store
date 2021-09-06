package interfacesRepositorios;

import store.Produto;
import java.util.ArrayList;
import exceptions.ProdutoExisteException;
import exceptions.ProdutoInexistenteException;

public interface IProdutosArrayList {
    boolean verificaExistenciaUsuario(String nome);
    boolean verificaExistenciaId(int id);
    void adicionaProduto(Produto produto)  throws ProdutoExisteException;
    void removeProduto(Produto produto)  throws ProdutoInexistenteException;
    Produto consultaProdutoNomeProduto(String nome) throws ProdutoInexistenteException;
    Produto consultaProdutoId(int id)  throws ProdutoInexistenteException;
    ArrayList<Produto> procuraProduto(String str) throws ProdutoInexistenteException ;
    ArrayList<Produto> getProdutos();
}
