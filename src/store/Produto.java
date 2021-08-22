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
	
	public String getNome(){
		return this.nome;
	}
	
	public String getCategoria(){
		return this.categoria;
	}
	
	public float getPreco(){
		return this.preco;
	}
	
	public void insereProduto(int qtd){
		this.quantidade += qtd;
	}
	
	public void removeProduto(int qtd){
		this.quantidade -= qtd;
	}
	
	public void setPreco(int novoPreco){
		this.preco = novoPreco;
	}
}
