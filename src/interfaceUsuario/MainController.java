package interfaceUsuario;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import store.Loja;
import store.Produto;

public class MainController {
	@FXML
	Button buscarBtn;
	
	@FXML 
	TextField searchBar;
	
	@FXML
	Button loginBtn;
	
	@FXML
	ListView<String> items;
	
	private ObservableList<String> lista;
	
	private Stage stage;
	private Scene scene;
	private Loja store;
	
	public void colocarLoja(Loja store) throws IOException {
		this.store = store;
		putItems();
	}
	
	public void putItems() throws IOException {
		ArrayList<Produto> produtos = this.store.pegarProdutos();
		lista = FXCollections.observableArrayList();
		
		
		for(int i = 0; i < produtos.size(); i++) {
			Produto p = produtos.get(i);
			
			String str = p.getCategoria() + " - " + p.getNome() + " - " + " R$ " + p.getPreco();
			lista.add(str);
		}
		
		items.setItems(lista);
//		ArrayList<Produto> produtos = store.pegarProdutos();
//		for(int i = 0; i < produtos.size(); i++) {
//			
//		}
	}
	
	public void searchEvent() {
		String value = searchBar.getText();
		System.out.println(value);
	}
	
	public void trocarBtnLoginLabel() {
		if(this.store.isLogged) loginBtn.setText("Logout");
		else loginBtn.setText("Login");
	}
	
	public void trocaParaLogin(ActionEvent event) throws IOException {
		if(this.store.isLogged) {
			this.store.logout();
			trocarBtnLoginLabel();
			return;
		}
		loginBtn.setText("Logout");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaceUsuario/telaLogin.fxml"));
		Parent root = loader.load();
		TelaLoginController controller = loader.getController();
		controller.colocarLoja(store);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
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
	
	public void trocaParaCarrinho(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaceUsuario/telaCarrinho.fxml"));
		Parent root = loader.load();
		TelaCarrinhoController controller = loader.getController();
		controller.colocarLoja(store);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void trocaParaGerente(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaceUsuario/telaGerente.fxml"));
		Parent root = loader.load();
		TelaGerenteController controller = loader.getController();
		controller.colocarStore(store);
		
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
		if(this.store.ehGerente) {
			trocaParaGerente(event);
		} else {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaceUsuario/telaAcoesConta.fxml"));
			Parent root = loader.load();
			TelaAcoesContaController controller = loader.getController();
			controller.colocarStore(store);
			
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}
}
