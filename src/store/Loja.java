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
	private ContaCliente currentAccount;
	public boolean isLogged = false;
	
	public Loja() {
		try {
			System.out.println("lendo arquivos...");
			this.lerArquivo("/src/items");
			System.out.println("Terminei a leitura");
			String[] gerenteData = {"Gerente", "da Silva", "admin", "admin", "Brasil"};
			ContaGerente gerente = new ContaGerente(gerenteData);
			this.clientes.adicionaConta(gerente);
			String[] defaultData = {"Querido", " Cliente", "contaDefault@e-letronicStore.com", "Default@157802zptwsffmuhnn52342ljipsdfhlaspojdksgasd", "Brasil"};
			ContaCliente contaPadrao = new ContaCliente(defaultData);
			this.clientes.adicionaConta(contaPadrao);
			this.currentAccount = contaPadrao;
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
	
	public void addProduto(ArrayList<String> data) {
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
				this.isLogged = true;
				this.currentAccount = ((ContaCliente)conta);
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
		this.isLogged = true;
		this.currentAccount = novaConta;
		this.login(data[2], data[3]);
	}
	
	public ContaCliente pegarConta() {
		if(isLogged) return this.currentAccount;
		else return null;
	}
	
	public ArrayList<Produto> pegarProdutos() {
		ArrayList<Produto> produtos = this.produtos.getProdutos();
		return produtos;
	}
	
	public void mostrarCarrinho() {
		Carrinho car = this.currentAccount.getCarrinho();
		ArrayList<int[]> produtos = car.getListaProdutos();
		ArrayList<Produto> carrinho = new ArrayList<Produto>();
		for(int counter = 0; counter < produtos.size(); counter++) {
			int[] produto = produtos.get(counter);
			for(int j = 0; j < this.produtos.getProdutos().size(); j++) {
				Produto p = this.produtos.getProdutos().get(j);
				if(p.getId() == produto[0]) {
					carrinho.add(p);
				}
			}
		}
		if(carrinho.size() < 1) {
			System.out.println("O carrinho está vazio!");
			return;
		}
		for(int counter = 0; counter < carrinho.size(); counter++) {
			Produto p = carrinho.get(counter);
			int[] data = produtos.get(counter);
			System.out.println(p.getId() + " - " + p.getNome() + " - " + data[1]);
		}
	}
}
