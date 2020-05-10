package oop2.taschenrechner_muster;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	public void start(Stage primaryStage) throws IOException
	{
		GridPane root = new GridPane();
		Scene scene = new Scene(root,400,200);
		scene.getStylesheets().add(getClass().getResource("Taschenrechner_muster.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Calculator");
		
		Button b = new Button();
		root.add(b, 0, 0);
	}
	
}
