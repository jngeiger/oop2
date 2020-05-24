package oop2.addressBookUebung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	
public static void main(String[] args)
{
	launch(args);
}

@Override
public void start(Stage primaryStage) throws Exception {
	// TODO Auto-generated method stub
	Parent root = FXMLLoader.load(getClass().getResource("AddressBookUebung.fxml"));
	Scene scene = new Scene(root);
	scene.getStylesheets().add(getClass().getResource("AddressBookUebung.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
	
	
}
}
