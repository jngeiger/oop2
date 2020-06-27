package oop2.statistik;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<? super T>> {

	public void sort(List<T> list)
	{
		mergeSort(0,list.size()-1,list);
	}
	
	private void mergeSort(int l, int r, List<T> list)
	{
		if (r-l < 1)
		{
			return;
		}
		else {
			int m = (l+r)/2;
			mergeSort(l,m,list);
			mergeSort(m+1,r,list);
			merge(l,m,r,list);
		}
	}
	
	private void merge(int l, int m, int r, List<T> list)
	{
		List<T> cache = new ArrayList<T>();
		int lidx = l;
		int ridx = m+1;
		
		while (lidx <= m && ridx <= r)
		{
			if (list.get(lidx).compareTo(list.get(ridx)) < 0)
			{
				cache.add(list.get(lidx++));
			}
			else {
				cache.add(list.get(ridx++));
			}
		}
		
		while (lidx <= m)
		{
			cache.add(list.get(lidx++));
		}
		while (ridx <= r)
		{
			cache.add(list.get(ridx++));
		}
		int idx = 0;
		for (int i = l; i <= r; i++)
		{
			list.set(i, cache.get(idx++));
		}
	}
}
