package oop2.addressBook2;

import javafx.beans.property.SimpleStringProperty;

public class Person {
public SimpleStringProperty firstName = new SimpleStringProperty("");
public SimpleStringProperty lastName = new SimpleStringProperty("");
public SimpleStringProperty email = new SimpleStringProperty("");

public Person()
{
	this("","","");
}

public Person(String f, String l, String e)
{
	firstName = new SimpleStringProperty(f);
	lastName = new SimpleStringProperty(l);
	email = new SimpleStringProperty(e);
}

public String getFirstName() {
	return firstName.getValue();
}



public String getLastName() {
	return lastName.getValue();
}


public String getEmail() {
	return email.getValue();
}



public void setFirstName(String f) {
	this.firstName.set(f);;
}

public void setLastName(String l) {
	this.lastName.set(l);
}

public void setEmail(String e) {
	this.email.set(e);
}

public SimpleStringProperty firstNameProperty()
{
	return firstName;
}
public SimpleStringProperty lastNameProperty()
{
	return lastName;
}
public SimpleStringProperty emailProperty()
{
	return email;
}

public Person copy()
{
	Person p = new Person(this.getFirstName(),this.getLastName(),this.getEmail());
	return p;
}


}
