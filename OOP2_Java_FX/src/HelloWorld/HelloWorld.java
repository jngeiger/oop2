package HelloWorld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
    primaryStage.setTitle("First FX program of jngeiger!");
    var btn = new Button();
    btn.setText("Say 'Hello World'"); 
    var btn2 = new Button();
    btn2.setText("Exit");
    var c = new Counter();
    btn2.setOnAction(event -> { System.exit(0); }); 
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
    root.getChildren().add(btn2);
    StackPane.setAlignment(btn, Pos.CENTER);
    StackPane.setAlignment(btn2, Pos.BOTTOM_CENTER);
    primaryStage.setScene(new Scene(root, 300, 200));
    primaryStage.show();
}



}
