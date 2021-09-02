package store;

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
	
	public void insereEstoque(int qtd){
		this.quantidade += qtd;
	}
	
	public void removeEstoque(int qtd){
		this.quantidade -= qtd;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getCategoria(){
		return this.categoria;
	}
	
	public float getPreco(){
		return this.preco;
	}

	public float getQuantidade(){
		return this.quantidade;
	}

	public void setPreco(int novoPreco){
		this.preco = novoPreco;
	}
}
