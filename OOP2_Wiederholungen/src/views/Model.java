package views;

public class Model {
private String name;
private int age;
private int viewer;

public Model() {
	viewer = 0;
};
public void setName(String n)
{
	this.name = n;
}

public void setAge(int a)
{
	this.age = a;
}

public int getObservers()
{
	return viewer;
}

public void add(View v)
{
	
}
}
