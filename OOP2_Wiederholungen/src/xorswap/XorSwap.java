package xorswap;

import java.util.Arrays;

public class XorSwap {
public static void main(String[] args)
{
	Integer[] a1 = new Integer[]{1,2,3}; 
	Integer[] a2 = new Integer[]{4,5,6};
	swap(a1, a2);
	System.out.println(Arrays.toString(a1)); // [4, 5, 6] 
	System.out.println(Arrays.toString(a2)); // [1, 2, 3]
}

public static void swap(Integer[] a1, Integer[] a2)
{
	for (int i = 0; i < a1.length; i++)
	{
		a1[i] = a1[i] ^ a2[i];
		a2[i] = a1[i] ^ a2[i];
		a1[i] = a1[i] ^ a2[i];
	}
}
}
