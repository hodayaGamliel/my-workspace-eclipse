package play.mvc.results;

public class Result extends RuntimeException
{
	
	public static void myGoodException() throws Exception 
	{

			throw new Exception("This is good exception");

	}
}
