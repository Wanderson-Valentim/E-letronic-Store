package interfaceUsuario;

import java.io.IOException;
import java.util.ArrayList;

import exceptions.ContaInexistenteException;
import exceptions.ProdutoInexistenteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import store.ContaCliente;
import store.ContaGerente;
import store.Loja;

public class TelaGerenteController {
	@FXML
	private TextField nomeProduto;
	
	@FXML
	private TextField quantidade;
	
	@FXML
	private TextField removeText;
	
	@FXML
	private TextField editaText;
	
	private Loja store;
	Stage stage;
	Scene scene;
	
	public void colocarStore(Loja store) {
		this.store = store;
	}
	
	public void trocaParaHome(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaceUsuario/telaPrincipal.fxml"));
		Parent root = loader.load();
		MainController controller = loader.getController();
		controller.colocarLoja(store);
		controller.trocarBtnLoginLabel();
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		
		stage.show();
	}
	
	public void aumentarEstoque() throws ProdutoInexistenteException {
		String nome = nomeProduto.getText();
		String quant = quantidade.getText();
		this.store.aumentarEstoque(nome, quant);
	}
	
	public void removerProduto() throws ProdutoInexistenteException {
		String nome = removeText.getText();
		this.store.removerProduto(nome);
	}
	
	public void alterarSenha(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaceUsuario/telaAlterarSenha.fxml"));
		Parent root = loader.load();
		TelaAlterarSenhaController controller = loader.getController();
		controller.colocarLoja(store);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		
		stage.show();
	}

	public void sairDaConta(ActionEvent event) throws ContaInexistenteException, IOException {
		store.logout();
		this.trocaParaHome(event);
	}
}