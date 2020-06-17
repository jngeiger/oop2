package oop2.multithreading;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class AmpelController implements Initializable {
@FXML Circle c1;
@FXML Circle c2;
@FXML Circle c3;
@FXML Button btn1;
@FXML Button btn2;
Thread t1;

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
	t1 = new Thread() {
		public void run()
		{
			while (true)
			{
				try {
					c3.setFill(Color.TRANSPARENT);
					c1.setFill(Color.RED);
					Thread.sleep(1000);
					c1.setFill(Color.TRANSPARENT);
					c2.setFill(Color.YELLOW);
					Thread.sleep(1000);
					c2.setFill(Color.TRANSPARENT);
					c3.setFill(Color.GREEN);
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	};
	t1.start();
}

public void stop(ActionEvent event)
{
	t1.stop();
}

}
