package Lambdas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		applyAndPrint(2,5,x -> x * x);
		applyAndPrint(2,5,new Function()
				{
					public int apply(int a)
					{
						return a * a * a;
					}
				});
		
		
	}
	
	public static void applyAndPrint(int a, int b, Function f)
	{
		for (int i = a; i <= b; i++)
		{
			System.out.println(f.apply(i));
		}
	}

}
