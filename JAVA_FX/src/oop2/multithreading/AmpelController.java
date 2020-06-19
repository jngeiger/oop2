package oop2.multithreading;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class AmpelController implements Initializable {
@FXML Circle c1;
@FXML Circle c2;
@FXML Circle c3;
@FXML Button btn1;
@FXML Button btn2;
Thread t1;
Service<Color> s1;
@FXML TextField tf1;

public enum states { HELLO };

@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	c1.setFill(Color.TRANSPARENT);
	c1.setVisible(true);
	c1.setCenterX(100.0f); 
	c1.setCenterY(100.0f);
	c1.setStroke(Color.BLACK);
	c1.setRadius(33.0f); 
	
	c2.setFill(Color.TRANSPARENT);
	c2.setVisible(true);
	c2.setCenterX(100.0f); 
	c2.setCenterY(100.0f);
	c2.setStroke(Color.BLACK);
	c2.setRadius(33.0f); 
	
	c3.setFill(Color.TRANSPARENT);
	c3.setVisible(true);
	c3.setCenterX(100.0f); 
	c3.setCenterY(100.0f);
	c3.setStroke(Color.BLACK);
	c3.setRadius(33.0f); 
	
	
}

public void start(ActionEvent event) 
{
	
	s1 = new Service<Color>() {
		protected Task<Color> createTask()
		{
			return new Task<Color>() {
				protected Color call() throws InterruptedException
				{
					tf1.setText("STARTED");
					while (!isCancelled())
					{
							
							updateValue(Color.RED);
							Thread.sleep(1000);
							updateValue(Color.YELLOW);
							Thread.sleep(1000);
							updateValue(Color.GREEN);
							Thread.sleep(1000);
						
						
					}
					return null;
				}
			};
		};
	};
	
	s1.valueProperty().addListener(new ChangeListener<Color>() {
	
		@Override
		public void changed(ObservableValue observable, Color oldValue, Color newValue) {
			// TODO Auto-generated method stub
			if (newValue == Color.RED)
			{
				c1.setFill(newValue);
				c2.setFill(Color.TRANSPARENT);
				c3.setFill(Color.TRANSPARENT);
			}
			else if (newValue == Color.YELLOW)
			{
				c2.setFill(newValue);
				c1.setFill(Color.TRANSPARENT);
				c3.setFill(Color.TRANSPARENT);
			}
			else 
			{
				c3.setFill(newValue);
				c2.setFill(Color.TRANSPARENT);
				c1.setFill(Color.TRANSPARENT);
			}
		}
	});
	s1.start();
	
}

public void stop(ActionEvent event)
{
	s1.cancel();
	
}

}
