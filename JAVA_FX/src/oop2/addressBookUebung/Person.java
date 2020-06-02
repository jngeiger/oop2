package oop2.addressBookUebung;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;


public class Person implements Serializable {
public transient SimpleStringProperty firstName = new SimpleStringProperty("");
public transient SimpleStringProperty lastName  = new SimpleStringProperty("");
public transient SimpleStringProperty email  = new SimpleStringProperty("");



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
	if (this.firstName != null) {
	    this.firstName.set(f);
	} else {
	    this.firstName = new SimpleStringProperty(f);
	}
}

public void setLastName(String l)
{
	if (this.lastName != null) {
	    this.lastName.set(l);
	} else {
	    this.lastName = new SimpleStringProperty(l);
	}
}

public void setEmail(String e)
{
	if (this.email != null) {
	    this.email.set(e);
	} else {
	    this.email = new SimpleStringProperty(e);
	}
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



