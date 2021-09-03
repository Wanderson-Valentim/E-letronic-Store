package store;
import java.util.ArrayList;

import exceptions.ContaExisteException;
import exceptions.ProdutoExisteException;
import exceptions.ProdutoInexistenteException;
import repositorios.ContasArrayList;
import repositorios.ProdutosArrayList;

import java.io.*;
import java.io.File;

public class Loja {
	private ProdutosArrayList produtos = new ProdutosArrayList();
	private ContasArrayList clientes = new ContasArrayList();
	
	Loja() {
		try {
			System.out.println("lendo arquivos...");
			this.lerArquivo("/src/items");
			System.out.println("Terminei a leitura");
			String[] data = {"Gerente", "da Silva", "admin", "admin", "no where"};
			ContaGerente gerente = new ContaGerente(data);
			this.clientes.adicionaConta(gerente);
		}
		catch(Exception e) {
			System.out.println("Error ao ler os produtos!");
		}
	}
	
	private void lerArquivo(String caminho) throws Exception {
		ArrayList<String> data = new ArrayList<String>();
		String filePath = new File("").getAbsolutePath();
		int caracter;
		String str = "";
		
		try(FileReader fr = new FileReader(filePath + caminho)){
			// Trata da leitura, char/char;
			for(caracter = fr.read(); caracter != -1; caracter = fr.read()) {
				if((char) caracter == '\n') {
					data.add(str);
					this.addProduto(data);
					data = new ArrayList<String>();
					str = "";
					continue; // Para n ter que passar pelo próximo if, tentar melhorar isso aqui
				}
				
				if((char) caracter != ',') str += (char) caracter;
				else {
					data.add(str);
					str = "";
				}
			}
			
			fr.close();
		 }
	}
	
	void addProduto(ArrayList<String> data) {
		Produto novoP = new Produto(
				Integer.parseInt(data.get(0)),
				data.get(1), data.get(2),
				Float.parseFloat(data.get(3)),
				Integer.parseInt(data.get(4))
		);

		try {
			this.produtos.adicionaProduto(novoP);
		}
		catch (ProdutoExisteException e) {
			System.out.println(e.getMessage());
		}
	}

	public void procuraProduto(String str) throws ProdutoInexistenteException {
		ArrayList<Produto> filteredList = this.produtos.procuraProduto(str);
		for(int counter = 0; counter < filteredList.size(); counter++) {
			Produto p = filteredList.get(counter);
			System.out.println(p.getNome());
		}

	}
	
	public void login(String email, String password) {
		ArrayList<Conta> contas = this.clientes.getContas();
		boolean temConta = false;
		for(int counter = 0; counter < contas.size(); counter++) {
			Conta conta = contas.get(counter);
			if(conta.ehEssaConta(email) && conta.ehEssaSenha(password)) {
				temConta = true;
			}
		}
		
		if(temConta) {
			System.out.println("Você está logado!");
		} else {
			System.out.println("Email ou senha estão errados!");
		}
	}
	
	public void criarConta(String[] data) throws ContaExisteException {
		ContaCliente novaConta = new ContaCliente(data);
		this.clientes.adicionaConta(novaConta);
	}
	
	public void mostrarProdutos() {
		ArrayList<Produto> produtos = this.produtos.getProdutos();
		for(int counter = 0; counter < produtos.size(); counter++) {
			Produto p = produtos.get(counter);
			System.out.println(p.id + " - " + p.nome + "\t- R$ " + p.preco + " -\tQuantidade: " + p.quantidade);
		}
	}
}
