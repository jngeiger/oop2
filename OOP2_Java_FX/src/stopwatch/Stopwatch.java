package stopwatch;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.stage.*;

public class Stopwatch extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	
	public void start(Stage primaryStage)
	{
		// Variables
		Time t1 = new Time();
		
		// Box Parameters
		VBox box = new VBox();
		
		// Button declarations
		Button startBtn = new Button();
		Button stopBtn = new Button();
		startBtn.setText("Start");
		stopBtn.setText("Stop");
		
		// Textfield
		TextField fieldOut = new TextField();
		
		// Actions
		startBtn.setOnAction(e -> {
		fieldOut.setText("0.0");
		t1.startTimer();
		});
		
		stopBtn.setOnAction(e -> { 
			fieldOut.setText(Double.toString(t1.getElapsedTime() / 1000) + " Sekunden!");
			t1.close();
			
		});
		
		
		// Modify HBox
		box.getChildren().add(fieldOut);
		box.getChildren().add(startBtn);
		box.getChildren().add(stopBtn);
		
		
		// Meta layer
		Scene scene1 = new Scene(box,400,200);
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Stopwatch v0.1");
		primaryStage.show();
	}

}
