package HelloWorld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class HelloWorld extends Application {

public static void main(String[] args)
{
	launch(args);
}


@Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("Hello World!");
    Button btn = new Button();
    btn.setText("Say 'Hello World'");  
    Counter c = new Counter();
    btn.setOnAction(event -> { 
    	if (c.get() >= 9) 
    	{ 
    		System.out.println("Jetzt ist's aber mal gut!"); 
    	}
    	else { 
    		System.out.println("Hallo Welt"); 
    		c.add();
    	}  
    	});
    
    StackPane root = new StackPane();
    root.getChildren().add(btn);
    primaryStage.setScene(new Scene(root, 600, 250));
    primaryStage.show();
}



}
