package oop2.addressBookUebung;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;


public class Person implements Serializable {
public transient SimpleStringProperty firstName;
public transient SimpleStringProperty lastName;
public transient SimpleStringProperty email;



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
	email.set(e);
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

public Person copy(Person p)
{
	Person x = new Person(p.getFirstName(),p.getLastName(),p.getEmail());
	return x;
}

private void writeObject(ObjectOutputStream s) throws IOException 
{
	s.defaultWriteObject();
    s.writeUTF(getFirstName());
    s.writeUTF(getLastName());
    s.writeUTF(getEmail());
}

private void readObject(ObjectInputStream s) throws ClassNotFoundException, IOException 
{       
	s.defaultReadObject();
	setFirstName(s.readUTF());
	setLastName(s.readUTF());
	setEmail(s.readUTF());
}


}



