package com.ds.dp;

/*
 * Given an array [1,2]. Number of ways can make sum = 4
 * (1,1,1,1)  (1,1,2)  (2,2)
 */
public class CoinChangeRecursive
{
	private int n;
	private int[] arr;

	public static void main(String[] args)
	{
		CoinChangeRecursive nwms = new CoinChangeRecursive();
		nwms.n = 2;
		nwms.arr = new int[]{1,2};
		
		System.out.println("Number of Ways: " + nwms.ways(4, 0));

	}
	
	/*
	 *  Here we need to approach on 2 ways
	 *  1. Without first element (i.e. 0 times first element) number of ways we can make the sum (this will propagate for every recursive sub array)
	 *  2. With first element, number of ways we can make the sum
	 *  	2a. With multiple times of first element (till times*value <= expected result), number of ways we can make the sum
	 *  
	 *  Result is SUM of step-1 + step-2
	 *  
	 *  This approach is recursive and time taken is 2pow(n). Which can be improved using dynamic programming
	 */
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
