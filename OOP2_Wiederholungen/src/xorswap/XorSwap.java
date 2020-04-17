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

public static <T> void swap(Integer[] arr1, Integer[] arr2)
{
	for (int i = 0; i < arr1.length; i++)
	{
		arr1[i] = arr1[i] ^ arr2[i];
		arr2[i] = arr1[i] ^ arr2[i];
		arr1[i] = arr1[i] ^ arr2[i];
		
	}
}
}
