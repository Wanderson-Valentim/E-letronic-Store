package interfaceUsuario;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import store.Carrinho;
import store.ContaCliente;
import store.Loja;

public class TelaBoletoController {
	@FXML
	Label dataEmissao;
	
	@FXML
	Label dataVencimento;
	
	@FXML
	Label quantidade;
	
	@FXML
	Label valorTotal;
	
	@FXML
	Label numBoleto;
	
	private Loja store;
	private Stage stage;
	private Scene scene;
	
	public void colocarStore(Loja store) {
		this.store = store;
	}
	
	public void criarBoleto() {
		ContaCliente conta = this.store.pegarConta();
		Carrinho carrinho = conta.getCarrinho();
		int quantidadeTotal =  carrinho.getQuantidadeTotal();
		float total = carrinho.getTotal();
		
		Random r = new Random();
		String numero = "";
		String letras = "BCDFGHJKLMNPQRSTUVWXYZ";
		for(int i = 0; i < 10; i++) {
			if(i%2 == 0) {
				int index = r.nextInt(letras.length());
				numero += letras.charAt(index);
			} else numero += r.nextInt(9);
		}
		LocalDate l = LocalDate.now();
		String data = l.toString();
		String vencimento = l.plus(1, ChronoUnit.WEEKS).toString();
		
		dataEmissao.setText(data);
		dataVencimento.setText(vencimento);
		quantidade.setText(String.valueOf(quantidadeTotal));
		valorTotal.setText(String.valueOf(total));
		numBoleto.setText(numero);
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

}
