package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SampleController {
	
	@FXML
    void printHello(ActionEvent event) {
			System.out.println("Hello World");
    }
}
