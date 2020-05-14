package oop2.taschenrechner;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Taschenrechner.fxml"));
			
			Scene scene = new Scene(root,130,200);
			scene.getStylesheets().add(getClass().getResource("Taschenrechner.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Calculator");
			primaryStage.show();
			
			IntegerProperty v1 = new
					SimpleIntegerProperty();
					IntegerProperty v2 = new
					SimpleIntegerProperty();
					v1.bindBidirectional(v2);
					v2.set(17);
					System.out.println(v1.get()); // -> 17
					v1.set(10); 
					
			IntegerProperty v3 = new SimpleIntegerProperty();
			
					v3.addListener((x,y,z) ->  System.out.println("Value changed:, du arschloch " + z)); 
					v3.set(42);
					
					IntegerProperty x1 = new SimpleIntegerProperty();
					IntegerProperty x2 = new SimpleIntegerProperty();
					IntegerProperty x3 = new SimpleIntegerProperty();
					IntegerProperty r = new SimpleIntegerProperty();
					IntegerProperty z = new SimpleIntegerProperty();
					IntegerProperty x4 = new SimpleIntegerProperty();
					x4.set(0);

					var f = x3.add((x1.multiply(x2)));
					r.bind(Bindings.add(x1.multiply(x2),x3));
					z.bind(f);
					
					x1.set(2);
					x2.set(3);
					x3.set(4);
					System.out.println(r.get()); // -> 10
					System.out.println(z.get()); // -> 10
					
					x1.set(5);
					System.out.println(r.get()); // -> 19
					System.out.println(z.get()); // -> 21
					x3.set(6);
					System.out.println(r.get()); // -> 19
					System.out.println(z.get()); // -> 21
					
					
					
					
					
					

}
}