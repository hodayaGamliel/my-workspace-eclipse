package a.b;

public class B1 
{
	public static void main(String[] args) 
	{
		try 
		{
			Exception e = new Exception("B1 ");
			throw e;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
