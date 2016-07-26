package com.example;

import java.util.EmptyStackException;

public class Test1000Characters
{
	public static void main(String[] args) throws Exception 
	{
		test("");
	}
	
	public static void test(String key) 
	{
		switch (key) 
		{
			case "1":
			case "error":
			{
				System.out.println("Error or 1");
				break;
			}
			case "2":
				break;
			case "3":
				break;

			default:
				System.out.println("Default");
				break;
		}
	}
}
