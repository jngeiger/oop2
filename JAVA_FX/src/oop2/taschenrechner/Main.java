package oop2.taschenrechner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("Taschenrechner.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("Taschenrechner.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			TextField tf = new TextField();
			tf.setEditable(false);
		}
		catch (Exception e)
		{
			e.getStackTrace();
		}
	}

}
