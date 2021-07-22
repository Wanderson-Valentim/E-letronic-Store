package store;

import java.util.ArrayList;

public class Cliente {
	private ArrayList<Produto> carrinho;
	double total;
	public String nome;
	
	Cliente(Conta conta) {
		this.nome = conta.pegarNome() + " " + conta.pegarSobrenome();
	}
	
	public void addProduto(Produto item) {
		this.carrinho.add(item);
		this.total += item.preco;
	}
	
	public void removerProduto(Produto p) {
		if(this.carrinho.contains(p)) {
			int i = this.carrinho.indexOf(p);
			this.total -= this.carrinho.remove(i).preco;
		}
	}
}
