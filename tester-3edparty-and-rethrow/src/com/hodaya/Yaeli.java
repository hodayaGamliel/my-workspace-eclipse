package com.hodaya;

import org.apache.Moshe;

public class Yaeli
{
	public static Yaeli s; 	
	
	public static void main(String[] args) 
	{
		Yaeli yael = new Yaeli(); 
		yael.callToMoshe3(); 
	}	
	
	public void callToMoshe3() 
	{
		for (int i = 0; i < 30; i++) 
		{
			try 
			{
				Moshe moshe = new Moshe();
				moshe.mosheCallYaell();
			} 
			catch (Exception e) 
			{
				System.out.println("3 caught e and print to screen");
				e.printStackTrace();
			}	
		}
	}
	
	public void yaeliThrowException() throws Exception
	{
		System.out.println("1 throw Null Pointer Exception ");
		throw new NullPointerException();
	}	
}	

