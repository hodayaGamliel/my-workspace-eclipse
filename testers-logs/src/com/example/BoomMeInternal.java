package com.example;

import com.example.BoomMe1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoomMeInternal
{
private static Logger logger1 = LoggerFactory.getLogger(BoomMe1.class);
private static int i = 0;

public void boom()
{
		try
		{
			if (i++ % 2 == 0 && true)
			{
				logger1.error("Error1");
				logger1.warn("Warning2");
				throw new Exception();

				logger1.error("Error3");
				logger1.warn("Warning4");

			}
		
			Thread.sleep(500);
			logger1.warn("Warning5");
			throw new Exception();

			logger1.error("Error6");
			logger1.warn("Warning7");

			logger1.error("Error8");
		
			throw new Exception();
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
		
	try
	{
		Thread.sleep(2000);
	}
	catch (Exception e)
	{
	
	}
}
}