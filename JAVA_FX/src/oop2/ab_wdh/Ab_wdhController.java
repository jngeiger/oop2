package oop2.ab_wdh;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Ab_wdhController implements Initializable {
@FXML GridPane root;
@FXML Button btn;
	public void initialize(URL link, ResourceBundle resource)
	{
		
		btn = new Button("Test");
		btn.setMaxHeight(2000);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
			{
				Label lbl = new Label("HALLO");
				lbl.setOnMouseClicked(new EventHandler<MouseEvent>()
				{
					public void handle(MouseEvent e)
					{
						System.out.println("I WAS CLICKED");
					}
				});
				root.getChildren().add(lbl);
				GridPane.setColumnIndex(lbl, 0);
				GridPane.setRowIndex(lbl, 1);
				
			}
		});
		Slider slider = new Slider();
		MenuBar mb = new MenuBar();
		root.add(mb, 0, 4);
		root.add(slider, 0, 2);
		
		TextArea ta = new TextArea();
		ta.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> oval, String oldval, String newVal)
			{
				
			}
		});
		
		root.add(ta, 0, 3);
		root.getChildren().add(btn);
	}

	
}
