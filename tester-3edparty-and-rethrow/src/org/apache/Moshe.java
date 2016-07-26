package org.apache;

import com.hodaya.Yaeli;

public class Moshe 
{
	public static void main(String[] args) throws Exception 
	{
		mosheCallYaell();
	}	
	
	public static void mosheCallYaell() throws Exception 
	{
		for (int i = 0; i < 20; i++) 
		{
			try 
			{
				Yaeli callYael = new Yaeli();
				callYael.yaeliThrowException();
			} 
			catch (Exception e) 
			{
				System.out.println("2 caught Null Pointer Exception and rethrow as e");
				throw new Exception(e);
			}
		}
	}
}
