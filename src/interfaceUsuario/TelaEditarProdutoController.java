package interfaceUsuario;

import javafx.scene.Scene;
import javafx.stage.Stage;
import store.Loja;

public class TelaEditarProdutoController {
	private Loja store;
	Stage stage;
	Scene scene;
	
	public void colocarStore(Loja store) {
		this.store = store;
	}
	
}
