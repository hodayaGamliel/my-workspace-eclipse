package mmn12;

/**
 * Represents time - hours:minutes:seconds. Values must represent a proper time.
 * @author Hodaya Gamliel
 */

public class Time2 
{
	// Class Attributes  
	private long _secFromMid = 0; 

	// Final variables
	final private int MIN_OF_TIME = 0; 
	final private int SECONDS_IN_MINTUE = 60;
	final private int SECONDS_IN_HOUR = 3600;
	final private int MAX_OF_HOURS = 24;
	final private int MAX_OF_MIN_AND_SEC = 60;
 
	/**
	 * Constructs a Time2 object. Construct a new time instance with the specified hour, minute and second. 
	 * hour should be between 0-23, otherwise it should be set to 0. minute and second should be between 0-59, otherwise they should be set to 0.
	 * @param h hour
	 * @param m minute
	 * @param s second
	 */
	public Time2 (int h, int m, int s) 
	{
		h = ((h >= MIN_OF_TIME && h < MAX_OF_HOURS) ? h : MIN_OF_TIME);   // validate hour
		m = ((m >= MIN_OF_TIME && m < MAX_OF_MIN_AND_SEC) ? m : MIN_OF_TIME); // validate minute
		s = ((s >= MIN_OF_TIME && s < MAX_OF_MIN_AND_SEC) ? s : MIN_OF_TIME); // validate second
		this._secFromMid = (long)((h * SECONDS_IN_HOUR) + (m * SECONDS_IN_MINTUE) + s) ;
	} // end 1st constructor
	
	/**
	 * Copy constructor for Time2. Constructs a time with the same variables as another time.
	 * @param other The time object from which to construct the new time
	 */
	public Time2 (Time2 other)
	{
		this._secFromMid = other._secFromMid;
	} // end 2nd constructor

	/**
	 *  Method getHour - Returns the hour of the time.
	 * @return The hour of the time
	 */
	public int getHour() 
	{
		return ((int)(_secFromMid)/SECONDS_IN_HOUR);
	} // end method getHour
	
	/**
	 *  Method getMinute - Returns the minute of the time.
	 * @return The minute of the time
	 */
	public int getMinute() 
	{
		return (int)(((_secFromMid) - (getHour()*SECONDS_IN_HOUR)) / SECONDS_IN_MINTUE);
	} // end method getMinute
	
	/**
	 *  Method getSecond - Returns the second of the time.
	 * @return The second of the time
	 */
	public int getSecond() 
	{
	return (int)((_secFromMid) - (getHour()*SECONDS_IN_HOUR) - (getMinute()*SECONDS_IN_MINTUE));
	} // end method getSecond
	
	/**
	 *  Method setHour - Changes the hour of the time. If illegal number is received hour will remain unchanged   
	 * @param num The new hour
	 */
	public void setHour (int num)
	{	
		_secFromMid =  ((num >= MIN_OF_TIME && num < MAX_OF_HOURS) ? (_secFromMid - (getHour()*SECONDS_IN_HOUR) + (num * SECONDS_IN_HOUR)) : MIN_OF_TIME);
	} // end method setHour
	
	/**
	 *  Method setMinute - Changes the minute of the time. If illegal number is received minute will remain unchanged.
	 * @param num The new minute
	 */
	public void setMinute (int num)
	{
		_secFromMid =  ((num >= MIN_OF_TIME && num < MAX_OF_MIN_AND_SEC) ? (_secFromMid - (getMinute()*SECONDS_IN_MINTUE) + (num * SECONDS_IN_MINTUE)) : MIN_OF_TIME);
	} // end method setMinute
	
	/**
	 *  Method setSecond - Changes the second of the time. If illegal number is received second will remain unchanged.
	 * @param num The new second
	 */
	public void setSecond (int num)
	{
		_secFromMid =  ((num >= MIN_OF_TIME && num < MAX_OF_MIN_AND_SEC) ? (_secFromMid - getSecond() + num) : MIN_OF_TIME);
	} // end method setSecond
	
    /**
     *  Method secFromMidnight - Calculate seconds since midnight.
     * @return Seconds passed since midnight
     */
	  public long secFromMidnight()
      {
              return _secFromMid;
      }	
	
	/**
	 *  Method toString - Returns a string representation of this time(hh:mm:ss).
	 *  @return String representation of this time(hh:mm:ss).
	 */
	public String toString() 
	{
		final int TWO_DIGITS = 10; // For checking if it's an two digit number (adding "0" left to one digit number). 
		String string = "";
		string += (this.getHour() < TWO_DIGITS) ? ("0"+this.getHour()) : (""+this.getHour());
		string += ":";
		string += (this.getMinute() < TWO_DIGITS) ? ("0"+this.getMinute()) : (""+this.getMinute());
		string += ":";
		string += (this.getSecond() < TWO_DIGITS) ? ("0"+this.getSecond()) : (""+this.getSecond());
		return string; 		
	} // end method toString
	
	/**
	 *  Method equals - Checks if the received time is equal to this time.
	 * @param other The time to be compared with this time
	 * @return True if the received time is equal to this time
	 */
	public boolean equals(Time2 other) 
	{
		return ((secFromMidnight() == other.secFromMidnight()) ? true : false); 
	} // end method equals
	
	/**
	 *  Method before - Checks if this time is before a received time.
	 * @param other The time to check if this time is before
	 * @return True if this time is before other time
	 */
	public boolean before(Time2 other)
	{
		return ((_secFromMid < other.secFromMidnight()) ? true : false); 
	} // end method before
	
	/**
	 *  Method after - Checks if this time is after a received time.
	 * @param other The time to check if this time is after
	 * @return True if this time is after other time
	 */
	public boolean after(Time2 other) 
	{
		return other.before(this);		
	} // end method after
	
	/**
	 *  Method difference - Calculates the difference (in seconds) between two times.
	 * @param other The time to check the difference with. Assumption: this time is after other time
	 * @return int difference in seconds
	 */
	public int difference(Time2 other)
	{
		return (int)(_secFromMid - other.secFromMidnight());
	} // end method difference	
		
} // end class Time2
