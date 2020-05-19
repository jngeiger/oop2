package oop2.addressBook;

import javafx.beans.property.SimpleStringProperty;

public class Person {
private SimpleStringProperty firstName;
private SimpleStringProperty lastName;
private SimpleStringProperty email;

public Person(String f, String n, String e)
{
	firstName = new SimpleStringProperty(f);
	lastName = new SimpleStringProperty(n);
	firstName = new SimpleStringProperty(e);
}

public SimpleStringProperty getFirstName()
{ return this.firstName; }

public SimpleStringProperty getLastName()
{ return this.lastName; }

public SimpleStringProperty getEmail()
{ return this.email; }
}
