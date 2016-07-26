package a;

public class A1 {
	
	public static void main(String[] args) 
	{
		try 
		{
			Exception e = new Exception("A1");
			throw e;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
