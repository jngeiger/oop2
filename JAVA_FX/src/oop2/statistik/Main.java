package oop2.statistik;

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
	
	public void start(Stage primaryStage) throws Exception
	{
		GridPane root = FXMLLoader.load(getClass().getResource("Menu1.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Statistik Rechner v0.1");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
