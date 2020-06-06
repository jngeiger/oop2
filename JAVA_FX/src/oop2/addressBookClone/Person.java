package oop2.addressBookClone;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;


public class Person implements Serializable {
public SimpleStringProperty firstName = new SimpleStringProperty("");
public SimpleStringProperty lastName  = new SimpleStringProperty("");
public SimpleStringProperty email  = new SimpleStringProperty("");



public Person()
{
	this("","","");
}

public Person(String f, String l, String e)
{
	firstName.set(f);
	lastName.set(l);
	email.set(e);
}

public void setFirstName(String f)
{

	    this.firstName.set(f);

}

public void setLastName(String l)
{

	    this.lastName.set(l);

}

public void setEmail(String e)
{

	    this.email.set(e);

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
	
    s.writeUTF(firstName.getValueSafe());
    s.writeUTF(lastName.getValueSafe());
    s.writeUTF(email.getValueSafe());
}

private void readObject(ObjectInputStream s) throws ClassNotFoundException, IOException 
{       
	
	firstName = new SimpleStringProperty(s.readUTF());
	lastName = new SimpleStringProperty(s.readUTF());
	email = new SimpleStringProperty(s.readUTF());
}


}



