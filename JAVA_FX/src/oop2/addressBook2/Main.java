package oop2.addressBook2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
public static void main(String[] args)
{
	launch(args);
}

@Override
public void start(Stage primaryStage) throws Exception {
	// TODO Auto-generated method stub
	Parent root = FXMLLoader.load(getClass().getResource("AddressBook2.fxml"));
	Scene scene = new Scene(root,800,800);
	scene.getStylesheets().add(getClass().getResource("AddressBook2.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.setTitle("Address Book");
	primaryStage.show();
}
}
