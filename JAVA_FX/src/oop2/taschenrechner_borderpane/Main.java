package oop2.taschenrechner_borderpane;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	public void start(Stage primaryStage) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("Taschenrechner_borderpane.fxml"));
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("Taschenrechner_borderpane.css").toExternalForm());
		
		primaryStage.setTitle("Calculator BorderPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
