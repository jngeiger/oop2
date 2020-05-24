package oop2.addressBookUebung;

import javafx.beans.property.SimpleStringProperty;

public class Person {
SimpleStringProperty firstName;
SimpleStringProperty lastName;
SimpleStringProperty email;

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

public void setFirstName(String f)
{
	firstName.set(f);
}

public void setLastName(String l)
{
	lastName.set(l);
}

public void setEmail(String e)
{
	firstName.set(e);
}

public SimpleStringProperty emailProperty()
{
	return email;
}

public SimpleStringProperty firstNameProperty()
{
	return firstName;
}

public SimpleStringProperty lastNameProperty()
{
	return lastName;
}

public String getFirstName()
{
	return firstName.get();
}

public String getLastName()
{
	return lastName.get();
}

public String getEmail()
{
	return email.get();
}
}



