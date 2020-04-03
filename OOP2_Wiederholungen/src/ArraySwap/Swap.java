package ArraySwap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;


public class Swap {

	public static <T> void swap (T[] obj1, T[] obj2) // Not efficient but works for now. maybe check later
	{
		ArrayList<T> list = new ArrayList<T>();
		
		for (T item : obj1)
		{
			list.add(item);
		}
		for (int i = 0; i < obj2.length; i++)
		{
			obj1[i] = obj2[i];
		}
		for (int i = 0; i < obj2.length; i++)
		{
			obj2[i] = list.get(i);
		}
	}
	
	public static <T extends Number, R extends Number> void swap (T[] obj1, T[] obj2, Function<Integer,Double> f1, Function<T,Integer> f2)
	{
		ArrayList<Number> list = new ArrayList<Number>();
		
		for (T item : obj1)
		{
			list.add(item);
		}
		for (int i = 0; i < obj2.length; i++)
		{
			obj1[i] = (T)f2.apply(obj2[i]);
			
		}
		for (int i = 0; i < obj2.length; i++)
		{
			obj2[i] = (T)f1.apply((Integer)list.get(i));
		}
	}
	public static void main(String[] args)
	{
		var s1 = new String[] {"Hello", "World"};
		var s2 = new String[] {"Alex", "Christ"};
		swap(s1,s2);
		System.out.println(Arrays.toString(s1));
		System.out.println(Arrays.toString(s2));
		var i1 = new Integer[] {1,4};
		var d2 = new Double[] {2.1,6.8};
		swap(i1,d2,i -> Double.valueOf(i), d -> Integer.valueOf(d.intValue()));
		System.out.println(Arrays.toString(i1));//[2,6]
		System.out.println(Arrays.toString(d2));//[1.0,4.0]
		
		
	}
}
