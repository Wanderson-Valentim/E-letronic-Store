package interfaceUsuario;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Item {
	@FXML
	private Label ItemID;
	
	@FXML
	private Label ItemName;
	
	@FXML
	private Label price;
	
	@FXML
	private Button addBtn;
	
	public void setID(int ID) {
		ItemID.setText(String.valueOf(ID));
	}
	
	public void setName(String str) {
		ItemName.setText(str);
	}	
	
	public void setPrice(float value) {
		price.setText(String.valueOf(value));
	}
}
