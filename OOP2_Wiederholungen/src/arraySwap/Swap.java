package arraySwap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Swap {

	public static <I,D> void swap(I[] obj1, D[] obj2, Function<I,D> f1, Function<D,I> f2)
	{
		for (int i = 0; i < obj1.length; i++)
		{
			I temp = obj1[i];
			obj1[i] = f2.apply(obj2[i]);
			obj2[i] = f1.apply(temp);
		}
	}
	
	
	public static void main(String[] args)
	{
		var s1 = new String[] {"Hello", "World"};
		var s2 = new String[] {"Alex", "Chris"};
		System.out.println(Arrays.toString(s1)); //ALEX, CHRIS
		System.out.println(Arrays.toString(s2)); //HELLO, WORLD
		
		
		var i1 = new Integer[] {1,4};
		var d2 = new Double[] {2.1,6.8};
		swap(i1,d2,i -> Double.valueOf(i), d -> Integer.valueOf(d.intValue()));
		System.out.println(Arrays.toString(i1));//[2,6]
		System.out.println(Arrays.toString(d2));//[1.0,4.0]
		
		Supplier<String> sup = () -> ("wassup");
		System.out.println(sup.get());
				
	}
}
