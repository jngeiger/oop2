package oop2.addressBook;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddressBookController implements Initializable {
	private ObservableList<Person> list;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		list = FXCollections.observableArrayList();
		list.add(new Person("test", "test", "test"));
		System.out.println(list.get(0));

	}

	public static void main(String[] args) {
		new AddressBookController().initialize(null, null);
	}

}
