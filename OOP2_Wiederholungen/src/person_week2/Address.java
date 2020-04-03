package person_week2;

public class Address {
private DESCRIPTION desc;
private String location;
private String town;
private int postalcode;

public Address(DESCRIPTION d, String loc, String t, int postal) {
this.desc = d;
this.location = loc;
this.town = t;
this.postalcode = postal;
}

public DESCRIPTION getType()
{
	return this.desc;
}

public String toString()
{
	return this.location + ", " + this.postalcode + " " + this.town;
}

}
