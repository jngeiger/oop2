package oop2.multithreading;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class MultithreadingController implements Initializable {
@FXML Label timer;
@FXML ProgressBar bar;
SimpleDoubleProperty property = new SimpleDoubleProperty();
public Thread t;
	public void initialize(URL location, ResourceBundle resources)
	{
		
	}
	
	public void btnclick(ActionEvent event)
	{
		Task<Void> t1 = new Task<Void>() { 
			protected Void call() throws Exception {
				double x = 0.0;
				
				while(bar.getProgress() < 1.0 && !isCancelled())
				{
					x += 0.01;
					super.updateProgress(x,1.0);
					
					Thread.sleep(200);
				
				}
				System.out.println("IM DONE");
				return null;
			}
			};
			bar.progressProperty().bind(t1.progressProperty());
			t = new Thread(t1);
			t.start();
			
		
			
		
	}

	
	public void alive(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("IM ALIVE");
		alert.showAndWait();
		
		if (alert.getResult() == ButtonType.OK && !t.isInterrupted())
		{
			t.interrupt();
		}
		
	}

	
}
