package loginMask;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

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
	
	Button btn = new Button();
	btn.setOnAction(item -> System.out.println("Hello World"));
	btn.setText("WHAT DOES THIS");
	
	
	Scene scene = new Scene(grid, 600,600);
	primaryStage.setScene(scene);
	primaryStage.show();

	
	
}
}
