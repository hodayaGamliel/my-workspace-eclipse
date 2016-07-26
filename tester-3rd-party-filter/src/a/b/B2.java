package a.b;

public class B2 {
	public static void main(String[] args) 
	{
		try 
		{
			Exception e = new Exception("B2");
			throw e;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
