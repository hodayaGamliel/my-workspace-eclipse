package takipi.tests;

public class TestersApi 
{

	/**
	 * 
	 * @param fullClassName
	 * @return
	 */
	public static boolean isInFilter(String fullClassName) 
	{
		return true;
	}
	
	/**
	 * Returns Event object by error name  
	 * @param errorName error name of exception
	 * @return  Event object
	 */
	public static Event getEventByErrorName(String errorName) 
	{
		Event event = new Event();
		return event;
	}
	
	/**
	 * Returns Event object by error location  
	 * @param errorLocation error location of exception (method and class name)
	 * @return  Event object
	 */
	
	/**
	 *  Returns Event object by error location (method and class name)
	 * @param errorLocationClass the class error location of exception
	 * @param errorLocationMethod  the method  error location of exception
	 * @return
	 */
	public static Event getEventByErrorLocation(String errorLocationClass , String errorLocationMethod)  //method instance 
	{
		Event event = new Event();
		return event;
	}
	
}
