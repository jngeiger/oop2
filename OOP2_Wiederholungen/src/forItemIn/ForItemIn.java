package forItemIn;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ForItemIn {
public static void main (String[] args)
{
	var arr = new Integer[] {1,2,3,4};
	forItemIn(arr,item -> item % 2 == 0,System.out::println);
}

public static <T> void forItemIn(T[] arr, myOwnPredicate<T> p, myOwnConsumer<T> t)
{
	for (T temp : arr)
	{
		if(p.test(temp) == true)
		{
			t.accept(temp);
		}
	}
}
}
