package agent;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class Test
{
	private int abc = 0;
	private String str = "fk";
	private String t = "a";
	
	private InnerClass cl = new InnerClass();
	
	public static String staticField = "testingStatic";
	public static String password = "dominoNoShow!!!!";
	public static String pw = "dominoShow";
	
	private static final Logger LOGGER = Logger.getLogger(Test.class.getName());
	
	public class InnerClassException extends Exception
	{
		private static final long serialVersionUID = 1L;
	}
	
	public class InnerClass extends Exception
	{
		private static final long serialVersionUID = -6318400739684428092L;
		
		private int a2 = 10;
		private String s2 = "dkhlf";
		@SuppressWarnings("hiding")
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
		simpleException_nonce_12();
		return t;
	}
	
	public InnerClass getCl()
	{
		return cl;
	}
	
	public Long getNullLong()
	{
		return null;
	}
	
	public long getLong()
	{
		return new Long(5);
	}
	
	public static void simpleGetter_nonce_12()
	{
		Test t = new Test();
		//t.abc = 5;
		//t.str = "waaa";
		//t.t = "baaa";
		
		//int field = t.getAbc();
		//String s = t.getStr();
		String a = t.getT();
		
		String l1 = t.cl.getS2();
		String o2a = t.getCl().getS2();
		String o2t = t.getCl().getT2();
		
		String tt = t.getCl().t;
		
		System.out.println(a + " " + l1 + " " + o2a + " " + tt);
		
		simpleException_nonce_12();
	}
	
	public static void simpleException_nonce_12()
	{
		int i = -1;
		
		while(true)
		{
			i++;
			
			simpleException_nonce_12(i);
			
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println("exception: " + e);
				//e.printStackTrace();
			}
		}
	}
	
	public static void simpleException_nonce_12(int i)
	{
		staticField = "testingStatic_" + i;
		password = "dominoNoShow!!!!" + " " + i;
		pw = "dominoShow_" + i;
		
		try
		{
			if (i % 3 == 0)
			{
				throw new IndexOutOfBoundsException();
			}
			else if (i % 3 == 1)
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
	
	public static void simpleLog_nonce_12()
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
	
	public static void simpleExceptionCotrolledByStdin_nonce_12()
	{
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int i = -1;
		
		while(true)
		{
			boolean isThrow = false;
			
			try
			{
				while((input = br.readLine()) != null)
				{
					if (input.toLowerCase().equals("throw"))
					{
						isThrow = true;
						break;
					}
				}
			}
			catch (IOException e)
			{
				System.out.println("exception: " + e);
				//e.printStackTrace();
				continue;
			}
			
			if (!isThrow)
			{
				continue;
			}
			
			i++;
			
			simpleException_nonce_12(i);
			
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println("exception: " + e);
				//e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("null")
	public static void exceptionInForLine_nonce_12()
	{
		try
		{
			Thread.sleep(1000);
			
			String str = null;
			int i = 0;
			
			for(String tmp = str.toString(); i < 5; i++)
			{
				System.out.println("i = " + i);
			}
		}
		catch(Exception e)
		{
			System.out.println("exception...");
		}
	}
	
	public static void exceptionInHiddenCode_nonce_12()
	{
		try
		{
			Test t = new Test();
			int a = 5;
			
			Long bug = (a <= 0) ? t.getLong() : t.getNullLong();
			
			System.out.println("bug: " + bug.longValue());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void exceptionWithTls_nonce_12()
	{
		try
		{
			TestRunnable tr = new TestRunnable();
			
			Thread thread1 = new Thread(tr, "thread 1");
			Thread thread2 = new Thread(tr, "thread 2");
			
			thread1.start();
			thread2.start();
			
			Thread.currentThread().join();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
//	public static void exceptionWithMdc_nonce_12()
//	{
//		org.apache.log4j.MDC.put("test", "log4j");
//		org.jboss.logmanager.MDC.put("test", "jboss");
//		org.slf4j.MDC.put("test", "slf4j");
//		
//		while(true)
//		{
//			try
//			{
//				Thread.sleep(1000);
//				throw new IOException();
//			}
//			catch(Exception e)
//			{
//				System.out.println("org.apache.log4j.MDC: " + org.apache.log4j.MDC.get("test"));
//				System.out.println("org.jboss.logmanager.MDC: " + org.jboss.logmanager.MDC.get("test"));
//				System.out.println("org.slf4j.MDC: " + org.slf4j.MDC.get("test"));
//				
//				//e.printStackTrace();
//			}
//		}
//	}
	
	public static void exceptionInDifferentThreadWhileMainSleep_nonce_12()
	{
		try
		{
			Thread.currentThread().setName("main");
			
			Thread thread1 = new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					simpleException_nonce_12(0);
				}
			}, "thread 1");
			
			thread1.start();
			
			Thread.sleep(100000);
		}
		catch(Exception e)
		{
			System.out.println("exception: " + e);
			//e.printStackTrace();
		}
		
		System.out.println("main end !!!");
	}
}
