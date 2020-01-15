package com.common;

/*
 * Given an array [1,2]. Number of ways can make sum = 4
 * (1,1,1,1)  (1,1,2)  (2,2)
 */
public class NoOfWaysMakeSum
{
	private int n;
	private int[] arr;

	public static void main(String[] args)
	{
		NoOfWaysMakeSum nwms = new NoOfWaysMakeSum();
		nwms.n = 2;
		nwms.arr = new int[]{1,2};
		
		System.out.println("Number of Ways: " + nwms.ways(4, 0));

	}
	
	public int ways(int sum, int pos)
	{
		if(pos == n) return sum == 0? 1 : 0;
		
		int ans = 0;
		int times = 0;
		while(times*arr[pos] <= sum)
		{
			ans += ways(sum - times*arr[pos], pos+1);
			++times;
		}
		
		return ans;
	}

}
