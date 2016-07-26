import jexxus.server.Server;


public class Main 
{
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		decomp();	
	}

	public static void decomp() throws InterruptedException
	{
		while (true)
		{     
	        try
	        {
	            Server server = new Server(null, 1, true);
	            server.shutdown(true);
	        } catch (Exception e) {
	            Thread.sleep(5000);
	        }
	        
	    }
	}
}
