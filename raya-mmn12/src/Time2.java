//Raya Dimarski
//MMN_12_Q2
//The program represents time - hours:minutes:seconds.
/** 
 *Represents time - hours:minutes:seconds. Values must represent a proper time.
 */
public class Time2
{
    //Variables
    final private int SEC_IN_MINUTE= 60;
    final private int MIN_IN_HOUR= 60;
    final private int MAX_SEC_AND_MIN = 59;
    final private int MAX_HOUR = 23;
    final private int MIN_TIME = 0;
    final private int SINGLE_DIGIT= 10;
    
    private long _secFromMid;
    
    //Constructors
    /**
     *  Constructs a Time2 object.
     *  Constructs a Time2 object. Construct a new time instance with the specified hour, minute and second. hour should be between 0-23, otherwise it should be set to 0. minute and second should be between 0-59, otherwise they should be set to 0.
     *  @param h hour
     *  @param m minute
     *  @param s second
        */
    //Construct a new Time2 instance with the specified hour, minute and second. 
    //hour should be between 0-23, otherwise it is set to 0, minute and second should be between 0-59, otherwise they set to 0.
    public Time2 (int h, int m, int s) 
   {   
       if (h < MIN_TIME || h > MAX_HOUR)
           h = MIN_TIME;  
       if (m < MIN_TIME || m > MAX_SEC_AND_MIN)
           m = MIN_TIME;
       if (s < MIN_TIME || s > MAX_SEC_AND_MIN)
           s = MIN_TIME;
           
       _secFromMid = s + m * SEC_IN_MINUTE + h * MIN_IN_HOUR * SEC_IN_MINUTE;
   }
   /**
    *    Copy constructor for Time2.
    *    Copy constructor for Time2. Constructs a time with the same variables as another time.
    *    @param other  The time object from which to construct the new time
    */
   //Copy constructor for Time2. Constructs a time with the same variables as another time that it gets.
   public Time2 (Time2 other)
   {
        _secFromMid = other.getSecond() + other.getMinute()*SEC_IN_MINUTE + other.getHour()*MIN_IN_HOUR * SEC_IN_MINUTE;
   }
   
   //Methods
   /**
    * Returns the hour of the time.
    * @return The hour of the time
    */
   //The method returns the hour of the time.
   public int getHour()
   {
       return (int)(_secFromMid / MIN_IN_HOUR / SEC_IN_MINUTE);
   }
   /**
    * Returns the minute of the time.
    * @return The minute of the time
    */
   //The method returns the minute of the time.
   public int getMinute()
   {
       return (int)((_secFromMid - (this.getHour()* MIN_IN_HOUR * SEC_IN_MINUTE ))/ SEC_IN_MINUTE);
   }
   /**
    * Returns the second of the time.
    * @return The second of the time
    */
   //The method returns the second of the time.
   public int getSecond()
   {
       return (int)(_secFromMid - (this.getHour()* MIN_IN_HOUR * SEC_IN_MINUTE) - this.getMinute()*SEC_IN_MINUTE);
   }
   /**
    * Changes the hour of the time. If illegal number is received hour will remain unchanged.
    * @param num The new hour
    */
   //The method gets a new hour and set it to the Time2 object.If illegal number is received hour will remain unchanged.
  public void setHour(int num)
  {
       if  (num <= MAX_HOUR && num >= MIN_TIME && this.getHour() != num)
            _secFromMid = this.getSecond() + this.getMinute() * SEC_IN_MINUTE + num * MIN_IN_HOUR * SEC_IN_MINUTE;
        
  }
  /**
   * Changes the minute of the time. If illegal number is received minute will remain unchanged.
   * @param num The new minute
   */
  //The method gets the minutes and set it to the Time2 object. If illegal number is received minute will remain unchanged.
  public void setMinute(int num)
  {
      if  (num <= MAX_SEC_AND_MIN && num >= 0 && this.getMinute() != num)
           _secFromMid = this.getSecond() + num * SEC_IN_MINUTE + this.getHour() * MIN_IN_HOUR * SEC_IN_MINUTE;
        
  }
  /**
   * Changes the second of the time. If illegal number is received second will remain unchanged.
   * @param num The new second
   */
  //The method gets the seconds and set it to the Time2 object. If illegal number is received seconds will remain unchanged.
  public void setSecond(int num)
  {
      if  (num <= MAX_SEC_AND_MIN && num >= 0 && this.getSecond() != num)
           _secFromMid = num + this.getMinute() * SEC_IN_MINUTE + this.getHour() * MIN_IN_HOUR * SEC_IN_MINUTE;
        
  }
  /**
   * Calculate seconds since midnight.
   * @return Seconds passed since midnight
   */
  //The method calculate seconds since midnight.
  public long secFromMidnight()
  {
      return _secFromMid;
  }
  /**
   * Checks if the received time is equal to this time.
   * @param other The time to be compared with this time
   * @return True if the received time is equal to this time
   */
  //The method checks and return true if the received time is equal to this time, otherwise return false.
  public boolean equals (Time2 other)
  {
      return (this.secFromMidnight() == other.secFromMidnight()) ? true : false;
  }
  /**
   * Checks if this time is before a received time.
   * @param other  The time to check if this time is before
   * @return True if this time is before other time
   */
  //The method checks and return true if this time is before a received time, otherwise return false.
  public boolean before (Time2 other)
  {
      if ( this.getHour() < other.getHour())
            return true;
       else
       {
            if (this.getHour() == other.getHour() && this.getMinute() < other.getMinute())
                return true;
            else if (this.getMinute() == other.getMinute() &&this.getSecond() < other.getSecond())
                    return true;
        }
      return false;
  }
  /**
   * Checks if this time is after a received time.
   * @param other The time to check if this time is after
   * @return True if this time is after other time
   */
 //The method checks and return true if this time is after a received time, otherwise return false.
  public boolean after (Time2 other)
  {
      if ((this.before(other)== false) && (other.before(this)== false))
        return false;
      else
        return (!(this.before(other)));
  }
  /**
   * Calculates the difference (in seconds) between two times.
   * @param other The time to check the difference with. Assumption: this time is after other time
   * @return int difference in seconds
     */
  //The method calculates the difference (in seconds) between two times.
  public int difference(Time2 other)
  {
      return (int)(this.secFromMidnight() - other.secFromMidnight());
  }
  /**
   * Returns a string representation of this time(hh:mm:ss).
   * @return String representation of this time(hh:mm:ss).
   */
  //The method returns a string representation of this time(hh:mm:ss).
  public String toString()
  {
      String h=Integer.toString(this.getHour());
      String m=Integer.toString(this.getMinute());
      String s=Integer.toString(this.getSecond());
       if (Integer.parseInt(h) < SINGLE_DIGIT)
            h = "0"+ h;
       if (Integer.parseInt(m) < SINGLE_DIGIT)
            m="0"+m;
       if (Integer.parseInt(s) < SINGLE_DIGIT)
            s="0"+s;
       
       return h+":"+m+":"+s;
  }
}
