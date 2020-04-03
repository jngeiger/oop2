package Uebung10;

import java.util.ArrayList;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private Address[] addresses;
	
public Person(String f, String l, int a) {
	this.age  = a;
	this.firstName = f;
	this.lastName = l;
	this.addresses = new Address[3];
}


public static void main(String[] args)
{
	ArrayList<Person> list = new ArrayList<Person>();
	list.add(new Person("Max", "Mustermann" , 19));
	list.add(new Person("Chris", "May",21));
	list.add(new Person("Steve", "Clover", 25));
}
}
