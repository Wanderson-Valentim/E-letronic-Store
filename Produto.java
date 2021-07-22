
public class Produto {
	String nome;
	String categoria;
	float preco;
	int quantidade;
	
	Produto(String nome, String categoria, float preco, int quantidade){
		this.nome  = nome;
		this.categoria  = categoria;
		this.preco  = preco;
		this.quantidade = quantidade;
	}
	
	String acessarNome(){
		return this.nome;
	}
	
	String acessarCategoria(){
		return this.categoria;
	}
	
	float acessarPreco(){
		return this.preco;
	}
	
	void inserirProduto(int qtd){
		this.quantidade += qtd;
	}
	
	void removerProduto(int qtd){
		this.quantidade -= qtd;
	}
	
	void alterarPreco(int novoPreco){
		this.preco = novoPreco;
	}
}
