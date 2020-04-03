package rectangle;

public class Rectangle implements Comparable<Rectangle> {
private int height;
private int width;

public Rectangle(int h, int w)
{
	height = h;
	width = w;
}
	
public int getScope()
{
	return 2*height+2*width;
}

@Override
public int compareTo(Rectangle r)
{
	return this.getScope() - r.getScope();
}
	
	
public static <T extends Comparable<T>> boolean isGreater(T a, T b)
{
	return a.compareTo(b) > 0; 
}


public static void main(String[] args)
{
var x = isGreater(new Rectangle(4,1), new Rectangle(5,4));
System.out.println(x);
}
}
