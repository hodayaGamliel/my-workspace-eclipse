package agent;

public class Main {

	public static void main(String[] args)
	{
		//Test.simpleException_nonce_12();
		//Test.simpleLog_nonce_12();
		//Test.simpleExceptionCotrolledByStdin_nonce_12();
		//Test.exceptionInForLine_nonce_12();
		//Test.simpleGetter_nonce_12();
		//Test.exceptionInHiddenCode_nonce_12();	
		Test.exceptionWithTls_nonce_12();
		//Test.exceptionWithMdc_nonce_12();
		//Test.exceptionInDifferentThreadWhileMainSleep_nonce_12();
		
		//TestInherit.simpleException_nonce_12();
		
		try
		{	
			Thread.sleep(1000000);
		}
		catch(Exception e)
		{
			System.out.println("exception: " + e);
			//e.printStackTrace();
		}
	}
}
