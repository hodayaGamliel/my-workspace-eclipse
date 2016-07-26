package a;

public class A2 
{
	public static void main(String[] args) 
	{
		try 
		{
			Exception e = new Exception("A2");
			throw e;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
