package store;

import java.util.ArrayList;

import exceptions.ProdutoInexistenteException;

public class main {
	public static void main(String[] args) throws ProdutoInexistenteException {
		Loja store = new Loja();
		store.procuraProduto("AOC");
	}
}
