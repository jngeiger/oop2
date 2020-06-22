package oop2.addressBookClone;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.stage.FileChooser.ExtensionFilter;
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
	
	public void newMode(ActionEvent event)
	{
		clearTf();
		clearSelection();
	}
	
	public void close()
	{
		Platform.exit();
	}
	
	public void action1(MouseEvent e)
	{
		if (e.getClickCount() >= 2 && tv.getSelectionModel().getSelectedIndex() != -1)
		{
			CustomDialog c = new CustomDialog();
			Person tempPerson = new Person(selectedPerson.getFirstName(),selectedPerson.getLastName(),selectedPerson.getEmail());
			c.sendPerson(tempPerson);
			if (c.showAndWait().get() == ButtonType.APPLY)
			{
				tv.getItems().set(tv.getSelectionModel().getSelectedIndex(),tempPerson);
			}	
		}
	}
	
	
	@FXML 
	public void saveState() 
	{
		FileChooser fc = new FileChooser();
		fc.setTitle("Save Data");
		fc.getExtensionFilters().add(new ExtensionFilter("DAT File","*.dat"));
		File file = fc.showSaveDialog(stage);
		int count = 0;
		if (file != null)
		{
			try {
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
			
				for (int i = 0; i < tv.getItems().size(); i++)
				{
					stream.writeObject(tv.getItems().get(i));
					count ++;
				}
			}
			catch (EOFException e) {
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("Erfolg");
				a.setHeaderText(count + " Elemente geschrieben");
				a.showAndWait();
			}
			catch (FileNotFoundException e) { 
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("Fehler");
				a.setHeaderText("Fehler beim Export");
				a.showAndWait();
			}
			catch (IOException e) { 
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("Fehler");
				a.setHeaderText("Fehler beim Export");
				a.showAndWait();
			}
			catch (Exception e)
			{}
		}
		
	}
	
	@FXML 
	public void loadState() 
	{
		FileChooser fc = new FileChooser();
		fc.setTitle("Load File");
		fc.getExtensionFilters().add(new ExtensionFilter("DAT File","*.dat"));
		File file = fc.showOpenDialog(stage);
		ArrayList<Person> list = new ArrayList<Person>();
		int count = 0;
		if (file != null)
		{
			{
				try {
					ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file));
					while (true)
					{
						list.add((Person)stream.readObject());
						count++;
					}
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (EOFException e) {
					tv.getItems().clear();
					tv.getItems().addAll(list);
					Alert a = new Alert(AlertType.INFORMATION);
					a.setTitle("Erfolg");
					a.setHeaderText(count + " Elemente geladen");
					a.showAndWait();
				}
				catch (FileNotFoundException e)
				{
					Alert a = new Alert(AlertType.ERROR);
					a.setTitle("Fehler");
					a.setHeaderText("Fehler beim Import");
					a.showAndWait();
				}
				catch (IOException e)
				{
					Alert a = new Alert(AlertType.ERROR);
					a.setTitle("Fehler");
					a.setHeaderText("Fehler beim Import");
					a.showAndWait();
				}
			}
			
		}
		
		
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
