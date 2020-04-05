package person_week2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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

public Person getCurrentPerson() { return this; }
public String getName() { return this.firstName+this.lastName; }

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

public Address[] getAddresses()
{
	return this.addresses;
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
	//printPersons("Alle Personen", list);
	
	var list1 = new ArrayList<Person>();
	for (int i = 0; i < list.size(); i++)
	{
		if (list.get(i).getAge() > 20)
		{
			list1.add(list.get(i));
		}
	}
	
	
	
	
	printPersons("Alle Personen", list1);
	list.stream().filter(item -> item.getAge() > 20).forEach(item -> System.out.println(item));
	
	
	//some random array with persons
	Person[] list4 = new Person[5];
	list4[0] = new Person("Hans", "Meister",10);
	list4[1] = new Person("Horst", "Meister",40);
	list4[2] = new Person("Gisela", "Meister",30);
	list4[3] = new Person("Petra", "Meister",1);
	list4[4] = new Person("Günther", "Meister",20);
	
	// anonymous interface sort person by their name
	Arrays.sort(list4, new Comparator<Person>() {
		public int compare(Person p1, Person p2)
		{
			return p1.getName().toLowerCase().compareTo(p2.getName().toLowerCase());
		}
	});
	
	
	
	// lambda expression sort person by their name
	Arrays.sort(list4, (p1, p2) -> p1.getName().toLowerCase().compareTo(p2.getName().toLowerCase()));
	
	for (Person p: list4)
	{
		System.out.println(p.getName());
	}
	System.out.println(getAvg(list4));
	
	// Average age functional
	List<Person> list6 = Arrays.asList(list4);
	System.out.println(list6.parallelStream().map(x -> x.getAge()).reduce(0, (Integer a, Integer b) ->  a+b) / list6.size());
	
	// Check whether each person in the list has at least one primary address
	System.out.println(list.parallelStream().allMatch(item -> { Address[] x = item.getAddresses(); return x[0] != null; })); // returns true!
	// Test my other list for validity -> Should return false
	System.out.println(list6.parallelStream().allMatch(item -> { Address[] x = item.getAddresses(); return x[0] != null; })); //returns false!
	// Check whether at least one person has at least one 'secret address'
	System.out.println(list.parallelStream().anyMatch(item -> { Address[] x = item.getAddresses(); return x[2] != null; })); // returns true, all good.
}


// Average age iteration
private static <T extends Person> int getAvg (T[] list)
{
	int temp = 0;
	for (int i = 0; i < list.length; i ++)
	{
		temp += list[i].getAge();
	}
	return temp/list.length;
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

