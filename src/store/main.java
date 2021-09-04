package store;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.ContaExisteException;
import exceptions.ProdutoInexistenteException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/interfaceUsuario/telaPrincipal.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("E-letronic Store");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
