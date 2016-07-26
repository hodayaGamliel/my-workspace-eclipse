package main.java.hod.test;

import java.util.Random;


public class Hod {
		
	public static final Random rand = new Random();

	public void throwExcep() 
	{
		try
		{
			if (rand.nextBoolean())
			{
				 throwExcepa();
			}
			else
			{
				 throwExcepb();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
	}

	public int throwExcepa() 
	{
		if (rand.nextBoolean())
		{
			throw new IllegalStateException("IllegalStateException");
		}
		else
		{
			return 2;
		}
	}
	
	public int throwExcepb() 
	{
		if (rand.nextBoolean())
		{
			throw new NullPointerException("NullPointerException");
		}
		else
		{
			return 3;
		}
	}
	
}
