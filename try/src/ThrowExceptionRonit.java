import java.io.IOException;

public class ThrowExceptionRonit
{

	public static void main (String[] args) throws Exception
	{
	
		int x = 0;
	      while( x < 50 ) 
	      {
	    	  System.out.println("value of x : " + x );	 
		       
			  if ( x % 2 == 0 )
			  {
				  test();
		      }
			  x++;
	      }
	      Thread.sleep(5000000);
	      System.out.println("buy");
	}

	public static void test() {

	    try 
	    {
	    		 throw new Exception(); 	    	
		} 
	    catch (Exception e)
	    {
			e.printStackTrace();
		} 
	 
	}
	
}
