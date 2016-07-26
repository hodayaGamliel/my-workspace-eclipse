package a.b.c.d;

//import java.util.logging.Level;
//import java.util.logging.Logger;

public class D5 
{
	public void d()
	{
		try
		{
			int a = 1 / 0;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
	//	Logger.getAnonymousLogger().log(Level.SEVERE, "Stack bottom");
	}
}
