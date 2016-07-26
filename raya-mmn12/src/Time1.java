// Raya Dimarski
// MMN_12_Q1
// The program represents time - hours:minutes:seconds.
/**
 * 
 * Represents time - hours:minutes:seconds. Values must represent a proper time.
 */
public class Time1
{
   //Variables
   final private int SEC_IN_MINUTE = 60;
   final private int MIN_IN_HOUR = 60;
   final private int MAX_SEC_AND_MIN =59;
   final private int MAX_HOUR =23;
   final private int MIN_TIME = 0;
   final private int SINGLE_DIGIT = 10; //Used to find single digit in toString() method.
   
   private int _hour;
   private int _minute;
   private int _second;
   
   //Constructors
    /**
    * Constructs a Time1 object . Constructs a new time instance with the specified hour, minute and second. hour should be between 0-23, otherwise it should be set to 0. minute and second should be between 0-59, otherwise they should be set to 0.
    * @param h hour
    * @param m minute
    * @param s second
    */
   //Constructs a Time1 object . Constructs a new time instance with the specified hour, minute and second.
   //hour should be between 0-23, otherwise it is set to 0. minute and second should be between 0-59, otherwise they set to 0.
   public Time1 (int h, int m, int s) 
   {        
       if (h < MIN_TIME || h > MAX_HOUR)
           h = MIN_TIME;  
       if (m < MIN_TIME || m > MAX_SEC_AND_MIN)
           m = MIN_TIME;
       if (s < MIN_TIME || s > MAX_SEC_AND_MIN)
           s = MIN_TIME;
           
       _hour = h;
       _minute = m;
       _second = s;
   }
   /**
    * Copy constructor for Time1. Constructs a time with the same variables as another time.
    * @param other The time object from which to construct the new time
    */
   //Copy constructor for Time1. Constructs a time with the same variables as another time that recives.
   public Time1 (Time1 other) 
   {
      _hour = other.getHour();
      _minute = other.getMinute();
      _second = other.getSecond();
    }
    
   //Methods
   /** 
    * Returns the hour of the time.
    * @return The hour of the time
    */
   //The method returns the hour of the time.
   public int getHour()
   {
       return _hour;
   }
   /**Returns the minute of the time.
   * @return The minute of the time
   */
  //The method returns the minute of the time.
   public int getMinute()
   {
       return _minute;
   }
   /**Returns the second of the time.
   * @return The second of the time
   */
  //The method returns the second of the time.
   public int getSecond()
   {
       return _second;
   }
   /** Changes the hour of the time.
   * Changes the hour of the time. If illegal number is received hour will remain unchanged.
   * @param num The new hour
   */
  //The method gets the new hour and set it to Time1 object.
  //If illegal number is received hour will remain unchanged.
   public void setHour (int num)
   {
       if ((num >= MIN_TIME && num <= MAX_HOUR)&&(this.getHour() != num))
            _hour= num;
   }
   /** Changes the minute of the time.
    * Changes the minute of the time. If illegal number is received minute will remain unchanged.
    * @param num The new minute
     */
    //The method gets the new minute and set it to Time1 object.
  //If illegal number is received minute will remain unchanged.
   public void setMinute (int num)
   {
       if  ((num >= MIN_TIME && num <= MAX_SEC_AND_MIN) && (this.getMinute() != num))
            _minute = num;
   }
    /**  Changes the second of the time.
     * Changes the second of the time. If illegal number is received second will remain unchanged.
     * @param num The new second
     */
   //The method gets the new second and set it to Time1 object.
  //If illegal number is received second will remain unchanged.
   public void setSecond (int num)
   {
       if ((num >= MIN_TIME && num <= MAX_SEC_AND_MIN) && (this.getSecond() != num))
            _second = num;
   }
   /**
    * Returns a string representation of this time (hh:mm:ss).
    * @return String representation of this time (hh:mm:ss).
    */
   //The method returns a string representation of this time (hh:mm:ss).
   public String toString()
   {
       String h=Integer.toString(_hour);
       String m=Integer.toString(_minute);
       String s=Integer.toString(_second);
       if (_hour < SINGLE_DIGIT)
            h = "0"+ h;
       if (_minute < SINGLE_DIGIT)
            m="0"+m;
       if (_second < SINGLE_DIGIT)
            s="0"+s;
       
       return h+":"+m+":"+s;
    }
   /**
    * Calculate seconds since midnight.
    * @return Seconds passed since midnight
    */
   //The method calculate seconds since midnight.
    public long secFromMidnight()
   {
       long secFromMid = 0;
       secFromMid=_second+(_minute*SEC_IN_MINUTE)+(_hour * MIN_IN_HOUR * SEC_IN_MINUTE);
       return secFromMid;
   }
   /**
    * Checks if the received time is equal to this time.
    * @param other  The time to be compared with this time
    * @return True if the received time is equal to this time
    */
   //The method Checks and return true if the received time is equal to this time, otherwise return false.
   public boolean equals (Time1 other)
   {
       if (_hour == other.getHour() && _minute == other.getMinute() && _second == other.getSecond() )
            return true;
       else
            return false;
   }
   /**
    * Checks if this time is before a received time.
    * @param other The time to check if this time is before
    * @return True if this time is before other time
    */
  //The method Checks and return true if this time is before a received time, otherwise return false.
   public boolean before (Time1 other)
   {
       if ( _hour < other.getHour())
            return true;
       else
       {
            if (_hour == other.getHour() && _minute < other.getMinute())
                return true;
            else
                if (_minute == other.getMinute() && _second < other.getSecond())
                    return true;
        }
        return false;
    }
    /**
    * Checks if this time is after a received time.
    * @param other  The time to check if this time is after
    * @return True if this time is after other time
    */
   //The method Checks and return true if this time is after a received time, otherwise return false.
    public boolean after (Time1 other)
   {
        if ((this.before(other)== false) && (other.before(this)== false))
            return false;
        else
            return (!(this.before(other)));
   }
    /**
    * Calculates the difference (in seconds) between two times.
    * @param other The time to check the difference with. Assumption: this time is after other timee
    * @return int difference in seconds
    */
   //The method calculates the difference (in seconds) between two times and return the difference in seconds.
   public int difference (Time1 other)
   {
       
       return (int)(this.secFromMidnight() - other.secFromMidnight());
      
    }
   
}




