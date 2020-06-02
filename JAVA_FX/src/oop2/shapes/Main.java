package oop2.shapes;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class Main extends Application {
	
public static void main(String[] args)
{
	launch(args);
}

@Override
public void start(Stage primaryStage) throws Exception {
	VBox root = new VBox();
	root.getChildren().add(new Box(2,2,2));
	Scene scene = new Scene(root,200,200);
	primaryStage.setScene(scene);
	primaryStage.show();
}

}
