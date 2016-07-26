import play.mvc.results.Result;
import play.mvc.results.ResultChild;

public class Main {
	
	public static void main(String[] args)
	{
		
		try 
		{
			throw new Result();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}			
		
		try 
		{
			throw new ResultChild();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		
		
		
//		try 
//		{
//			Result.myGoodException();
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//	
//		
//		try 
//		{
//			ResultChild.mySecondGoodException();
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
		
		
	}
}
