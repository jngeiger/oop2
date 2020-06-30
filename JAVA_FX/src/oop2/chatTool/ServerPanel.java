package oop2.chatTool;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ServerPanel extends Application {
SimpleBooleanProperty isStarted = new SimpleBooleanProperty(false);

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		isStarted.set(true); 
		GridPane test = new GridPane();
		test.getChildren().add(new Label("I'm the Server"));
		Scene sc = new Scene(test);
		Stage newStage = new Stage();
		newStage.setOnCloseRequest(x -> isStarted.set(false));
		newStage.setScene(sc);
		newStage.show();
		
		
	}
	
}
