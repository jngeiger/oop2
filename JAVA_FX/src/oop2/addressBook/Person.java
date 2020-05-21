package oop2.addressBook;

import javafx.beans.property.SimpleStringProperty;

public class Person {
SimpleStringProperty firstName = new SimpleStringProperty("");
SimpleStringProperty lastName = new SimpleStringProperty("");
SimpleStringProperty email = new SimpleStringProperty("");

public Person()
{}

public Person(String f, String n, String l)
{
	firstName.set(f);
	lastName.set(n);
	email.set(l);
}

public String getLastName()
{
	return lastName.get();
}
public String getFirstName()
{
	return firstName.get();
}
public String getEmail()
{
	return email.get();
}

public void setLastName(String f)
{
	lastName.set(f);
}
public void setFirstName(String f)
{
	firstName.set(f);
}
public void setEmail(String f)
{
	email.set(f);
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

}