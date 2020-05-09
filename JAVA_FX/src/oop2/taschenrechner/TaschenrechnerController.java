package oop2.taschenrechner;
import javafx.fxml.*;
import javafx.scene.control.TextField;

public class TaschenrechnerController {
@FXML TextField tf1;
Double temp = 0.0;
boolean[] state = new boolean[1];
	
	@FXML
	void enterNumber1()
	{	if (tf1Empty()) { fullClearText(); }
		tf1.setText(tf1.getText() + "1"); }
	
	@FXML
	void enterNumber2()
	{	if (tf1Empty()) { fullClearText(); }
		tf1.setText(tf1.getText() + "2"); }
	
	@FXML
	void enterNumber3()
		
	{	if (tf1Empty()) { fullClearText(); }
		tf1.setText(tf1.getText() + "3"); }
	
	@FXML
	void enterNumber4()
	{	if (tf1Empty()) { fullClearText(); }
	tf1.setText(tf1.getText() + "4"); }
	
	@FXML
	void enterNumber5()
	{	if (tf1Empty()) { fullClearText(); }
	tf1.setText(tf1.getText() + "5"); }
	
	@FXML
	void enterNumber6()
	{	if (tf1Empty()) { fullClearText(); }
	tf1.setText(tf1.getText() + "6"); }
	
	@FXML
	void enterNumber7()
	{	if (tf1Empty()) { fullClearText(); }
	tf1.setText(tf1.getText() + "7"); }
	
	@FXML
	void enterNumber8()
	{	if (tf1Empty()) { fullClearText(); }
	tf1.setText(tf1.getText() + "8"); }
	
	@FXML
	void enterNumber9()
	{ if (tf1Empty()) { fullClearText(); }
	tf1.setText(tf1.getText() + "9"); }
	
	@FXML
	void enterNumber0()
	{	if (tf1Empty()) { fullClearText(); }
	tf1.setText(tf1.getText() + "0"); }
	
	@FXML
	void addition()
	{ temp = Double.valueOf(tf1.getText()); tf1.setText("0"); state[0] = true;}
	
	@FXML
	void equals()
	{ 
		if (state[0] == true)
			System.out.println(String.valueOf(Double.valueOf(tf1.getText())));
		{ tf1.setText(String.valueOf(temp + Double.valueOf(tf1.getText()))); state[0] = false;} 
	}
	
	@FXML
	void allClear()
	{ temp = 0.0; tf1.setText("0"); } 
	
	@FXML
	void clearText()
	{ tf1.setText("0"); }
	
	@FXML
	private void fullClearText()
	{ tf1.setText(""); }
	
	@FXML
	boolean tf1Empty()
	{ return tf1.getText().contentEquals("0"); };
	
}
