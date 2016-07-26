package com.example;

public class Backtracking
{
	public static void main (String[] args)
	{

	
	}
	
	
	
	public static void options(int n)
	{
		int[] history = new int[n];
		int i = 0;
		
		options(n,history,i);
	}
	
	public static void options(int n , int[] history, int i)
	{
		if(n==0)
		{
			printHistory(history , 0, i);
		}
		
		
	}
	
	public static void printHistory(int[] History, int from, int to)
	{
		
	}
	
	
	public static int minOperation(int x, int y)
	{
		System.out.println("checks if x is equals to y");
		if(x == y)
		{
			System.out.println("x is like y");
			return 0;
		}
		
		if(x > y)
		{
			return -1;
		}
		
		int plus1,mult2;
		System.out.println("puls 1 - min oper of: " + x + " , " + y );
		plus1 = (minOperation(x+1,y))+1;
		System.out.println("plus is : " + plus1);
		
		System.out.println("mult 2 - min oper of: " + x + " , " + y );
		mult2 = (minOperation(x*2,y))+1;
		System.out.println("mult 2 is : " + mult2);

		return plus1 < mult2 ? plus1:mult2;
	}
}
