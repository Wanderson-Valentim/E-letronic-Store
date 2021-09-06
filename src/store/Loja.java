package store;
import java.util.ArrayList;
import java.util.Random;

import exceptions.ContaExisteException;
import exceptions.ContaInexistenteException;
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
	private ContaCliente contaDefault;
	private ContaGerente gerente;
	public boolean ehGerente = false;
	public boolean isLogged = false;
	
	public Loja() {
		try {
			System.out.println("lendo arquivos...");
			this.lerArquivo("/src/items");
			System.out.println("Terminei a leitura");
			String[] gerenteData = {"Gerente", "da Silva", "admin", "admin", "Brasil"};
			ContaGerente gerente = new ContaGerente(gerenteData);
			this.gerente = gerente;
			this.clientes.adicionaConta(gerente);
			String[] defaultData = {"Querido", " Cliente", "contaDefault@e-letronicStore.com", "Default@157802zptwsffmuhnn52342ljipsdfhlaspojdksgasd", "Brasil"};
			ContaCliente contaPadrao = new ContaCliente(defaultData);
			contaDefault = contaPadrao;
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
	
	public void aumentarEstoque(String nome, String quantidade) throws ProdutoInexistenteException {
		boolean isInteger = true;
		for(int i = 0; i < quantidade.length(); i++) {
			char c = quantidade.charAt(i);
			if(c < '0' || c > '9') {
				isInteger = false;
				break;
			}
		}
		int q = Integer.parseInt(quantidade);
		if(isInteger) this.produtos.aumentarQuantidade(nome, q);
	}

	public void removerProduto(String produto) throws ProdutoInexistenteException {
		Produto p = produtos.consultaProdutoNome(produto);
		produtos.removeProduto(p);
		System.out.println("Produto Removido");
	}
	
	public ArrayList<Produto> procuraProduto(String str) throws ProdutoInexistenteException {
		ArrayList<Produto> filteredList = this.produtos.procuraProduto(str);
		return filteredList;
	}
	
	public Produto pegarProduto(String nome) throws ProdutoInexistenteException {
		return produtos.consultaProdutoNome(nome);
	}
	
	public void logout() {
		currentAccount = contaDefault;
		ehGerente = false;
		isLogged = false;
	}
	
	public void login(String email, String password) {
		ArrayList<Conta> contas = this.clientes.getContas();
		boolean temConta = false;
		if(gerente.ehEssaConta(email) && gerente.ehEssaSenha(password)) {
			ehGerente = true;
			temConta = true;
			isLogged = true;
		} else {
			for(int counter = 0; counter < contas.size(); counter++) {
				Conta conta = contas.get(counter);
				if(conta.ehEssaConta(email) && conta.ehEssaSenha(password)) {
					temConta = true;
					this.isLogged = true;
					this.currentAccount = ((ContaCliente)conta);
				}
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
		return null;
	}
	
	public ContaGerente pegarContaGerente() {
		if(isLogged) return this.gerente;
		return null;
	}
	
	public ArrayList<Produto> pegarProdutos() {
		ArrayList<Produto> produtos = this.produtos.getProdutos();
		return produtos;
	}
	
	public void removerConta() throws ContaInexistenteException {
		if(ehGerente) {
			System.out.println("Não é possível remover a conta do gerente!");
			return;
		}
		this.clientes.removeConta(currentAccount);
		this.logout();
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
