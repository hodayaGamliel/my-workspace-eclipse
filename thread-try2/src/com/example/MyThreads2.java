package com.example;

import com.example.Threads2;

public class MyThreads2 
{
	public static void main(String[] args) 
	{
		Threads2 tr1 = new Threads2();
		Thread tr11 = new Thread(tr1);
		tr11.start();
		
		Threads2 tr2 = new Threads2();
		Thread tr22 = new Thread(tr2);
		tr22.start();
	}
}
