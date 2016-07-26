package com.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestJULI {

public static TestJULI s;
	
	public static void main(String[] args) throws InterruptedException 
	{
		RethrowExcep();		
		Thread.sleep(6000);
		RethrowExcep();		
		Thread.sleep(6000);	
		RethrowExcep();		
		Thread.sleep(6000);	
	}
	public static  void RethrowExcep() throws InterruptedException
	{
//		try 
//		{
//			System.out.println("logger obgect in catch");
//			s = null;
//			s.equals("");
//		}
//		catch (Exception e)
//		{
			Logger log = Logger.getLogger("logs");
			log.log(Level.WARNING, "这基本上是随机的胡说");
			Thread.sleep(6000);

			Logger log2 = Logger.getLogger("logs");
			log2.log(Level.SEVERE, "这基本上是随机的胡说");
			Thread.sleep(6000);
//
//		}
		
	}
}


