package store;

public abstract class Conta {
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String endereco;
	private boolean ehGerente;
	
	Conta(String[] data, boolean tipo){
		this.nome = data[0];
		this.sobrenome = data[1];
		this.email = data[2];
		this.senha = data[3];
		this.endereco = data[4];
		this.ehGerente = tipo;
	}

	public boolean ehEssaSenha(String senha) {
		return (senha.equals(this.senha));
	}
	
	public boolean getTipoConta(){
		return this.ehGerente;
	}

	public String getNome() {
		return this.nome;
	}
	
	public String getSobrenome() {
		return this.sobrenome;
	}

	public String getEmail() {
		return this.email;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public void setSobrenome(String novoSobrenome) {
		this.sobrenome = novoSobrenome ;
	}

	public void setEmail(String novoEmail) {
		this.email = novoEmail;
	}
	
	public void setEndereco(String novoEndereco) {
		this.endereco = novoEndereco;
	}

	public void setSenha(String novaSenha) {
		this.senha = novaSenha;
	}
}
