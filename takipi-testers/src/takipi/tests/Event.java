package takipi.tests;


import java.util.Calendar;
import java.util.TimeZone;


public class Event 
{
	private String errorType;
	private String errorName; 	
	private String errorLocation;	
	private String entryPoint;	
	private String jvm;	
	private String server;	
	private String thread;

	private int invocations;	
	private int times;
	
	/**
	 * Returns the JVM of event
	 * @return the JVM of event
	 */
	public String getJVM() 
	{
		return jvm;
	}
	
	/**
	 * Returns the server of event
	 * @return the server of event
	 */
	public String getServer() 
	{
		return server;
	}
	
	/**
	 *  Returns the error type of event
	 * @return the error type of event
	 */
	public String getErrorType() 
	{
		return errorType;
	}
	
	/**
	 *  Returns the error name of event
	 * @return the error name of event
	 */
	public String getErrorName() 
	{
		return errorName;
	}
	
	/**
	 *  Returns the entry point of event
	 * @return the error type of event
	 */
	public Method getEntryPoint() 
	{
		Method entryPoint = new Method();
		return entryPoint;
	}
	
	/**
	 *  Returns the thread of event
	 * @return the thread of event
	 */
	public String getThread() 
	{
		return thread;
	}
	
	/**
	 *  Returns the stack trace of event (Without 3rd party methods)
	 * @return  the stack trace of event as methods array
	 */
	public Method[] getStackTrace() 
	{
		Method[] method = new Method[2]; //stack trace size  ????
		for (int i = 0; i < method.length; i++) 
		{
			method[i] = new Method();
		}
		return method;	
	}

	/**
	 *  Returns the stack trace of event (Include 3rd party methods)
	 * @return  the stack trace of event as methods array
	 */
	public Method[] getFullStackTrace() 
	{
		Method[] method = new Method[2]; //stack trace size  ????
		for (int i = 0; i < method.length; i++) 
		{
			method[i] = new Method();
		}
		return method;	
	}
	
	

	//Complex stats (MySql)
	
	/**
	 *  Returns the invocations of event (How many times the exception happened)
	 * @return  the invocations of event 
	 */
	public int getInvocations() 
	{
		return invocations;
	}
	
	/**
	 *  Returns the times of event (How many times the method executed )
	 * @return  the times of event 
	 */
	public int getTimes() 
	{
		return times;
	}
	
	/**
	 *  Returns the last time of event
	 * @return  the times of event 
	 */
	public Calendar getLastTime() 
	{
		Calendar c1 = Calendar.getInstance();
		return c1;
	}
	
	/**
	 *  Returns the first time of event
	 * @return  the times of event 
	 */
	public Calendar getFirstTime() 
	{
		Calendar c2 = Calendar.getInstance();
		return c2;
	}


	/**
	 * Returns the number of recorded hits of event within time .
	 * @param t1 from this time
	 * @param t2 to this time
	 * @return the number of recorded hits of event within time .
	 */
	public int getRecordedHitsNumInTime(Calendar t1 , Calendar t2 ) 
	{
		return 1;
	}
	
	/**
	 * Returns the number of all hits of event within time .
	 * @param t1 from this time
	 * @param t2 to this time
	 * @return the number of all hits of event within time .
	 */
	public int getAllHitsNumInTime(Calendar t1 , Calendar t2 ) 
	{
		return 1;
	}

}
