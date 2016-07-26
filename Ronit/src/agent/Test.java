package agent;

import java.io.IOException;
import java.util.logging.Logger;

public class Test
{
	private int abc = 0;
	private String str = "fk";
	private String t = "a";
	private InnerClass cl = new InnerClass();
	
	private static final Logger LOGGER = Logger.getLogger(Test.class.getName());
	
	public class InnerClassException extends Exception
	{
		private static final long serialVersionUID = 1L;
	}
		
	public class InnerClass extends Exception
	{
		private int a2 = 10;
		private String s2 = "dkhlf";
		private String t = "ds';gn";
		
		public int getA2()
		{
			return a2;
		}
		
		public String getS2()
		{
			return s2;
		}
		
		public String getT2()
		{
			return t;
		}
	}
	
	public int getAbc()
	{
		return abc;
	}
	
	public String getStr()
	{
		return str;
	}
	
	public String getT()
	{
		return t;
	}
	
	public InnerClass getCl()
	{
		return cl;
	}
	
	public static void simpleGetter_nonce_8()
	{
		Test t = new Test();
		//t.abc = 5;
		//t.str = "waaa";
		//t.t = "baaa";
		
		//int field = t.getAbc();
		//String s = t.getStr();
		String a = t.getT();
		
		String l = t.cl.getS2();
		String o = t.getCl().getS2();
		
		String tt = t.getCl().t;
		
		System.out.println(a + " " + l + " " + o + " " + tt);
		
		simpleException_nonce_8();
	}
	
	public static void simpleException_nonce_8()
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
	
	public static void simpleLog_nonce_8()
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
	
	public static void exceptionInForLine_nonce_8()
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