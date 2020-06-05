package oop2.addressBookUebung;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddressBookUebungController implements Initializable {
@FXML private TableView<Person> tv;
private ObservableList<Person> data;
@FXML private TextField tf1;
@FXML private TextField tf2;
@FXML private TextField tf3;
@FXML private Button deleteBtn;
@FXML private Button saveBtn;
@FXML private Text ctrlText;
private Person selectedPerson;
private SimpleBooleanProperty isSelected = new SimpleBooleanProperty(false);
private SimpleBooleanProperty allTfSelected = new SimpleBooleanProperty(false);
private SimpleBooleanProperty tf1WasFocused = new SimpleBooleanProperty(false);
private SimpleBooleanProperty tf2WasFocused = new SimpleBooleanProperty(false);
private SimpleBooleanProperty tf3WasFocused = new SimpleBooleanProperty(false);
private Stage stage;


	@Override
	public void initialize(URL location, ResourceBundle resource)
	{
		data = tv.getItems();
		
		selectedPerson = new Person();
		tf1.textProperty().bindBidirectional(selectedPerson.firstName);
		tf2.textProperty().bindBidirectional(selectedPerson.lastName);
		tf3.textProperty().bindBidirectional(selectedPerson.email);
		
		isSelected.bind(tv.getSelectionModel().selectedIndexProperty().greaterThan(-1));
		ctrlText.textProperty().bind(Bindings.when(isSelected).then("Edit Mode").otherwise("Create Mode"));
		
		allTfSelected.bind(Bindings.when(tf1.textProperty().isNotEmpty().and(tf2.textProperty().isNotEmpty().and(tf3.textProperty().isNotEmpty()))).then(true).otherwise(false));
		saveBtn.disableProperty().bind(allTfSelected.not());
		

		tf1.focusedProperty().addListener((obs,o,n) -> {
			if (!n == false)
				tf1WasFocused.set(true);
		});
		
		tf2.focusedProperty().addListener((obs,o,n) -> {
			if (!n == false)
				tf2WasFocused.set(true);
		});
		
		tf3.focusedProperty().addListener((obs,o,n) -> {
			if (!n == false)
				tf3WasFocused.set(true);
		});

		
		
		
		tf1.styleProperty().bind(Bindings.when(tf1.textProperty().isEmpty().and(tf1WasFocused)).then("-fx-border-color: red;").otherwise(""));
		tf2.styleProperty().bind(Bindings.when(tf2.textProperty().isEmpty().and(tf2WasFocused)).then("-fx-border-color: red;").otherwise(""));
		tf3.styleProperty().bind(Bindings.when(tf3.textProperty().isEmpty().and(tf3WasFocused)).then("-fx-border-color: red;").otherwise(""));
		
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
		MyDialog dialog = new MyDialog(getStage());
		tv.setOnMouseClicked(e -> {
			if (e.getClickCount() >= 2 && tv.getSelectionModel().getSelectedIndex() != -1)
			{
				dialog.sendTableView(tv);
				Optional<ButtonType> opt = dialog.showAndWait(); 
				if (opt.get() == ButtonType.APPLY)
				{
					int index = tv.getSelectionModel().getSelectedIndex();
					tv.getItems().set(tv.getSelectionModel().getSelectedIndex(), dialog.getSelectedPerson());
				    tv.getSelectionModel().select(index);
				    tv.getFocusModel().focus(index);
				}
			}
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
		tf1WasFocused.set(false);
		tf2WasFocused.set(false);
		tf3WasFocused.set(false);
	}
	
	public void clearTf()
	{
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
	}
	
	public void newMode()
	{
		clearTf();
		clearSelection();
	}
	
	public void close()
	{
		Platform.exit();
	}
	
	@FXML 
	public void saveState()
	{
		FileChooser fc = new FileChooser();
		fc.setTitle("Save State");
		File selectedFile = fc.showSaveDialog(getStage());
		if (selectedFile != null)
		{
			try (ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(selectedFile)))
			{
				for (Person p : tv.getItems())
				{
					oout.writeObject(p);
				}
			} 
			catch (EOFException e) {}
			catch (IOException e) {e.printStackTrace();}
		}
		
	}
	
	@FXML 
	public void loadState() throws ClassNotFoundException
	{
		int count = 0;
		FileChooser fc = new FileChooser();
		fc.setTitle("Load State");
		File selectedFile = fc.showOpenDialog(getStage());
		if (selectedFile != null)
		{
			try 
			{
				tv.getItems().clear();
				count = 0;
				ObjectInputStream oin = new ObjectInputStream(new FileInputStream(selectedFile));
				while(true)
				{
					tv.getItems().add((Person)oin.readObject());
					count++;
				}
				
			
			}
			
			catch (EOFException e) {showLoadAlert(count,true);}
			catch (Exception e) { showLoadAlert(count, false); }
		}
		
	}
	
	public void showLoadAlert(int count, boolean value)
	{
		Alert a = new Alert(AlertType.INFORMATION);
		if (value)
		{
		a.setTitle("Erfolgreich");
		a.setHeaderText("Erfolgreich");
		a.setContentText(String.valueOf(count + " Elemente kopiert"));
		}
		else {
			a.setTitle("Fehler");
			a.setHeaderText("Fehler");
			a.setContentText(String.valueOf("Keine Elemente kopiert"));
		}
		a.showAndWait();
	}
	
	public void setStage(Stage someStage)
	{
		stage = someStage;
	}
	public Stage getStage()
	{
		return stage;
	}

}
