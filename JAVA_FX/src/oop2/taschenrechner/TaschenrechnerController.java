package oop2.taschenrechner;
import javafx.fxml.*;
import javafx.scene.control.TextField;

public class TaschenrechnerController {
@FXML TextField tf1;
Double temp = 0.0;
boolean[] state = new boolean[4];
	
	@FXML
	void enterNumber1()
	{	if (tf1Empty()) { fullClearText(); }
		tf1.setText(tf1.getText() + "1"); tf1.requestFocus();}
	
	@FXML
	void enterNumber2()
	{	if (tf1Empty()) { fullClearText(); }
		tf1.setText(tf1.getText() + "2"); tf1.requestFocus();}
	
	@FXML
	void enterNumber3()
		
	{	if (tf1Empty()) { fullClearText(); }
		tf1.setText(tf1.getText() + "3"); tf1.requestFocus();}
	
	@FXML
	void enterNumber4()
	{	if (tf1Empty()) { fullClearText(); }
	tf1.setText(tf1.getText() + "4"); tf1.requestFocus();}
	
	@FXML
	void enterNumber5()
	{	if (tf1Empty()) { fullClearText(); }
	tf1.setText(tf1.getText() + "5"); tf1.requestFocus();}
	
	@FXML
	void enterNumber6()
	{	if (tf1Empty()) { fullClearText(); }
	tf1.setText(tf1.getText() + "6"); tf1.requestFocus();}
	
	@FXML
	void enterNumber7()
	{	if (tf1Empty()) { fullClearText(); }
	tf1.setText(tf1.getText() + "7"); tf1.requestFocus(); }
	
	@FXML
	void enterNumber8()
	{	if (tf1Empty()) { fullClearText(); }
	tf1.setText(tf1.getText() + "8"); tf1.requestFocus();}
	
	@FXML
	void enterNumber9()
	{ if (tf1Empty()) { fullClearText(); }
	tf1.setText(tf1.getText() + "9"); tf1.requestFocus(); }
	
	@FXML
	void enterNumber0()
	{	if (tf1Empty()) { fullClearText(); }
	tf1.setText(tf1.getText() + "0"); tf1.requestFocus();}
	
	@FXML
	void addition()
	{ temp = Double.valueOf(tf1.getText()); tf1.setText("0"); state[0] = true; tf1.requestFocus();}
	
	@FXML
	void subtraktion()
	{ temp = Double.valueOf(tf1.getText()); tf1.setText("0"); state[1] = true; tf1.requestFocus();}
	
	@FXML
	void multiplikation()
	{ temp = Double.valueOf(tf1.getText()); tf1.setText("0"); state[2] = true; tf1.requestFocus();}
	
	@FXML
	void division()
	{ temp = Double.valueOf(tf1.getText()); tf1.setText("0"); state[3] = true; tf1.requestFocus();}
	
	@FXML
	void equals()
	{ 
		// Addition
		if (state[0] == true)
		{ tf1.setText(String.valueOf(temp + Double.valueOf(tf1.getText()))); state[0] = false; tf1.requestFocus();} 
		// Subtraktion
		if (state[1] == true)
		{ tf1.setText(String.valueOf(temp - Double.valueOf(tf1.getText()))); state[1] = false; tf1.requestFocus();} 
		// Multiplikation
		if (state[2] == true)
		{ tf1.setText(String.valueOf(temp * Double.valueOf(tf1.getText()))); state[2] = false; tf1.requestFocus();} 
		// Division
		if (state[3] == true)
		{ tf1.setText(String.valueOf(temp / Double.valueOf(tf1.getText()))); state[3] = false; tf1.requestFocus();} 
	}
	
	@FXML
	void allClear()
	{ temp = 0.0; tf1.setText("0"); tf1.requestFocus();} 
	
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
