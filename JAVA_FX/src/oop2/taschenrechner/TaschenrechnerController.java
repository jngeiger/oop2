package oop2.taschenrechner;
import javafx.fxml.*;
import javafx.scene.control.TextField;

public class TaschenrechnerController {
@FXML TextField tf1;

	@FXML
	void helloWorld()
	{ System.out.println("Say Hello World on Console"); }
	
	@FXML
	void enterNumber()
	{ tf1.setText("1"); }
}
