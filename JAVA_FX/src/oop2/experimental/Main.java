package oop2.experimental;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage primaryStage)
	{
		GridPane root = new GridPane();
		Scene scene = new Scene(root);
		TextArea ta = new TextArea();
		TextArea tb = new TextArea();
		ta.textProperty().bindBidirectional(tb.textProperty());
		root.add(ta, 0,0);
		root.add(tb, 0, 1);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

}
