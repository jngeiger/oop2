package oop2.taschenrechner_grid;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	public void start(Stage primaryStage) throws IOException
	{
		GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("Taschenrechner_grid.fxml"));
		
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("Taschenrechner_grid.css").toExternalForm());
		
		primaryStage.setTitle("Calculator GridPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
