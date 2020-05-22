package oop2.addressBook;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AddressBookController implements Initializable {
	@FXML private TableView<Person> tableView;
    @FXML private TextField tf1;
    @FXML private TextField tf2;
    @FXML private TextField tf3;
    @FXML private Person selectedPerson = new Person();
    
    
    @FXML
    protected void deleteField()
    {
    	if (tableView.getSelectionModel().getSelectedIndex() == -1)
    	{
    		return;
    	}
    	else {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("Wirklich löschen?");
    		alert.setHeaderText("Wirklich löschen?");
    		Optional<ButtonType> result = alert.showAndWait();
    		if (result.get() == ButtonType.OK){
    			ObservableList<Person> data = tableView.getItems();
        		data.remove(tableView.getSelectionModel().getSelectedIndex());
    		} else {
    		   return;
    		}
    		
    	}
    }
    @FXML
    protected void sortByFirstName()
    {
    	ObservableList<Person> data = tableView.getItems();
    	data.sort((x,y) -> x.getFirstName().compareTo(y.getFirstName()));
    }
   
    @FXML
    protected void newMode()
    {
    	tf1.setText("");
    	tf2.setText("");
    	tf3.setText("");
    	tableView.getSelectionModel().clearSelection();
    }
    
    @FXML
    protected void addPerson(ActionEvent event) {
        ObservableList<Person> data = tableView.getItems();
        
        
        if (tableView.getSelectionModel().getSelectedIndex() != -1)
        {
        	Person p = data.get(tableView.getSelectionModel().getSelectedIndex());
        	p.setFirstName(tf1.getText());
        	p.setLastName(tf2.getText());
        	p.setEmail(tf3.getText());
        }
        
        else {
        data.add(new Person(tf1.getText(),
            tf2.getText(),
            tf3.getText()
        ));
        
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");   
        }
    }
    
    @FXML
    private void debug()
    {
    	selectedPerson.setEmail("horst@horst.de");
    }
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person("Jacob","Smith","jacob.smith@example.com"));
		list.add(new Person("Isabella","Johnson","isabella.johnson@example.com"));
		list.add(new Person("Ethan","Williams","ethan.williams@example.com"));
		list.add(new Person("Emma","Jones","isabella.emma.jones@example.com"));
		list.add(new Person("Michael","Brown","michael.brown@example.com"));
		ObservableList<Person> data = tableView.getItems();
		data.addAll(list);
        tableView.getSelectionModel().selectedItemProperty().addListener((x,y,z) -> {
        	if (z != null)
        	{
        	tf1.setText(z.getFirstName());
        	tf2.setText(z.getLastName());
        	tf3.setText(z.getEmail());
        	}
        	else {
        		return;
        	}
        });
        
        tf1.textProperty().addListener((obs,o,n) -> selectedPerson.setFirstName(n));
        tf2.textProperty().addListener((obs,o,n) -> selectedPerson.setLastName(n));
        tf3.textProperty().addListener((obs,o,n) -> selectedPerson.setEmail(n));
        selectedPerson.firstNameProperty().addListener((obs,o,n) -> tf1.setText(n));
        selectedPerson.lastNameProperty().addListener((obs,o,n) -> tf2.setText(n));
        selectedPerson.emailProperty().addListener((obs,o,n) -> tf3.setText(n));
        System.out.println(tableView.getItems().getClass());
       
	

	}
}
