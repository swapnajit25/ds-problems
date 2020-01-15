package com.ds.arrays;

import java.util.Arrays;

public class ArraysJump
{

	public static void main(String[] args)
	{
		int[] arr = {2,3,1,1,2};
		int[] jumps = new int[arr.length];
		Arrays.fill(jumps, Integer.MAX_VALUE - 2);
		
		// Last node, min jumps should be zero
		jumps[jumps.length - 1] = 0;
		
		// Find the minimum jumps
		minimumJumps(arr, jumps);
		
		System.out.println("Min jumps required: " + jumps[0]);

	}
	
	public static void minimumJumps(int[] arr, int[] jumps)
	{
		int n = arr.length;
		
		for(int i = n-2; i >= 0; i--)
		{
			for(int j = i+1; j <= i+arr[i] && j < n; j++)
			{
				jumps[i] = Math.min(jumps[i], 1+jumps[j]);
			}
		}
	}

}
