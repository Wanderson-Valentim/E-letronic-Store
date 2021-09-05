package interfaceUsuario;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import store.ContaCliente;
import store.Loja;

public class TelaAcoesContaController {
	@FXML
	private TextField email;
	
	@FXML
	private TextField endereco;
	
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
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		
		stage.show();
	}
	
	public void trocarEmail() {
		ContaCliente conta = this.store.pegarConta();
		conta.atualizaEmail(email.getText());
	}
	
	public void trocarEndereco() {
		ContaCliente conta = this.store.pegarConta();
		conta.atualizaEmail(endereco.getText());
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
}
