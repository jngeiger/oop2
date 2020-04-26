package person;

public class  Student4 extends Person implements FullNameExtension, InitialsExtension {

	

public void getFullName()
{
	System.out.println(super.vorname + " " +  super.nachname);
}

public void getInitials()
{
	System.out.println(super.vorname.charAt(0) + "." + super.nachname.charAt(0) + ".");
}
}
