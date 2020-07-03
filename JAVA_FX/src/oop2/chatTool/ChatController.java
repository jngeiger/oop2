package oop2.chatTool;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChatController implements Initializable {
Stage stage;
@FXML Button srvbtn;
ServerPanel panel;
@FXML TextField srvPort;

	public void initialize(URL url, ResourceBundle rbl)
	{
		panel = new ServerPanel();
		srvbtn.disableProperty().bind(panel.isStarted);
		
		
		
		
	}
	
	public void setStage(Stage someStage)
	{
		this.stage = someStage;
	}
	
	public void startServer(ActionEvent event)
	{
		try {
			panel.lbl = srvPort;
			panel.start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startClient(ActionEvent event)
	{
		try {
			ClientPanel cp = new ClientPanel();
			cp.start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
