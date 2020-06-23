package oop2.addressBookClone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
	
public static void main(String[] args)
{
	launch(args);
}

@Override
public void start(Stage primaryStage) throws Exception {
	// TODO Auto-generated method stub
	FXMLLoader loader = new FXMLLoader(getClass().getResource("AddressBookUebung.fxml"));
	GridPane root = loader.load();
	AddressBookUebungController  controller = loader.getController();
	controller.setStage(primaryStage);
	Scene scene = new Scene(root);
	scene.getStylesheets().add(getClass().getResource("AddressBookUebung.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();	
	
	
}
}
