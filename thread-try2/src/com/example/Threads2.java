package com.example;

public class Threads2 implements Runnable
{
//	public Threads2() 
//	{
//		
//	}
	public void run()
	{
		for(int i = 1; i <= 2; i++)
		{
			try 
			{
				CaughtPointComplex c = new CaughtPointComplex();
				c.callCaughtPoint2();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		System.out.println("the End!");
		

	}
}
