package com.ds.dp;

import java.util.Arrays;

public class CoinChangeDP
{

	public static void main(String[] args)
	{
		int[] coins = new int[] {1, 3, 5};
		final int W = 9;
		int n = coins.length;
		
		int noOfWays = knapsack(W, coins, n); 
		System.out.println("No of ways can make change of : " + W + " using " + 
				Arrays.toString(coins) + " is " + noOfWays);

	}

	private static int knapsack(int W, int[] coins, int n)
	{
		int[][] K = new int[n+1][W+1];
		
		for(int i = 0; i <= n; i++)
		{
			for(int w = 0; w <= W; w++)
			{	
				// when change required is 0, we will not select any thing irrespective of
				// coin value, which leads to number of selection as 1
				if(w == 0)
				{
					K[i][w] = 1;
				}
				else if(i == 0) // When we have coin of value 0, there are 0 ways we can make any value except 0
				{
					K[i][w] = 0;
				}
				else if(coins[i-1] <= w) // i-1 is the index position in coins[]
				{
					// Return the sum of two cases
					// 1. Excluding that coin, number of ways we can make that change
					// 2. Including that coin, number of ways we can make that change 
					K[i][w] = Integer.sum(K[i-1][w], 
									K[i][w - coins[i-1]]);
				}
				else
				{
					// When the coin value is bigger than the change we are looking for
					// then number of ways is the number of ways we can make that change
					// without including that coin
					K[i][w] = K[i-1][w];
				}
			}
		}
		
		return K[n][W];
	}

}
