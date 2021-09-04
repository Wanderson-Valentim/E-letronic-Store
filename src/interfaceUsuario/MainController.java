package interfaceUsuario;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {
	@FXML Button buscarBtn;
	@FXML Button homeBtn;
	@FXML Button contaBtn;
	@FXML Button carrinhoBtn;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void trocaParaLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/interfaceUsuario/telaLogin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void trocaParaHome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/interfaceUsuario/telaPrincipal.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void trocaParaCarrinho(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/interfaceUsuario/telaCarrinho.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void trocaParaConta(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/interfaceUsuario/telaAcoesConta.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
