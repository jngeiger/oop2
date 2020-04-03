package person_week2;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private Address[] addresses;
	private int addTop;
	
public Person(String f, String l, int a) {
	this.age  = a;
	this.firstName = f;
	this.lastName = l;
	this.addresses = new Address[3];
}

public void addAddress(Address a) throws Exception
{
	for (int i = 0; i < addresses.length; i++)
	{
		if (addresses[i] == null)
			continue;
		if (a.getType() == addresses[i].getType())
		{
			throw new Exception("Type already exists!");
		}
	}
	switch (a.getType())
	{
	case PRIMARY: addresses[0] = a; break;
	case SECONDARY: addresses[1] = a; break;
	case SECRET: addresses[2] = a; break;
	}
}

public int getAge()
{
	return this.age;
}
@Override
public String toString()
{
	String s =  this.firstName + " " + this.lastName + "(" + this.age + ") " + "[";
	if (addresses[0] != null)
	{
		s += "Primary Address (" + this.addresses[0] + ")";
		if (addresses[1] != null) s += ",";
	}
	if (addresses[1] != null)
	{
		s += "Secondary Address (" + this.addresses[1] + ")";
		if (addresses[1] != null)  s += ",";
	}
	if (addresses[2] != null)
	{
		s += "Secret Address (" + this.addresses[2] + ")]";
	}
	return s;
}

public static void main(String[] args) throws Exception
{
	ArrayList<Person> list = new ArrayList<Person>();
	list.add(new Person("Max", "Mustermann" , 19));
	list.add(new Person("Chris", "May",21));
	list.add(new Person("Steve", "Clover", 25));
	list.get(0).addAddress(new Address(DESCRIPTION.PRIMARY, "Teststreet 1", "Hof", 95028));
	list.get(0).addAddress(new Address(DESCRIPTION.SECONDARY, "Teststreet 2", "Hof", 95028));
	list.get(1).addAddress(new Address(DESCRIPTION.PRIMARY, "Teststreet 19", "Hof", 95030));
	list.get(1).addAddress(new Address(DESCRIPTION.SECONDARY, "Teststreet 20", "Hof", 95028));
	list.get(1).addAddress(new Address(DESCRIPTION.SECRET, "Secretstreet 1", "Bayreuth", 95444));
	list.get(2).addAddress(new Address(DESCRIPTION.PRIMARY, "Teststreet 19", "Hof", 95030));
	list.get(2).addAddress(new Address(DESCRIPTION.SECONDARY, "Teststreet 20", "Hof", 95028));
	list.get(2).addAddress(new Address(DESCRIPTION.SECRET, "Secretstreet 1", "Hof", 95444));
	printPersons("Alle Personen", list);
	
	var list1 = new ArrayList<Person>();
	for (int i = 0; i < list.size(); i++)
	{
		if (list.get(i).getAge() > 20)
		{
			list1.add(list.get(i));
		}
	}
	printPersons("Alle Personen", list1);
	
}

private static void printPersons(String header, List<Person>persons)
{
	if (header.equals("Alle Personen"))
	{
		for (Person p : persons)
		{
			System.out.println(p);
		}
	}
}	

	

}

