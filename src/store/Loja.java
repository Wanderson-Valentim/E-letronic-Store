package store;
import java.util.ArrayList;

import exceptions.ProdutoExisteException;
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
	
	private void addProduto(ArrayList<String> data) {
		Produto produto = new Produto(Integer.parseInt(data.get(0)),
				data.get(1), data.get(2),
				Float.parseFloat(data.get(3)),
				Integer.parseInt(data.get(4))
		);

		try {
			this.produtos.adicionaProduto(produto);
		}
		catch (ProdutoExisteException e) {
			System.out.println(e.getMessage());
		}
	}
}
