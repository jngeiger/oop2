package oop2.taschenrechner_programmatisch;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class Main extends Application {
TextField txtResult = new TextField();
	public static void main(String[] args)
	{
		launch(args);
	}
	
	public void start(Stage primaryStage) throws IOException
	{
		GridPane root = new GridPane();
		Scene scene = new Scene(root,150,200);
		root.setHgap(2); root.setVgap(2);
		root.setPadding(new Insets(10,10,10,10));
		
		var rc = new RowConstraints();
		rc.setVgrow(Priority.ALWAYS);
		for (int i = 0; i < 5; i++)
		{
			root.getRowConstraints().add(i,rc);
		}
		
		var cc = new ColumnConstraints();
		cc.setHgrow(Priority.ALWAYS);
		for (int i = 0; i < 4; i++)
		{
			root.getColumnConstraints().add(i,cc);
		}
		
		
		//TEXT
		txtResult = new TextField();
		txtResult.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		root.add(txtResult, 0, 0,3,1);
		
		
		// BUTTONS
		for (int i = 0; i < 9; i++)
		{
			int column = i%3; int row = i/3+1;
			addButton(root,String.valueOf(i+1),column,row);
		}
		
		// lower row
		addButton(root,"0",0,4);
		addButton(root,"<-",1,4);
		addButton(root,"C",2,4);
		
		// right column
		addButton(root,"=",3,0);
		addButton(root,"+",3,1);
		addButton(root,"-",3,2);
		addButton(root,"*",3,3);
		addButton(root,"/",3,4);
		
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Calculator");
		

		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void addButton(GridPane parent, String text, int column, int row)
	{
		var btn = new Button(text);
		btn.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		btn.setOnAction(x -> {
			String ButtonAction = ((Button) x.getSource()).getText();
			txtResult.setText(ButtonAction);
		});
		parent.add(btn, column, row);
	}
}
