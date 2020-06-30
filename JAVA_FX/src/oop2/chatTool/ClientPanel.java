package oop2.chatTool;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClientPanel extends Application {

		@Override
		public void start(Stage primaryStage) throws Exception {
			// TODO Auto-generated method stub
			
			
			GridPane test = new GridPane();
			
			test.getChildren().add(new Label("Im a Client"));
			Scene sc = new Scene(test);
			Stage newStage = new Stage();
			newStage.setScene(sc);
			newStage.show();
			
			
		}
		
}

