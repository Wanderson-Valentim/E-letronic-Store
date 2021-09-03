package store;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.ContaExisteException;
import exceptions.ProdutoInexistenteException;

public class main {
	public static void main(String[] args) throws ProdutoInexistenteException, ContaExisteException {
		Loja store = new Loja();
		store.procuraProduto("AOC");
		Scanner myObj = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome = myObj.nextLine();
		System.out.print("Sobrenome: ");
		String sobrenome = myObj.nextLine();
		System.out.print("Email: ");
		String email = myObj.nextLine();
		System.out.print("Senha: ");
		String senha = myObj.nextLine();
		System.out.print("Endereço: ");
		String endereco = myObj.nextLine();
		String[] data = {nome, sobrenome, email, senha, endereco};
		store.criarConta(data);
		
		System.out.println("===================================================");
		store.mostrarCarrinho();
	}
}
