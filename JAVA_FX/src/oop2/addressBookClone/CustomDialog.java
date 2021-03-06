package oop2.addressBookClone;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
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
private Person selectedPerson;


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



public void sendPerson(Person p)
{
	selectedPerson = new Person();
	selectedPerson = p;
	tf1.textProperty().bindBidirectional(selectedPerson.firstNameProperty());
	tf2.textProperty().bindBidirectional(selectedPerson.lastNameProperty());
	tf3.textProperty().bindBidirectional(selectedPerson.emailProperty());
 	
}



public Person getSelectedPerson()
{
	return selectedPerson;
}

}
