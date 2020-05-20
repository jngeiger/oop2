package oop2.addressBook;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AddressBookController implements Initializable {
	@FXML private TableView<Person> tableView;
    @FXML private TextField tf1;
    @FXML private TextField tf2;
    @FXML private TextField tf3;
    
    @FXML
    protected void addPerson(ActionEvent event) {
        ObservableList<Person> data = tableView.getItems();
        data.add(new Person(tf1.getText(),
            tf2.getText(),
            tf3.getText()
        ));
        
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");   
    }
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	

	}

}
