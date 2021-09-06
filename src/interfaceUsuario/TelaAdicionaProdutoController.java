package interfaceUsuario;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import store.Loja;
import store.Produto;

public class TelaAdicionaProdutoController {
	@FXML
	TextField id;
	
	@FXML
	TextField nome;
	
	@FXML
	TextField preco;
	
	@FXML
	TextField categoria;
	
	@FXML
	TextField quantidade;
	
	private Loja store;
	Stage stage;
	Scene scene;
	Produto p;
	
	public void colocarStore(Loja store) {
		this.store = store;
	}

	public void colocarProduto(Produto produto) {
		this.p = produto;
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
	
	public void adicionarProduto(ActionEvent event) throws IOException {
		String newId = id.getText();
		String newNome = nome.getText();
		String newPreco = preco.getText();
		String newCategoria = categoria.getText();
		String newQuantidade = quantidade.getText();
		
		ArrayList<String> data = new ArrayList<String>();
		
		data.add(newId);
		data.add(newNome);
		data.add(newCategoria);
		data.add(newPreco);
		data.add(newQuantidade);
		
		store.addProduto(data);
		
		trocaParaGerente(event);
	}
}
