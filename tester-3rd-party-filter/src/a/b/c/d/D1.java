package a.b.c.d;

public class D1 
{
	public static void main(String[] args) 
	{
		try 
		{
			Exception e = new Exception("D1 ");
			throw e;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
