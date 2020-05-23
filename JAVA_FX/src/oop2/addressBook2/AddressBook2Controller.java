package oop2.addressBook2;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AddressBook2Controller implements Initializable {
@FXML private TableView<Person> tv;
@FXML private TextField tf1;
@FXML private TextField tf2;
@FXML private TextField tf3;
@FXML private Person selectedPerson;
@FXML private int selectedIndex;
@FXML private ObservableList<Person> data;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		var list = new ArrayList<Person>();
		list.add(new Person("Test","Tester","tester3@test.de"));
		list.add(new Person("Manuel","Daum","manuel@manueldaum.de"));
		list.add(new Person("Danuel","Maum","danuel@danuelmaum.de"));
		data = tv.getItems();
		data.addAll(list);
		
		selectedPerson = new Person();
		tv.getSelectionModel().selectedItemProperty().addListener((obs,o,n) -> selectPerson(n));
		tv.getSelectionModel().selectedIndexProperty().addListener((obs,o,n) -> selectedIndex = n.intValue());
		
		tf1.textProperty().bindBidirectional(selectedPerson.firstName);
		tf2.textProperty().bindBidirectional(selectedPerson.lastName);
		tf3.textProperty().bindBidirectional(selectedPerson.email);
		
	}
	
	public void selectPerson(Person p)
	{
		if (p == null) return;
		
		selectedPerson.setFirstName(p.getFirstName());
		selectedPerson.setLastName(p.getLastName());
		selectedPerson.setEmail(p.getEmail());
	}
	
	@FXML 
	public void save(ActionEvent e)
	{
		if (selectedIndex == -1)
		{
			data.add(selectedPerson.copy());
		}
		else {
			data.set(selectedIndex, selectedPerson.copy());
		}
	}
	
	@FXML
	public void unselect()
	{
		tv.getSelectionModel().clearSelection();
	}
	
	@FXML
	public void delete()
	{
		if (tv.getSelectionModel().getSelectedIndex() != -1)
		{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Willste löschen?");
			alert.showAndWait();
			if (alert.getResult() == ButtonType.OK)
				data.remove(tv.getSelectionModel().getSelectedIndex());
			unselect();
		}
		
	}

}
