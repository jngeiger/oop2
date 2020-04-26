package person;

public class Student2 extends Person implements FullNameExtension {

public void getFullName()
{
	System.out.println(super.vorname + " " +  super.nachname);
}
}
