package pow;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Pow implements Function<Double,Integer> {
private double base;

public Pow(double b)
{
	this.base = b;
}


public static void main(String[] args)
{
	var pow2 = pow(2.0); 
	System.out.println(pow2.apply(3.0)); // 8
	var pow10 = pow(10.0);
	System.out.println(pow10.apply(3.0)); // 1000
	var numbers = List.of("one", "two", "three", "four",
			"five", "six"); 
			System.out.println(numbers.stream().filter(
			it -> it.length()>5).collect(Collectors.toList()));
}



public static Pow pow(double value)
{
	return new Pow(value);
}


@Override
public Integer apply(Double t) {
	return (int) Math.pow(this.base, t);
}



}
