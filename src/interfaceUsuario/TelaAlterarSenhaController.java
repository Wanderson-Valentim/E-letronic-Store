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
import store.ContaGerente;
import store.Loja;

public class TelaAlterarSenhaController {
	@FXML
	private TextField senhaAtual;
	
	@FXML
	private TextField novaSenha;
	
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

	private void trocarParaConta(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaceUsuario/telaAcoesConta.fxml"));
		Parent root = loader.load();
		TelaAcoesContaController controller = loader.getController();
		controller.colocarStore(store);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void trocarSenha(ActionEvent event) throws IOException {
		if(this.store.ehGerente) {
			ContaGerente conta = this.store.pegarContaGerente();
			if(!conta.confirmarSenha(senhaAtual.getText())) return;
			conta.atualizaSenha(novaSenha.getText());
		} else {
			ContaCliente conta = this.store.pegarConta();
			if(!conta.confirmarSenha(senhaAtual.getText())) return;
			
			conta.atualizaSenha(novaSenha.getText());
		}

		this.trocarParaConta(event);
	}
}
