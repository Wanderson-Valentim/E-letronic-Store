package interfaceUsuario;

import java.io.IOException;

import exceptions.ContaExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import store.Loja;

public class TelaCriarContaController {

	@FXML
	private TextField nome;
	
	@FXML
	private TextField sobrenome;
	
	@FXML
	private TextField endereco;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField senha;
	
	private Loja store;
	private Stage stage;
	private Scene scene;
	
	public void colocarLoja(Loja store) {
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
	
	public void criarConta(ActionEvent event) throws ContaExisteException, IOException {
		String[] data = {
			nome.getText(),
			sobrenome.getText(),
			email.getText(),
			senha.getText(),
			endereco.getText()
		};
		this.store.criarConta(data);
		
		this.trocaParaHome(event);
	}
}
