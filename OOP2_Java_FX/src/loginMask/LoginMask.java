package loginMask;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.*;

public class LoginMask extends Application {
public static void main(String[] args)
{
	launch(args);
}

@Override
public void start(Stage primaryStage) {
	
	GridPane grid = new GridPane();
	grid.setAlignment(Pos.CENTER);
	grid.setHgap(10);
	grid.setVgap(10);
	grid.setPadding(new Insets(25,25,25,25));
	
	//grid.setGridLinesVisible(true);
	
	Text scenetitle = new Text("Welcome");
	scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL,20));
	grid.add(scenetitle, 0, 0, 2, 1);
	
	Label userName = new Label("User Name: ");
	grid.add(userName, 0, 1);
	
	TextField userTextField = new TextField();
	grid.add(userTextField, 1, 1);
	
	Label pw = new Label("Password:");
	grid.add(pw, 0, 2);
	
	PasswordField pwBox = new PasswordField();
	grid.add(pwBox, 1, 2);
	
	final Text actiontarget = new Text();
	grid.add(actiontarget, 1, 6);
	
	Button btn = new Button("Sign in");
	btn.setOnAction((e) -> { 
		actiontarget.setFill(Color.FIREBRICK);
		actiontarget.setText("Sign in button pressed"); });
		
	HBox hbBtn = new HBox(10);
	hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	hbBtn.getChildren().add(btn);
	grid.add(hbBtn, 1, 4);
	
	
	
	
	
	primaryStage.setTitle("Login Mask");
	Scene scene = new Scene(grid, 300,200);
	primaryStage.setScene(scene);
	loginMask.LoginMask.class.getResource("login.css").toExternalForm();
	primaryStage.show();

	
	
}
}
