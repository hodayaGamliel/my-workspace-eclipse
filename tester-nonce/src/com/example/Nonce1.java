package com.example;

import javax.swing.plaf.SliderUI;

public class Nonce1 
{
	public static void main(String[] args) throws Exception
	{		
		while (true)
		{
			throwException();
			Thread.sleep(5 * 60 * 1000); 
		}
	}

	public static void throwException() throws Exception
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
