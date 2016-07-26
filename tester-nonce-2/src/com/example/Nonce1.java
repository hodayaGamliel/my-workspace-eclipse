package com.example;

public class Nonce1
{
	public static void main(String[] args) throws Exception
	{
           	System.out.println("test");
			Nonce1 n = new Nonce1();
			n.throwExcep(); 
	}
	
	public static void throwExcep() throws Exception
	{
		throw new Exception();
	}
}
