package agent;

import java.io.IOException;
import java.util.logging.Logger;

public class Test
{
	private static final Logger LOGGER = Logger.getLogger(Test.class.getName());
	
	public class InnerClassException extends Exception
	{
		private static final long serialVersionUID = 1L;
		
	}
	
	public static void simpleException_nonce_1()
	{
		int i = 0;
		
		while(true)
		{
			try
			{
				Thread.sleep(1000);
				i++;
				
				if(i % 3 == 0)
				{
					throw new IndexOutOfBoundsException();
				}
				else if(i % 3 == 1)
				{
					throw new IOException();
				}
				else
				{
					throw ((new Test()).new InnerClassException());
				}
			}
			catch(Exception e)
			{
				System.out.println("exception: " + e);
				//e.printStackTrace();
			}
		}
	}
	
	public static void simpleLog_nonce_1()
	{
		while(true)
		{
			try
			{
				Thread.sleep(1000);
				LOGGER.warning("mamamaam");
			}
			catch(Exception e)
			{
				System.out.println("exception...");
			}
		}
	}
	
	public static void exceptionInForLine_nonce_1()
	{
		try
		{
			Thread.sleep(1000);
			
			String str = null;
			int i = 0;
			for( String tmp = str.toString(); i < 5; i++)
			{
				System.out.println("i = " + i);
			}
		}
		catch(Exception e)
		{
			System.out.println("exception...");
		}
	}
}