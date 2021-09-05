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
import store.Loja;

public class TelaLoginController {
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField senha;
	
	private Stage stage;
	private Scene scene;
	
	private Loja store;
	
	public void colocarLoja(Loja store) {
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

	public void trocarParaCriarConta(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaceUsuario/telaCriarConta.fxml"));
		Parent root = loader.load();
		TelaCriarContaController controller = loader.getController();
		controller.colocarLoja(store);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		
		stage.show();
	}
	
	public void loginEvent() {
		String emailValue = email.getText();
		String senhaValue = senha.getText();
		
		System.out.println(emailValue + " " + senhaValue);
	}
}
