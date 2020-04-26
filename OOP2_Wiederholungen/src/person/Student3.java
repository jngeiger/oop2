package person;

public class Student3 extends Person implements InitialsExtension {

public void getInitials()
{
	System.out.println(super.vorname.charAt(0) + "." + super.nachname.charAt(0) + ".");
}
}
