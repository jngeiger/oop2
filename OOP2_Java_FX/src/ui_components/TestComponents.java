package ui_components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TestComponents extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	
	Label label = new Label("Hello World!");
	
	Image house = new Image(getClass().getResourceAsStream("house.png"));
	Label graphicLabel = new Label("House", new ImageView(house));
	label.setTextFill(Color.web("blue"));
	label.setFont(Font.font("Cambria", 16));
	label.setWrapText(true);
	Button button = new Button("Test");
	button.setGraphic(new ImageView(house));
	button.setOnAction(e -> graphicLabel.setTextFill(Color.web("Green")));
	
	DropShadow shadow = new DropShadow();
	button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> button.setEffect(shadow));
	button.addEventHandler(MouseEvent.MOUSE_EXITED, e -> button.setEffect(null));
	button.getStyleClass().add("button");
	graphicLabel.setWrapText(true);
	//graphicLabel.setTranslateY(50);
	//
	//graphicLabel.setOnMouseClicked((e -> graphicLabel.setTextFill(Color.web("red"))));
	graphicLabel.setOnMousePressed((e -> graphicLabel.setTextFill(Color.web("red"))));
	graphicLabel.setOnMouseReleased((e -> graphicLabel.setTextFill(Color.web("black"))));
	graphicLabel.setOnMouseEntered((e) -> { graphicLabel.setScaleX(1.5); graphicLabel.setScaleY(1.5); });
	graphicLabel.setOnMouseExited((e) -> { graphicLabel.setScaleX(1.0); graphicLabel.setScaleY(1.0); });
	VBox vb = new VBox();
	
	ToggleGroup group = new ToggleGroup();
	RadioButton rb1 = new RadioButton("Home");
	rb1.setToggleGroup(group);
	
	RadioButton rb2 = new RadioButton("Second Home");
	rb2.setToggleGroup(group);
	
	RadioButton rb3 = new RadioButton("Third Home");
	
	vb.getChildren().add(label);
	vb.getChildren().add(graphicLabel);
	vb.getChildren().add(button);
	vb.getChildren().add(rb1);
	vb.getChildren().add(rb2);
	vb.getChildren().add(rb3);
	
	Scene scene = new Scene(vb,400,400);
	scene.getStylesheets().add(TestComponents.class.getResource("javafx.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.setTitle("Hello World!");
	primaryStage.show();
		
	}
	
	
}
