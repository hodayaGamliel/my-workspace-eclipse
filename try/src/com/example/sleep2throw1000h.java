package com.example;
import java.io.IOException;
import java.security.Principal;

public class sleep2throw1000h
{

	public static void main (String[] args) throws Exception
	{

		int x = 0;
		
	      while( x < 1000 ) 
	      {
//	    	  System.out.println("value of x : " + x );	 
		       
			  if ( x % 2 == 0 )
			  {
				  test(1);
				  test(2);
				  test(2);
				  test(3);  
		      }
		      Thread.sleep(1000*2); 
			  x++;
	      }
	      
	      System.out.println("Error location calls: " + x*4 );
	      System.out.println("IOException Times: " + x*2 );
	      System.out.println("NullPointerExcepion Times: " + x);
	      
	      Thread.sleep(1000*60*2); 

	}

	public static void test(int throwExcep) 
	{
	    try 
	    {
	    	if (throwExcep == 1)
	    	{
		    	throw new NullPointerException(); 	    	
	    	}
	    	else if  (throwExcep == 2)
	    	{
		    	throw new IOException(); 	    	
	    	}
	    	else if  (throwExcep == 3)
	    	{
	    		System.out.println("hi:)"); 	    	
	    	}
		} 
	    catch (Exception e)
	    {
			e.printStackTrace();
		} 
	 
	}
	
}
