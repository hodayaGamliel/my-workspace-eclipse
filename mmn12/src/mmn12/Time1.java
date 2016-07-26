package mmn12;

/**
 * Represents time - hours:minutes:seconds. Values must represent a proper time.
 * @author Hodaya Gamliel
 */

public class Time1 
{	
	
	// Final variables
	final private int MIN_OF_TIME = 0;
	final private int SECONDS_IN_MINTUE = 60;
	final private int SECONDS_IN_HOUR = 3600;
	final private int MAX_OF_HOURS = 24;
	final private int MAX_OF_MIN_AND_SEC = 60;
	
	 // Class Attributes 
	int _hour = MIN_OF_TIME; 
	int _minute = MIN_OF_TIME;
	int _second = MIN_OF_TIME;
	
	/**
	 * Constructs a Time1 object . Constructs a new time instance with the specified hour, minute and second.
	 * hour should be between 0-23, otherwise it should be set to 0. minute and second should be between 0-59, otherwise they should be set to 0.
	 * @param h hour
	 * @param m minute
	 * @param s second 
	 */
	public Time1 (int h, int m, int s) 
	{
		_hour = ((h >= MIN_OF_TIME && h < MAX_OF_HOURS) ? h : MIN_OF_TIME);   // validate hour
		_minute = ((m >= MIN_OF_TIME && m < MAX_OF_MIN_AND_SEC) ? m : MIN_OF_TIME); // validate minute
		_second = ((s >= MIN_OF_TIME && s < MAX_OF_MIN_AND_SEC) ? s : MIN_OF_TIME); // validate second
	} // end 1st constructor
	
	/**
	 *  Copy constructor for Time1. Constructs a time with the same variables as another time.
	 * @param other The time object from which to construct the new time
	 */
	public Time1 (Time1 other)
	{
		_hour = other._hour;
		_minute = other._minute;
		_second = other._second;
	} // end 2nd constructor

	/**
	 *  Method getHour - Returns the hour of the time.
	 * @return The hour of the time
	 */
	public int getHour() 
	{
		return _hour;
	} // end method getHour
	
	/**
	 *  Method getMinute - Returns the minute of the time.
	 * @return The minute of the time
	 */
	public int getMinute() 
	{
		return _minute;
	} // end method getMinute
	
	/**
	 *  Method getSecond - Returns the second of the time.
	 * @return - The second of the time
	 */
	public int getSecond() 
	{
		return _second;	
	} // end method getSecond
	
	/**
	 *  Method setHour - Changes the hour of the time. If illegal number is received hour will remain unchanged.    
	 * @param num The new hour
	 */
	public void setHour (int num)
	{
		_hour = ((num >= MIN_OF_TIME && num < MAX_OF_HOURS) ? num : MIN_OF_TIME);   // validate hour
	} // end method setHour
	
	/**
	 *  Method setMinute - Changes the minute of the time. If illegal number is received minute will remain unchanged.  
	 * @param num The new minute
	 */
	public void setMinute (int num)
	{
		_minute = ((num >= MIN_OF_TIME && num < MAX_OF_MIN_AND_SEC) ? num : MIN_OF_TIME);   // validate hour
	} // end method setMinute
	
	/**
	 *  Method setSecond - Changes the second of the time. If illegal number is received second will remain unchanged.    
	 * @param num The new second 
	 */
	public void setSecond (int num)
	{
		_second = ((num >= MIN_OF_TIME && num < MAX_OF_MIN_AND_SEC) ? num : MIN_OF_TIME);   // validate hour
	} // end method setSecond
	
	/**
	 *  Method toString - Returns a string representation of this time (hh:mm:ss).
	 *  @return String representation of this time (hh:mm:ss).
	 */
	public String toString() 
	{
		final int TWO_DIGITS = 10; // For checking if it's an two digit number (adding "0" left to one digit number). 
		String string = "";
		string += (_hour < TWO_DIGITS) ? ("0"+_hour) : (""+_hour);
		string += ":";
		string += (_minute < TWO_DIGITS) ? ("0"+_minute) : (""+_minute);
		string += ":";
		string += (_second < TWO_DIGITS) ? ("0"+_second) : (""+_second);
		return string; 

	} // end method toString
		
	/**
	 *  Method secFromMidnight - Calculate seconds since midnight.
	 * @return Seconds passed since midnight
	 */
	public long secFromMidnight()
	{
		return (long)((_hour*SECONDS_IN_HOUR) + (_minute*SECONDS_IN_MINTUE) + _second);
	} // end method secFromMidnight
	
	/**
	 *  Method equals - Checks if the received time is equal to this time.
	 * @param other The time to be compared with this time
	 * @return True if the received time is equal to this time
	 */
	public boolean equals(Time1 other) 
	{
		  return ((secFromMidnight() == other.secFromMidnight()) ? true : false );
	} // end method equals
	
	/**
	 *  Method before -Checks if this time is before a received time.
	 * @param other The time to check if this time is before
	 * @return True if this time is before other time
	 */
	public boolean before(Time1 other)
	{
		return ((this.secFromMidnight() < other.secFromMidnight()) ? true : false );
	} // end method before
	
	/**
	 *  Method after - Checks if this time is after a received time.
	 * @param other The time to check if this time is before
	 * @return True if this time is before other time
	 */
	public boolean after(Time1 other) 
	{
		return other.before(this);
	} // end method after
	
	/**
	 *  Method difference - Calculates the difference (in seconds) between two times.
	 * @param other The time to check the difference with. Assumption: this time is after other time
	 * @return int difference in seconds
	 */
	public int difference(Time1 other)
	{
		return (int)(secFromMidnight() - other.secFromMidnight());
	} // end method difference	
	
} // end class Time1
