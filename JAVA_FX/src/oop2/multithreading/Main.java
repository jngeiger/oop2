package oop2.multithreading;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage primaryStage) throws IOException
	{
//		Parent root = FXMLLoader.load(getClass().getResource("Multithreading.fxml"));
//		primaryStage.setScene(new Scene(root,200,200));
//		primaryStage.show();
		GridPane root = FXMLLoader.load(getClass().getResource("Ampel.fxml"));
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setVgap(10);
		root.setHgap(10);
		root.setAlignment(Pos.TOP_CENTER);
		Scene scene = new Scene(root,50,300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
