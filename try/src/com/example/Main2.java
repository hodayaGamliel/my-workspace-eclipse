package com.example;

import java.util.HashMap;

public class Main2 {

	public static void main(String[] args) throws Exception
	{
		String password = "dominoNoShow!!!!";
		String pw = "dominoShow";
		String copy = password;
		
		InnerCl inCl = new Main2.InnerCl();
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("password", "dominoNoShow!!!!");
		hm.put("pw", "dominoShow");
		hm.put("copy", hm.get("password"));
		
		System.out.println("locals:");
		System.out.println("~~~~~~");
		System.out.println("password = " + password);
		System.out.println("pw = " + pw);
		System.out.println("copy = " + copy);
		System.out.println("inCl: " + inCl);
		
		System.out.println();
		
		System.out.println("HashMap:");
		System.out.println("~~~~~~~");
		System.out.println("password = " + hm.get("password"));
		System.out.println("pw = " + hm.get("pw"));
		System.out.println("copy = " + hm.get("copy"));
		
		System.out.println();
		
		ronit(password);
		//Test.simpleLog_nonce_20();
		//Test.simpleExceptionCotrolledByStdin_nonce_20();
		//Test.exceptionInForLine_nonce_20();
		//Test.simpleGetter_nonce_20();
		//Test.exceptionInHiddenCode_nonce_20();
		//Test.exceptionWithTls_nonce_20();
		//Test.exceptionWithMdc_nonce_20();
		//Test.exceptionInDifferentThreadWhileMainSleep_nonce_20();
		//Test2.simpleExceptionWithStaticFields_nonce_20();
		//Test.exceptionsInSubProcesses_nonce_20(args[0], args[1], args[2]);
	
	}
	
	public static void ronit(String arg)
	{
		
//			System.out.println(arg);
//			int[] arr = new int[3];
//		
//			for(int i = 0; i <= 10; i++)
//			{
//				System.out.println(arr[i]);
//			}
		try 
		{
			throw new Exception();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
			
	}
	public static class InnerCl
	{
		public String password1 = "dominoNoShow!!!!";
		public String pw = "dominoShow";
		String copy = password1;
		
		@Override
		public String toString()
		{
			return "password = " + password1 + "; "
					+ "pw = " + pw + "; "
					+ "copy = " + copy + "; ";
		}
	}
}