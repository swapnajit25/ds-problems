package com.ds.search.binary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * distinct triplet (p, q, r)
 * p <= q && q >= r
 * 
 * p belongs to a
 * q belongs to b
 * r belongs to c
 *
 */
public class TripletCombinationCount
{
	
	public static void main(String[] args)
	{
		// 3 1-D arrays
		int[] a = {3,5,7,7,1,1};
		int[] b = {7,5,9};
		int[] c = {7,9,11,11,13};
		
		// Make the array element distinct
		a = formDistinctArray(a);
		b = formDistinctArray(b);
		c = formDistinctArray(c);
		
		// Sort the array
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		
		// Do the binary search to find the count of elements 
		// less than or equals to each element in b
		int result = 0;
		for(int elem : b)
		{
			int count1 = searchAndCount(a, elem) + 1; // +1 to compensate 0th index
			int count2 = searchAndCount(c, elem) + 1; // +1 to compensate 0th index
			
			result += count1 * count2;
		}
		
		System.out.println("Number of distinct triplet: " + result);
	}

	private static int searchAndCount(int[] arr, int key)
	{
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		int elemCount = -1; // If we make it 0, the element found at 0th index or the 
							// element not found behave in same way as it will be defaulted to 0  
		
		while(start <= end)
		{
			mid = start + (end - start) /2;
			
			if(arr[mid] <= key)
			{
				elemCount = mid;
				start = mid + 1;
			}
			else
			{
				end = mid - 1;
			}
		}
		
		return elemCount;
	}

	private static int[] formDistinctArray(int[] arr)
	{
		Set<Integer> set = new HashSet<Integer>();
		for(int v : arr)
		{
			set.add(v);
		}
		
		return set.stream() .mapToInt(Integer::intValue).toArray();
		  
		/*
		int[] ret = new int[set.size()];
		int i = 0;
		for(Integer s : set)
		{
			ret[i++] = s.intValue();
		}
		
		return ret;
		*/
		 
	}

}
