package oop2.chatTool;

import java.io.IOException;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ServerPanel extends Application {
SimpleBooleanProperty isStarted = new SimpleBooleanProperty(false);
TextField lbl;
TextArea ta;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		EchoServer s = new EchoServer(Integer.valueOf(lbl.getText()));
		s.run();
		
		isStarted.set(true);
		ta.textProperty().bind(s.getText()):
		GridPane test = new GridPane();
		test.getChildren().add(new Label("I'm the Server"));
		Scene sc = new Scene(test);
		Stage newStage = new Stage();
		
		newStage.setOnCloseRequest(x -> { 
			isStarted.set(false);
			try {
				s.serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		newStage.setScene(sc);
		newStage.show();
		
		
	}
	
}
