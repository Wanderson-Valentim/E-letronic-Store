package store;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;

import interfaceUsuario.MainController;

public class main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		Loja store = new Loja();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaceUsuario/telaPrincipal.fxml"));
		Parent root = loader.load();
		
		MainController controller = loader.getController();
		controller.colocarLoja(store);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("E-letronic Store");
		stage.setResizable(false);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
