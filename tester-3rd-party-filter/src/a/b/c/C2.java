package a.b.c;

public class C2 {
	public static void main(String[] args) 
	{
		try 
		{
			Exception e = new Exception("C2 ");
			throw e;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
