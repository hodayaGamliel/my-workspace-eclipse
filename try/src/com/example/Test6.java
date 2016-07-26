package com.example;

public class Test6
{
	public static void main(String[] args) throws Exception 
	{
		int x11 = 9; 
		for (int i = 0; i < 50 ; i++) 
		{
			Thread.sleep(1000 *2);
			f(x11);
			Thread.sleep(1000 * 2);
			System.out.println(i);
		}
		
	}
	public static void f(int x) 
	{
			try 	
			{
				throw new Exception();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
	}
}
