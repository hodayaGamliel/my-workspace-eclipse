package play.mvc.results;

public class ResultChild extends Result
{
	public static void mySecondGoodException() throws Exception 
	{

			throw new Exception("This is my second good exception , which extending Result class");


	}
}
