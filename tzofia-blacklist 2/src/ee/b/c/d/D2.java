package ee.b.c.d;

import java.util.logging.Level;
import java.util.logging.Logger;

public class D2
{
	public void d()
	{
		try
		{
			int a = 1 / 0;
		}
		catch (Exception ex)
		{
			
		}
		
		Logger.getAnonymousLogger().log(Level.SEVERE, "Stack bottom");
	}
}
