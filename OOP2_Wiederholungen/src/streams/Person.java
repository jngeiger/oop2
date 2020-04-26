package streams;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class Person {
private int age;
private String name;

public Person(int a)
{
	this.age = a;
}

public void addName(String n)
{
	this.name = n;
}

public String toString()
{
	return this.name;
}
public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] pArray = new Person[10];
		for (int i = 0; i < pArray.length; i++)
		{
			pArray[i] = new Person((int)((Math.random()*100)+1));
		}
		pArray[0].addName("iksda");
		pArray[1].addName("zzz");
		pArray[2].addName("fffksda");
		pArray[3].addName("hksda");
		pArray[4].addName("zaz");
		pArray[5].addName("papasda");
		pArray[6].addName("gzca");
		pArray[7].addName("kwa");
		pArray[8].addName("bha");
		pArray[9].addName("aha");
		
		Function<Person[], Person[]> f1 = new Function<Person[], Person[]>() { public Person[] apply(Person[] p) {
			boolean check = false;
			while (check == false)
			{
				check = true;
				for (int i = 0; i < p.length - 1; i++)
				{
					if (p[i].name.compareTo(p[i+1].name) > 0)
					{
						Person temp = p[i];
						p[i] = p[i+1];
						p[i+1] = temp;
						check = false;
					}
				}
			}
			return p;	
	}};
	
		//printPersons(pArray);
		sortOld(pArray,f1);
		
		System.out.println("g".compareTo("s"));
}

public static void printPersons(Person[] array)
{
	//ArrayList<Person> list = new ArrayList<Person>(Arrays.asList(array));
	Person[] array2 = Arrays.stream(array).filter(x -> (x.age < 20)).toArray(Person[]::new);
	Integer[] array3 = Arrays.stream(array).map(x -> x.age).filter(x -> x < 20).toArray(Integer[]::new);
	for (int i = 0; i < array3.length; i++)
	{
		System.out.println(array3[i]);
	}
	
	
}

public static void sort(Person[] array)
{
	Arrays.stream(array).map(x -> x.name).sorted((p1, p2) -> (p1.compareTo(p2))).forEach(x -> System.out.println(x));;
}

public static void sortOld(Person[] array, Function<Person[],Person[]> f1)
{
	System.out.println(Arrays.deepToString(f1.apply(array)));
}

}

