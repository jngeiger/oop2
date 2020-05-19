package oop2.taschenrechner_properties;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Taschenrechner_propertiesController {
@FXML TextField tf1;
DoubleProperty temp1 = new SimpleDoubleProperty(0.0);
DoubleProperty temp2 = new SimpleDoubleProperty(0.0);
DoubleProperty result = new SimpleDoubleProperty(0.0);



	
	@FXML
	void enterNumber(ActionEvent event)
	{{	if (tf1Empty()) { fullClearText(); } tf1.setText(tf1.getText() + ((Button) event.getSource()).getText()); tf1.requestFocus();}}
	
	@FXML
	void maths(ActionEvent event)
	{
	if (temp1.getValue().equals(0.0))
	{
			temp1.set(Double.valueOf(tf1.getText()));
			
	}
	
	
	if (((Button) event.getSource()).getText().contentEquals("+")) 
	{
			result.bind(temp1.add(temp2));
			tf1.setText("0");
			return;
	}
	
	if (((Button) event.getSource()).getText().contentEquals("-")) 
	{
			result.bind(temp1.subtract(temp2));
			tf1.setText("0");
			return;
	}
	
	if (((Button) event.getSource()).getText().contentEquals("*")) 
	{
			result.bind(temp1.multiply(temp2));
			tf1.setText("0");
			return;
	}
	
	if (((Button) event.getSource()).getText().contentEquals("/")) 
	{
			result.bind(temp1.divide(temp2));
			tf1.setText("0");
			return;
	}
			
		
	}
	
	
	
	@FXML
	void equals()
	{ temp2.setValue(Double.valueOf(tf1.getText())); tf1.setText(String.valueOf(result.getValue())); result.unbind(); temp1.set(0.0); temp2.set(0.0);;}
	@FXML
	void addition()
	{ temp1.set(Double.valueOf(tf1.getText())); result.bind(temp1.add(temp2)); tf1.setText("0"); }
	@FXML
	void clearText()
	{ tf1.setText("0"); tf1.requestFocus();}
	
	@FXML
	private void fullClearText()
	{ tf1.setText(""); }
	
	@FXML
	boolean tf1Empty()
	{ return tf1.getText().contentEquals("0"); };
	
	@FXML
	void allClear()
	{ tf1.setText("0"); result.unbind(); temp1.set(0.0); temp2.set(0.0); }
}
