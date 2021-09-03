package store;

public class Produto {
	int id;
	String nome;
	String categoria;
	float preco;
	int quantidade;
	
	Produto(int id, String nome, String categoria, float preco, int quantidade){
		this.id = id;
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
	
	public int getId(){
		return this.id;
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

	public void setId(int novoId){
		this.id = novoId;
	}

	public void setPreco(int novoPreco){
		this.preco = novoPreco;
	}

}
