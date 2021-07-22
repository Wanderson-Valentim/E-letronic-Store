package store;
import java.util.ArrayList;
import java.io.*;
import java.io.File;

public class Loja {
	public ArrayList<Produto> produtos;
	private ArrayList<Cliente> clientes;
	
	Loja() {
		this.produtos = new ArrayList<Produto>();
		try {
			System.out.println("lendo arquivos...");
			this.lerArquivo("/src/items");
			System.out.println("Terminei a leitura");
		}
		catch(Exception e) {
			System.out.println("Error ao ler os produtos!");
		}
	}
	
	void lerArquivo(String caminho) throws Exception {
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
				data.get(0), data.get(1),
				Float.parseFloat(data.get(2)),
				Integer.parseInt(data.get(3))
		);
		this.produtos.add(novoP);
	}
}
