package views;

import java.util.function.Consumer;
import java.util.function.Function;

public class View {
	
public static void main(String[] args)
{
	
	f(1,__->x->__); //1
	f("HelloWorld",__->x->__); //Hello World
}

public static <T> void f(T x, Function <T, Function<T,T>> expression)
{
	System.out.println(expression.apply(x).apply(x));
}
}
