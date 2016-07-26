package agent.chen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class Class1
{
	public static void main(String[] args) throws Exception
	{
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		service.execute(new Bracha1());
		service.execute(new Bracha2());
		service.execute(new Bracha3());
		service.execute(new Bracha4());
		service.execute(new Bracha5());
		
		service.awaitTermination(100000, TimeUnit.MILLISECONDS);
	}
	
	public static class Bracha1 implements Runnable
	{
		@Override
		public void run()
		{
			Util.boom(5);
		}
	}
	
	public static class Bracha2 implements Runnable
	{
		@Override
		public void run()
		{
			Util.boom(5);
		}
	}
	
	public static class Bracha3 implements Runnable
	{
		@Override
		public void run()
		{
			Util.boom(5);
		}
	}
	
	public static class Bracha4 implements Runnable
	{
		@Override
		public void run()
		{
			Util.boom(5);
		}
	}
	
	public static class Bracha5 implements Runnable
	{
		@Override
		public void run()
		{
			Util.boom(5);
		}
	}
	
	public static class Util
	{
		public static void boom(int x)
		{
			try
			{
				throw new NullPointerException("boom " + x);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}