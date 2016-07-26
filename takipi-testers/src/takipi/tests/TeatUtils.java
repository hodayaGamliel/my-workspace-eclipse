package takipi.tests;

public class TeatUtils 
{
	/**
	 * Returns the size of stack trace
	 * @param methodsArr array of stack trace methods
	 * @return the size of stack trace
	 */
	public static int getStackTraceSize(Method[] methodsArr) 
	{
		return methodsArr.length;
	}
	
	/**
	 * Returns the error location method from stack trace
	 * @param methodsArr array of stack trace methods
	 * @return the error location method .
	 */
	public static String getErrorLocation(Method[] methodsArr) 
	{
		return  methodsArr[0].getMethodName();
	}
	
	/**
	 * Return the error rate for event
	 * @param event event object 
	 * @return the error rate
	 */
	public static int getErrorRate(Event event) 
	{
		return (event.getInvocations() / event.getTimes());
	}
	
}
