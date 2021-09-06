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
import store.Produto;

public class TelaEditarProdutoController {
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
		
		id.setText(String.valueOf(p.getId()));
		nome.setText(p.getNome());
		preco.setText(String.valueOf(p.getPreco()));
		categoria.setText(p.getCategoria());
		quantidade.setText(String.valueOf(p.getQuantidade()));
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
	
	public void editarProduto(ActionEvent event) throws IOException {
		int newId = Integer.parseInt(id.getText());
		String newNome = nome.getText();
		float newPreco = Float.valueOf(preco.getText());
		String newCategoria = categoria.getText();
		int newQuantidade = Integer.parseInt(quantidade.getText());
		
		p.setId(newId);
		p.setPreco(newPreco);
		p.setQuantidade(newQuantidade);
		p.setCategoria(newCategoria);
		p.setNome(newNome);
		
		trocaParaGerente(event);
	}
	
}
