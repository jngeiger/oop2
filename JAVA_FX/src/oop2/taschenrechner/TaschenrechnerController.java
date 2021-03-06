package oop2.taschenrechner;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TaschenrechnerController {
@FXML TextField tf1;
Double temp1 = 0.0;
Double temp2 = 0.0;
Double result = 0.0;
int last = 4;


boolean[] state = new boolean[4];

	@FXML
	void enterNumber(ActionEvent event)
	{{	if (tf1Empty()) { fullClearText(); } tf1.setText(tf1.getText() + ((Button) event.getSource()).getText()); tf1.requestFocus();}}

	@FXML
	void addition()
	{ temp1 = Double.valueOf(tf1.getText()); tf1.setText("0"); state[0] = true; tf1.requestFocus();}
	
	@FXML
	void subtraktion()
	{ temp1 = Double.valueOf(tf1.getText()); tf1.setText("0"); state[1] = true; tf1.requestFocus();}
	
	@FXML
	void multiplikation()
	{ temp1 = Double.valueOf(tf1.getText()); tf1.setText("0"); state[2] = true; tf1.requestFocus();}
	
	@FXML
	void division()
	{ temp1 = Double.valueOf(tf1.getText()); tf1.setText("0"); state[3] = true; tf1.requestFocus();}
	
	@FXML
	void equals()
	{ 
		// Addition
		if (state[0] == true)
		{ result = temp1 + (temp2 = Double.valueOf(tf1.getText())); tf1.setText(String.valueOf(result)); state[0] = false; last = 0; tf1.requestFocus(); return;} 
		// Subtraktion
		if (state[1] == true)
		{ result = temp1 - (temp2 = Double.valueOf(tf1.getText())); tf1.setText(String.valueOf(result)); state[1] = false; last = 1; tf1.requestFocus(); return;} 
		// Multiplikation
		if (state[2] == true)
		{ result = temp1 * (temp2 = Double.valueOf(tf1.getText())); tf1.setText(String.valueOf(result)); state[2] = false; last = 2; tf1.requestFocus();return;} 
		// Division
		if (state[3] == true)
		{ result = temp1 + (temp2 = Double.valueOf(tf1.getText())); tf1.setText(String.valueOf(result)); state[3] = false; last = 3; tf1.requestFocus();return;} 
		if (last == 0)
		{ result += temp2; tf1.setText(String.valueOf(result)); return;}
		if (last == 1)
		{ result -= temp2; tf1.setText(String.valueOf(result)); return;}
		if (last == 2)
		{ result *= temp2; tf1.setText(String.valueOf(result)); return;}
		if (last == 3)
		{ result /= temp2; tf1.setText(String.valueOf(result)); return;}
	}
	
	@FXML
	void allClear()
	{ temp1 = 0.0; temp2 = 0.0; tf1.setText("0"); last = 4; tf1.requestFocus();} 
	
	@FXML
	void clearText()
	{ tf1.setText("0"); tf1.requestFocus();}
	
	@FXML
	private void fullClearText()
	{ tf1.setText(""); }
	
	@FXML
	boolean tf1Empty()
	{ return tf1.getText().contentEquals("0"); };
	
}
