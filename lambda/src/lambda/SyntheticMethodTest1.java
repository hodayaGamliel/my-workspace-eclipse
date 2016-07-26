package lambda;
 
public class SyntheticMethodTest1 
{
    private A aObj = new A();
 
    public class A 
    {
        private int i;
    }
 
    private class B 
    {
        private int i = aObj.i;
    }

    public void run() 
    {
    	try 
    	{
    		 SyntheticMethodTest1 synMet = new SyntheticMethodTest1();
    	     B bObj = synMet.new B();
    	     System.out.println(bObj.i);
    	     throw new Exception();
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
		}
       
        
	}
    
}