package oop2.chatTool;

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
		GridPane root = FXMLLoader.load(getClass().getResource("ChatTool.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("Better than WhatsApp");
		primaryStage.show();
	}

}
