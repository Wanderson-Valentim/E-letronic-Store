package interfaceUsuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	@FXML Button buscarBtn;
	@FXML TextField searchBar;
	@FXML private ListView<String> items;
	private List<String> item = new ArrayList<>();
	private ObservableList<String> lista;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Loja store;
	
	public void putItems() throws IOException {
		item.add("Test1");
		item.add("Test2");
		
		lista = FXCollections.observableArrayList(item);
		
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
