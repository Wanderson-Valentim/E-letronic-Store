package store;

public class Conta {
	private String nomeUsuario;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String endereco;
	
	Conta(String[] data){
		this.nomeUsuario = data[0];
		this.nome = data[1];
		this.sobrenome = data[2];
		this.email = data[3];
		this.senha = data[4];
		this.endereco = data[5];
	}
	
	boolean ehEssaConta(String usuario, String senha) {
		return (
				(usuario.equals(this.nomeUsuario) || usuario.equals(this.email))
				&& senha.equals(this.senha)
		);
	}
	
	public String pegarNome() {
		return this.nome;
	}
	
	public String pegarSobrenome() {
		return this.sobrenome;
	}
}
