package cartesian;

public class test1 
{
	public static void main(String[] args) throws Exception 
	{
			cartest1();
	}
	
	public static void cartest1() throws Exception
	{
				cartest2();

	}
	
	public static void cartest2() throws Exception
	{

				cartest3();
	
	}
	
	public static void cartest3() throws Exception
	{
		cartest4();
	}
	
	public static void cartest4() throws Exception
	{
		cartest5();
	}
	
	public static void cartest5() throws Exception
	{
			throw new Exception();
	}
}
