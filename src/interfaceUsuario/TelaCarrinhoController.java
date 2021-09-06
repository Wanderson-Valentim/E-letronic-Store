package interfaceUsuario;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import store.Carrinho;
import store.ContaCliente;
import store.Loja;

public class TelaCarrinhoController {
	@FXML
	private TextField searchBar;
	
	@FXML
	private Label total;
	
	private Loja store;
	private Scene scene;
	private Stage stage;
	
	public void colocarLoja(Loja store) {
		this.store = store;
		ContaCliente conta = store.pegarConta();
		Carrinho carrinho = conta.getCarrinho();
		total.setText(String.valueOf(carrinho.getTotal()));
	}
	
	public void eventoBusca() {
		String value = searchBar.getText();
		System.out.println(value);
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
	
	public void trocaParaConta(ActionEvent event) throws IOException {
		if(!this.store.isLogged) {
			System.out.println("Você não está logado!");
			return;
		}
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaceUsuario/telaAcoesConta.fxml"));
		Parent root = loader.load();
		TelaAcoesContaController controller = loader.getController();
		controller.colocarStore(store);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void trocaParaBoleto(ActionEvent event) throws IOException {
		if(!this.store.isLogged) {
			System.out.println("Você não está logado!");
			return;
		}
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaceUsuario/telaBoleto.fxml"));
		Parent root = loader.load();
		TelaBoletoController controller = loader.getController();
		controller.colocarStore(store);
		controller.criarBoleto();
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
