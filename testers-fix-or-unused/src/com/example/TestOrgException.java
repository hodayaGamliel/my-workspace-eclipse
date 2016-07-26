//package com.example;
//
////import testers_for_takipi.LogExcepIntoCatch;
////import testers_for_takipi.ReThrowExcepIntoAnotherExcep;
////import testers_for_takipi.ThrowExcepIntoCatchSameExcep;
////import testers_for_takipi.ThrowExcepIntoCatchTwoDiffExcep;
////import testers_for_takipi.TrowIntoCatch;
//
//public class TestOrgException 
//{/*
//	static ReThrowExcepIntoAnotherExcep t1 = new ReThrowExcepIntoAnotherExcep() ;
//	static ThrowExcepIntoCatchTwoDiffExcep t2 = new ThrowExcepIntoCatchTwoDiffExcep();
//	static ThrowExcepIntoCatchSameExcep t3 = new ThrowExcepIntoCatchSameExcep();
//	static LogExcepIntoCatch t4 = new LogExcepIntoCatch(); 
//	static TrowIntoCatch t5 = new TrowIntoCatch();
//	*/
//	static int x = 2;
//	
//	public static void main(String[] agrs) throws Exception
//	{
//		System.out.println("start of test for org class");
//		if (x == 1) 
//		{
//			System.out.println("case1 selected - the org exception come in the start");
//			case1();
//		}
//		else if (x == 2)
//		{
//			System.out.println("case2 selected - the org exception come in the end");
//			case2();
//		}
//		else if (x == 3)
//		{
//			System.out.println("case3 selected - the org exception come between the other exceptions");
//			case3();
//		}		
//		else if (x == 4)
//		{
//			System.out.println("case4 selected - the org exception come in the start , end and middle");
//			case4();
//		}
//		else 
//		{
//			System.out.println("wrong parameter");
//		}
//	}
//	 
//	public static void ThrowException() throws Exception
//	{
//		throw new Exception() ;
//	}	
//	
////org exception in the start
//	public static void case1 () throws Exception
//	{
//		try
//		{
//			ThrowException();
//		}
//		catch(Throwable e) 
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After org exception");	
//		try
//		{
////			t1.exception();
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t1");
//		
//		try
//		{
//			t2.RethrowException();	
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t2");
//		
//		try
//		{
//			t3.RethrowException();
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t3");
//		try
//		{
//			t4.RethrowException();
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t4");
//		
//		try
//		{
//			t5.exception();	
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t5");
//	
//		System.out.println("End of case");
//	}
//
////org exception in the end
//	public static void case2 () throws Exception
//	{
//		try
//		{
//			t1.exception();
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t1");
//		
//		try
//		{
//			t2.RethrowException();	
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t2");
//		
//		try
//		{
//			t3.RethrowException();
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t3");
//		try
//		{
//			t4.RethrowException();
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t4");
//		
//		try
//		{
//			t5.exception();	
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t5");
//		
//		try
//		{
//			ThrowException();
//		}
//		catch(Throwable e) 
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After org exception");	
//		
//		System.out.println("End of case");
//	}
//
////org exception between the other exceptions
//	public static void case3 () throws Exception
//	{
//		try
//		{
//			t1.exception();
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t1");
//		
//		try
//		{
//			t2.RethrowException();	
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t2");
//		
//		try
//		{
//			ThrowException();
//		}
//		catch(Throwable e) 
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After org exception");	
//		
//		try
//		{
//			t3.RethrowException();
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t3");
//		try
//		{
//			t4.RethrowException();
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t4");
//		
//		try
//		{
//			t5.exception();	
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t5");
//		
//		System.out.println("End of case");
//	}
//	
//	public static void case4 () throws Exception
//	{
//		try
//		{
//			ThrowException();
//		}
//		catch(Throwable e) 
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After org exception");	
//		
//		try
//		{
//			t1.exception();
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t1");
//		
//		try
//		{
//			t2.RethrowException();	
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t2");
//		
//		try
//		{
//			ThrowException();
//		}
//		catch(Throwable e) 
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After org exception");	
//		
//		try
//		{
//			t3.RethrowException();
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t3");
//		try
//		{
//			t4.RethrowException();
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t4");
//		
//		try
//		{
//			t5.exception();	
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After exception t5");
//		
//		try
//		{
//			ThrowException();
//		}
//		catch(Throwable e) 
//		{
//			e.printStackTrace();
//		}
//		System.out.println("After org exception");	
//		
//		System.out.println("End of case");
//	}
//}
