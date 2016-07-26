package a.b.c.d;

public class D2 
{
	public static void main(String[] args) 
	{
		try 
		{
			Exception e = new Exception("D2");
			throw e;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
