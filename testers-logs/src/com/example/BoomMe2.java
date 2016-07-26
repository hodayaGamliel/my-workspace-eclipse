package com.example;


public class BoomMe2 
{

	public static void main(String[] args)
	{
		new BoomMe2().boom();
	}

	private void boom()
	{
		while (true)
		{
			threwLogs();
		}
	}
	public static void threwLogs() 
	{
		BoomMeInternal internal = new BoomMeInternal();
		internal.boom();
	}

}
