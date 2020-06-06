package oop2.addressBookClone;

import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class CustomDialog extends Dialog<ButtonType> {
private BorderPane root;
private HBox hb1;
private HBox hb2;
private HBox hb3;
private TextField tf1;
private TextField tf2;
private TextField tf3;
private Label fn;
private Label ln;
private Label em;


public CustomDialog() {
		root = new BorderPane();
		
		tf1 = new TextField();
		tf2 = new TextField();
		tf3 = new TextField();
		
		fn = new Label("Firstname");
		ln = new Label("Last Name");
		em = new Label("Email");
		VBox vb = new VBox();
		
		hb1 = new HBox();
		hb2 = new HBox();
		hb3 = new HBox();
		
		vb.getChildren().addAll(hb1,hb2,hb3);
		hb1.getChildren().addAll(fn,tf1);
		hb2.getChildren().addAll(ln,tf2);
		hb3.getChildren().addAll(em,tf3);
		
		root.setCenter(vb);
		this.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
		this.getDialogPane().getButtonTypes().add(ButtonType.APPLY);
		
		getDialogPane().setContent(root);
	}

public void sendList(ObservableList<Person> list, int index)
{
	Person p = new Person();
	p.setFirstName(list.get(index).getFirstName());
	p.setLastName(list.get(index).getLastName());
	p.setEmail(list.get(index).getEmail());
	
	
	tf1.textProperty().bindBidirectional(p.firstNameProperty());
	tf2.textProperty().bindBidirectional(p.lastNameProperty());
	tf3.textProperty().bindBidirectional(p.emailProperty());
 	
}

public void sendPerson(Person p)
{
	tf1.textProperty().bindBidirectional(p.firstNameProperty());
	tf2.textProperty().bindBidirectional(p.lastNameProperty());
	tf3.textProperty().bindBidirectional(p.emailProperty());
 	
}

public Person getSelectedPerson()
{
	return new Person(tf1.getText(),tf2.getText(),tf3.getText());
}

}
