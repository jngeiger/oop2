package oop2.statistik;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Menu1Controller implements Initializable {
@FXML GridPane root;
@FXML TextArea ta;
ArrayList<Integer> rawData = new ArrayList<Integer>();
@FXML Label validData;
SimpleBooleanProperty isValid = new SimpleBooleanProperty();
@FXML TextField tfVar;
@FXML TextField tfStandard;
Statistics engine = new Statistics();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		validData.setStyle("-fx-background-color: green;");
		
		
		ta.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				rawData.clear();
				isValid.set(true);
				int idx = 0;
				
				for (int i = 0; i < newValue.length(); i++)
				{
					if (newValue.length()-1 == i)
					{
						try {
						rawData.add(Integer.valueOf(newValue.substring(idx,i+1)));
						}
						catch (Exception e)
						{
							isValid.set(false);;
						}
					}
					if (newValue.charAt(i) == ',')
					{
						try {
						rawData.add(Integer.valueOf(newValue.substring(idx,i)));
						idx = i+1;
						}
						catch (Exception e)
						{
							isValid.set(false);;
						}
					}
				}
				engine.getVarianz(rawData);
				engine.getStandardabweichung(rawData);
				
				
			}});
		
		
		
		isValid.addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> obs, Boolean old, Boolean newVal)
			{
				if (isValid.get() == true)
				{
					validData.setStyle("-fx-background-color: green;");
					validData.setText("Gültige Eingabe");
				}
				else {
					validData.setStyle("-fx-background-color: red;");
					validData.setText("Ungültige Eingabe");
				}
			}
		});
		
		tfVar.textProperty().bind(engine.getVarianz(rawData));
		tfStandard.textProperty().bind(engine.getStandardabweichung(rawData));
		
		
		}

	
	
	
	
	public void calculate(ActionEvent event)
	{
		engine.getVarianz(rawData);
		try {
			if (isValid.get() == false)
			{
				Alert a = new Alert(AlertType.ERROR);
				a.showAndWait();
				
			}
			
		}
		catch (Exception e)
		{
			
		}
		
	}
}
