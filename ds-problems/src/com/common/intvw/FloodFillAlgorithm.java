package com.common.intvw;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * In this problem, if we click on a position(cell). the structure linked to that cell
 * will be filled with a new value. 
 *
 */
public class FloodFillAlgorithm
{
	private static int rowMaxSize = 4;
	private static int colMaxSize = 6;
	
	public static void main(String[] args)
	{
		int[][] arr = {
					{1, 1, 1, 1, 1, 1},
					{1, 1, 2, 2, 1, 1},
					{1, 1, 2, 2, 1, 1},
					{2, 2, 2, 2, 2, 2}
				};
		
		int newValue = 3;
		String cell = "2,2";
		
		System.out.println(Arrays.deepToString(arr).replace("], " , "]\n"));
		System.out.println("Filling with new value");
		
		floodFill(arr, cell, newValue);
		
		System.out.println(Arrays.deepToString(arr).replace("], ", "]\n"));
	}

	private static void floodFill(int[][] arr, String cell, int newValue)
	{
		Stack<String> stack = new Stack<String>();
		Set<String> visited = new HashSet<String>();
		
		// Add first item to stack and do dfs to find all the adjacent cells
		stack.push(cell);
		visited.add(cell);
		while(!stack.isEmpty()) 
		{
			runDfs(arr, stack, visited, newValue);
		}
	}

	private static void runDfs(int[][] arr, Stack<String> stack, Set<String> visited, int newValue)
	{
		String cell = stack.pop();
		String[] values = cell.split(",");
		int i = Integer.parseInt(values[0]);
		int j = Integer.parseInt(values[1]);
		
		findAndAddUnvisited(arr, stack, visited, cell, i , j);
		
		// Replace the new value
		arr[i][j] = newValue;
		
	}

	private static void findAndAddUnvisited(int[][] arr, Stack<String> stack, Set<String> visited, 
			String cell, int i, int j)
	{
		int cellValue = arr[i][j];
		
		for(int x = 0; x <= 1; x++)
		{
			for(int y = 0; y <= 1; y++)
			{
				
				if(x==0 && y == 1)
				{
					if(((j-1) >= 0)) 
					{
						String s = i + "," + (j-1);
						int adjVal = arr[i][j-1];
						checkAndAdd(stack, visited, s, cellValue, adjVal);
					}
					
					if(((j+1) < colMaxSize)) 
					{
						String s = i + "," + (j+1);
						int adjVal = arr[i][j+1];
						checkAndAdd(stack, visited, s, cellValue, adjVal);
					}
				}
				
				if(x==1 && y == 0)
				{
					if(((i-1) >= 0)) 
					{
						String s = (i-1) + "," + (j);
						int adjVal = arr[i-1][j];
						checkAndAdd(stack, visited, s, cellValue, adjVal);
					}
					
					if(((i+1) < rowMaxSize)) 
					{
						String s = (i+1) + "," + (j);
						int adjVal = arr[i+1][j];
						checkAndAdd(stack, visited, s, cellValue, adjVal);
					}
				}
				
				if(x==1 && y == 1)
				{
					if(((j-1) >= 0)) 
					{
						if(((i-1) >= 0))
						{
							String s = (i-1) + "," + (j-1);
							int adjVal = arr[i-1][j-1];
							checkAndAdd(stack, visited, s, cellValue, adjVal);
						}
						if(((i+1) < rowMaxSize)) 
						{
							String s = (i+1) + "," + (j-1);
							int adjVal = arr[i+1][j-1];
							checkAndAdd(stack, visited, s, cellValue, adjVal);
						}
					}
					
					if(((j+1) < colMaxSize)) 
					{
						if(((i-1) >= 0))
						{
							String s = (i-1) + "," + (j+1);
							int adjVal = arr[i-1][j+1];
							checkAndAdd(stack, visited, s, cellValue, adjVal);
						}
						if(((i+1) < rowMaxSize)) 
						{
							String s = (i+1) + "," + (j+1);
							int adjVal = arr[i+1][j+1];
							checkAndAdd(stack, visited, s, cellValue, adjVal);
						}
						
					}
				}
			}
		}
		
		
		
		// Find if adjacent cell matches this value and unvisted
		/*
		String s = i + "," + (j-1);
		int adjVal = arr[i][j-1];
		checkAndAdd(stack, visited, s, cellValue, adjVal);
		
		s = i + "," + (j+1);
		adjVal = arr[i][j+1];
		checkAndAdd(stack, visited, s, cellValue, adjVal);
		
		s = (i-1) + "," + (j-1);
		adjVal = arr[i-1][j-1];
		checkAndAdd(stack, visited, s, cellValue, adjVal);
		
		s = (i-1) + "," + (j);
		adjVal = arr[i-1][j];
		checkAndAdd(stack, visited, s, cellValue, adjVal);
		
		s = (i-1) + "," + (j+1);
		adjVal = arr[i-1][j+1];
		checkAndAdd(stack, visited, s, cellValue, adjVal);
		
		s = (i+1) + "," + (j-1);
		adjVal = arr[i+1][j-1];
		checkAndAdd(stack, visited, s, cellValue, adjVal);
		
		s = (i+1) + "," + (j);
		adjVal = arr[i+1][j];
		checkAndAdd(stack, visited, s, cellValue, adjVal);
		
		s = (i+1) + "," + (j+1);
		adjVal = arr[i+1][j+1];
		checkAndAdd(stack, visited, s, cellValue, adjVal);
		*/
		
	}
	
	private static void checkAndAdd(Stack<String> stack, Set<String> visited, 
			String s, int cellValue, int adjVal)
	{
		if(adjVal == cellValue && !visited.contains(s))
		{
			stack.push(s);
			visited.add(s);
		}
	}

}
