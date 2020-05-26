package oop2.addressBookUebung;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AddressBookUebungController implements Initializable {
@FXML private TableView<Person> tv;
private ObservableList<Person> data;
@FXML private TextField tf1;
@FXML private TextField tf2;
@FXML private TextField tf3;
@FXML private Button deleteBtn;
private Person selectedPerson;


	
	@Override
	public void initialize(URL location, ResourceBundle resource)
	{
		data = tv.getItems();
		data.add(new Person("Max","Mustermann","mm@test.de"));
		
		selectedPerson = new Person();
		tf1.textProperty().bindBidirectional(selectedPerson.firstName);
		tf2.textProperty().bindBidirectional(selectedPerson.lastName);
		tf3.textProperty().bindBidirectional(selectedPerson.email);
		
		
		
		deleteBtn.disableProperty().bind(tv.getSelectionModel().selectedItemProperty().isNull());
		
		
		tv.getSelectionModel().selectedItemProperty().addListener((obs,o,n) -> {
			if (n == null)
			{
				return;
			}
			selectedPerson.setFirstName(n.getFirstName());
			selectedPerson.setLastName(n.getLastName());
			selectedPerson.setEmail(n.getEmail());
		});
		
		
	}
	
	public void delete()
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.showAndWait();
		if (alert.getResult() == ButtonType.OK)
		{
		tv.getSelectionModel().getSelectedIndex();
		data.remove(tv.getSelectionModel().getSelectedIndex());
		}
		tf1.setText("");
		clearTf();
	}
	
	public void save()
	{
		if (tv.getSelectionModel().getSelectedIndex() == -1)
		{
			data.add(new Person(selectedPerson.getFirstName(),selectedPerson.getLastName(),selectedPerson.getEmail()));
		}
		else {
			data.set(tv.getSelectionModel().getSelectedIndex(), new Person(selectedPerson.getFirstName(),selectedPerson.getLastName(),selectedPerson.getEmail()));
		}
		clearSelection();
		clearTf();
	}
	
	public void clearSelection()
	{
		tv.getSelectionModel().clearSelection();
	}
	
	public void clearTf()
	{
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
	}

}
