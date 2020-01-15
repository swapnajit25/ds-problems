package com.common;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Demonstration that we can use comparator to sort an 2-D array.
 * Here I sorted on based on 0th index value descending order.  
 *
 */
public class Sort2DArray
{

	public static void main(String[] args)
	{
		int[][] arr = new int[][] {{15, 1}, {6, 0}, {12, 1}, {10, 1}, {5, 0}};

		// Sort the array based on 0th index 
		Arrays.sort(arr, new DescArraySortComparator());
		
		// Print the array
		Arrays.stream(arr)
			.forEach(ar -> System.out.println(ar[0] + " " + ar[1]));
	}
	
	private static class DescArraySortComparator implements Comparator<int[]>
	{
		@Override
		public int compare(int[] o1, int[] o2)
		{
			return -1 * Integer.compare(o1[0], o2[0]);
		}
	}

}
