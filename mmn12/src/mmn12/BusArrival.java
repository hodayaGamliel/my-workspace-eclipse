package mmn12;

/**
 * Represents a BusArrival. BusArrival is represented by its line number, arrival time, number Of passengers.
 * @author Hodaya Gamliel
 */

public class BusArrival 
{
	// Final Variables
	final private int MIN_OF_LINE_NUMBER = 1;
	final private int MIN_OF_TIME = 0;
	final private int MIN_OF_PASS = 0;
	final private int MAX_OF_PASSENGERS = 70;
	final private int MAX_OF_LINE_NUMBER = 99;
	final private int MAX_OF_HOURS = 24;
	final private int MAX_OF_MIN_AND_SEC = 60;
	final private int SECONDS_IN_HOUR = 60;
	
	// Class attributes 
	int _lineNumber = 0;
	Time1 _arrivalTime;
	int _noOfPassengers = 0;

	/**
	 *  Constructs a BusArrival object. with line number, number of passengers, and time(hour, minute and second) of arrival if the parameters are illegal they will be set to 0.
	 * @param lineNum The bus line number (should be between 1-99)
	 * @param pass The number of passengers (should be between 0-70)
	 * @param h The hour of bus arrival (should be between 0-23)
	 * @param m The minute of bus arrival (should be between 0-59)
	 * @param s The second of bus arrival (should be between 0-59)
	 */
	public BusArrival(int lineNum, int pass, int h, int m, int s)
	{
		_lineNumber = ((lineNum >= MIN_OF_LINE_NUMBER && lineNum <= MAX_OF_LINE_NUMBER) ? lineNum : 1);
		_noOfPassengers = ((pass >= MIN_OF_PASS && pass <= MAX_OF_PASSENGERS) ? pass : MIN_OF_PASS);
		h = ((h >= MIN_OF_TIME && h < MAX_OF_HOURS) ? h : MIN_OF_TIME);   // validate hour
		m = ((m >= MIN_OF_TIME && m < MAX_OF_MIN_AND_SEC) ? m : MIN_OF_TIME); // validate minute
		s = ((s >= MIN_OF_TIME && s < MAX_OF_MIN_AND_SEC) ? s : MIN_OF_TIME); // validate second
		_arrivalTime = new Time1(h, m, s);
	} // end 1st constructor
	
	/**
	 *  Constructs BusArrival object. with line number, number of passengers, and time of arrival if the parameters are illegal they will be set to 0.
	 * @param lineNum The bus line number (should be between 1-99)
	 * @param pass The number of passengers (should be between 0-70)
	 * @param t The time of bus arrival
	 */
	public BusArrival(int lineNum, int pass, Time1 t)
	{
		_lineNumber = ((lineNum >= MIN_OF_LINE_NUMBER && lineNum <= MAX_OF_LINE_NUMBER) ? lineNum : MIN_OF_LINE_NUMBER);
		_noOfPassengers = ((pass >= MIN_OF_PASS && pass <= MAX_OF_PASSENGERS) ? pass : MIN_OF_PASS);
		_arrivalTime = new Time1(t); 
	} // end 2nd constructor
	
	/**
	 *  Copy constructor for a BusArrival. Constructs a BusArrival with the same attributes as another BusArrival.
	 * @param other The BusArrival object from which to construct the new BusArrival.
	 */
	public BusArrival(BusArrival other) 
	{
		_lineNumber = other._lineNumber;
		_arrivalTime = new Time1 (other.getArrivalTime());
		_noOfPassengers = other._noOfPassengers;
	} // end 3rd constructor
	
	/**
	 *  Returns the bus line number.
	 * @return the bus line number.
	 */
	public int getLineNum() 
	{
		return _lineNumber;
	} // end method getLineNum

	/***
	 *  Returns the bus arrival time.
	 * @return the bus arrival time
	 */
	public Time1 getArrivalTime() 
	{
		return new Time1(this._arrivalTime); // ???
	} // end method getArrivalTime
	
	/**
	 * Returns the number of passengers.
	 * @return the number of passengers.
	 */
	public int getNoOfPass() 
	{ 
		return _noOfPassengers;
	} // end method getNoOfPass
	
	/**
	 * Changes the BusArrival's line number. if the parameter is illegal the line number will remain unchanged
	 * @param num The BusArrival's new line number.
	 */
	public void setLineNum(int num) 
	{
		_lineNumber = ((num >= MIN_OF_LINE_NUMBER && num <= MAX_OF_LINE_NUMBER) ? num : 1);
	} // end method setLineNum

	/**
	 * Changes the BusArrival's time.
	 * @param t The BusArrival's new time.
	 */
	public void setArrivalTime(Time1 t) 
	{
		_arrivalTime.setHour(t.getHour());
		_arrivalTime.setMinute(t.getMinute());
		_arrivalTime.setSecond(t.getSecond());
	} // end method setArrivalTime
	
	/**
	 * Changes the BusArrival's number of passengers. if the parameter is illegal the number of passengers will remain unchanged
	 * @param num The BusArrival's new number of passengers.
	 */
	public void setNoOfPass(int num) 
	{
		_noOfPassengers = ((num >= MIN_OF_PASS && num <= MAX_OF_PASSENGERS) ? num : MIN_OF_PASS);
	} // end method setNoOfPass
	
	/**
	 * Checks if the received BusArrival is equal to this BusArrival.
	 * @param other The BusArrival to be compared with this BusArrival
	 * @return True if the received BusArrival is equal to this BusArrival
	 */
	public boolean equals(BusArrival other) 
	{
		return ((_arrivalTime._hour == other._arrivalTime._hour && _arrivalTime._minute == other._arrivalTime._minute && _arrivalTime._second == other._arrivalTime._second && _lineNumber == other._lineNumber && _noOfPassengers == other._noOfPassengers) ? true : false ); 
	} // end method equals
	
	/**
	 * Returns a string representation of this BusArrival (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers").
	 * @return String representation of this BusArrival (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers").
	 */
	public String toString() 
	{
		return "Bus no. "+ _lineNumber + " arrived at " + _arrivalTime.toString() + " with " + _noOfPassengers +" passengers";		
	} // end method toString

	/**
	 *  Checks if this bus's number of passengers is larger than other bus's number of passengers. 
	 * @param other The BusArrival to be compared with this BusArrival
	 * @return true if this bus's number of passengers is larger than other bus's number of passengers. false otherwise
	 */
	public boolean fuller(BusArrival other) 
	{
		return ((_noOfPassengers > other._noOfPassengers) ? true : false) ; 
	} // end method fuller
	
	/**
	 * Checks if this bus's arrival time is before other bus's arrival time.
	 * @param other The BusArrival to be compared with this BusArrival
	 * @return true if this bus's arrival time is before other bus's arrival time. false otherwise
	 */
	public boolean before(BusArrival other) 
	{
		return ((_arrivalTime.secFromMidnight() < other._arrivalTime.secFromMidnight()) ? true : false) ; 
	} // end method before
	
	/**
	 * Checks if this bus's number of passengers is equal to the maximum number of passengers allowed.
	 * @return true if this bus's number of passengers is equal to the maximum number of passengers allowed. false otherwise
	 */
	public boolean isFull()
	{
		return ((_noOfPassengers >= MAX_OF_PASSENGERS) ? true : false) ;
	} // end method isFull
	
	/**
	 * Calculates the difference (in minutes) between this bus arrival time and other.
	 * @param other The time to check the difference with.
	 * @return int difference in minutes
	 */
	public int elapsedTime(BusArrival other) 
	{
		if (_arrivalTime.secFromMidnight() > other._arrivalTime.secFromMidnight())
		{
			return ((int)(_arrivalTime.secFromMidnight() - other._arrivalTime.secFromMidnight()) / SECONDS_IN_HOUR) ;
		}
		else if (_arrivalTime.secFromMidnight() < other._arrivalTime.secFromMidnight())
		{
			return ((int)(other._arrivalTime.secFromMidnight() - _arrivalTime.secFromMidnight()) / SECONDS_IN_HOUR) ;
		}
		else 
		{
			return 0; 
		}
	} // end method elapsedTime
} // end class BusArrival