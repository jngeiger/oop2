package oop2.multithreading;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.shape.Circle;


public class MultithreadingController implements Initializable {
@FXML Label timer;
@FXML ProgressBar bar;
SimpleDoubleProperty property = new SimpleDoubleProperty();
AtomicInteger test;
public Thread t;
public Service<Void> svc;

	public void initialize(URL location, ResourceBundle resources)
	{
	Circle c = new Circle();	
		
	}
	
	public void btnclick(ActionEvent event) 
	{			
		Task<Void> t1 = new Task<Void>() { 
			protected Void call() throws Exception {
				double x = 0.0;
				
				while(bar.getProgress() < 1.0 && !super.isCancelled())
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

	public void btnClickSvc(ActionEvent event)
	{
		svc = new Service<Void>() {
			protected Task<Void> createTask()
			{
				return new Task<Void>() {
					protected Void call() throws InterruptedException
					{
						double x = 0.0;
						
						while(bar.getProgress() < 1.0 && !super.isCancelled())
						{
							x += 0.01;
							super.updateProgress(x,1.0);
							Thread.sleep(200);
						
						}
						System.out.println("IM DONE");
						return null;
					}
				};
			}
			};
		bar.progressProperty().bind(svc.progressProperty());
		svc.start();
			
	}
	
	public void btnStop(ActionEvent event)
	{
		svc.cancel();
	}
	public void alive(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("IM ALIVE");
		alert.showAndWait();
		
		
	
	}

	
}
