package agent;

import java.io.IOException;

public class TestRunnable implements Runnable
{
	private static ThreadLocal<String> tls = new ThreadLocal<String>();
	private static ThreadLocal<String> inheritTls = new InheritableThreadLocal<String>();
	
	public class TestInnerRunnable implements Runnable
	{
		@Override
		public void run()
		{
			String threadName = Thread.currentThread().getName();
			
			tls.set(threadName);
			
			generateSimpleException_nonce_12();
		}
	}
	
	@Override
	public void run()
	{
		String threadName = Thread.currentThread().getName();
		
		tls.set(threadName);
		
		inheritTls.set(Thread.currentThread().getName() + " (inherit)");
		addThread(threadName);
		
		generateSimpleException_nonce_12();
	}
	
	private void generateSimpleException_nonce_12()
	{
		try
		{
			int i = -1;
			
			while(true)
			{
				try
				{
					Thread.sleep(1000);
					i++;
					
					if (i % 2 == 0)
					{
						throw new IndexOutOfBoundsException();
					}
					else if (i % 2 == 1)
					{
						throw new IOException();
					}
					
				}
				catch(Exception e)
				{
					System.out.println("exception (" + tls.get() + ", " + inheritTls.get() + ") : " + e);
					//System.out.println("exception (" + tls.get() + ") : " + e);
					//System.out.println("exception (" + inheritTls.get() + ") : " + e);
					//e.printStackTrace();
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void addThread(String parentThreadName)
	{
		try
		{
			TestInnerRunnable tir = new TestInnerRunnable();
			
			Thread inheritThread1 = new Thread(tir, parentThreadName + "/thread 1");
			Thread inheritThread2 = new Thread(tir, parentThreadName + "/thread 2");
			
			inheritThread1.start();
			inheritThread2.start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
