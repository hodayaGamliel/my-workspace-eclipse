//Raya Dimarski
//MMN_12_Q3
//The program represents a BusArrival. BusArrival is represented by its line number, arrival time, number Of passengers.
/**
 * Represents a BusArrival. BusArrival is represented by its line number, arrival time, number Of passengers.
 */
public class BusArrival
{
 //Variables
 final int MAX_NO_OF_PASSENGERS = 70;
 final int MIN_NO_OF_PASSENGERS = 0;
 final int MAX_LINE_NUMBER = 99;
 final int MIN_LINE_NUMBER = 1;
 final int SEC_IN_MINUTE= 60;
 
 //Private attributes
 private int _lineNumber;
 private Time1 _arrivalTime;
 private int _noOfPassengers;
 
 //Constructors:
 /** Constructs a BusArrival object.
  * Constructs a BusArrival object. with line number, number of passengers, and time(hour, minute and second) of arrival if the parameters are illegal they will be set to 0.
    * @param lineNum   The bus line number (should be between 1-99)
    * @param pass  The number of passengers (should be between 0-70)
    * @param h  The hour of bus arrival (should be between 0-23)
    * @param m  The minute of bus arrival (should be between 0-59)
    * @param s  The second of bus arrival (should be between 0-59)
      */
 //The constructor gets line number, number of passengers and the arrival time and Constructs the BusArrival object.
 public BusArrival (int lineNum, int pass, int h, int m, int s)
 {
    if (lineNum < MIN_LINE_NUMBER || lineNum > MAX_LINE_NUMBER)
        _lineNumber = MIN_LINE_NUMBER;
    else
        _lineNumber = lineNum;
    if (pass < MIN_NO_OF_PASSENGERS || pass > MAX_NO_OF_PASSENGERS )
        _noOfPassengers = MIN_NO_OF_PASSENGERS;
    else
        _noOfPassengers = pass;
   _arrivalTime = new Time1(h,m,s);
 }

 /** Constructs BusArrival object.
    * Constructs BusArrival object. with line number, number of passengers, and time of arrival if the parameters are illegal they will be set to 0.
    * @param lineNum  The bus line number (should be between 1-99)
    * @param pass  The number of passengers (should be between 0-70)
    * @param t  The time of bus arrival
      */
 //The constructor gets line number, number of passengers and the arrival time as Time1 object and Constructs the BusArrival object.
 public BusArrival (int lineNum, int pass, Time1 t)
 {
     if (lineNum < MIN_LINE_NUMBER || lineNum > MAX_LINE_NUMBER)
        _lineNumber = MIN_LINE_NUMBER;
    else
        _lineNumber = lineNum;
    if (pass < MIN_NO_OF_PASSENGERS || pass > MAX_NO_OF_PASSENGERS )
        _noOfPassengers =MIN_NO_OF_PASSENGERS;
    else
        _noOfPassengers = pass;
    _arrivalTime = new Time1(t);
 }
 
 /** Copy constructor for a BusArrival.
  * Copy constructor for a BusArrival. Constructs a BusArrival with the same attributes as another BusArrival.
    * @param other The BusArrival object from which to construct the new BusArrival. 
    */
 //The conctructor copy the attributes from other BusArrival object that it gets.
 public BusArrival (BusArrival other)
 {
     _lineNumber = other.getLineNum();
     _noOfPassengers = other.getNoOfPass();
     _arrivalTime = new Time1(other.getArrivalTime());
 }

 
//Methods
/**
    * Returns the bus line number.
    * @return the bus line number.
    */
//The method returns the bus line number.
public int getLineNum()
{
    return _lineNumber;
}
/**   
    * Returns the number of passengers.
    * @return the number of passengers.
    */
//The method returns passengers number.
public int getNoOfPass()
{
    return _noOfPassengers;
}
/**
    * Returns the bus arrival time.
    * @return the bus arrival time.
    */
//The method returns bus arrival time.
public Time1 getArrivalTime()
{
    return new Time1(_arrivalTime);
}

/**
    * Changes the BusArrival's line number. if the parameter is illegal the line number will remain unchanged
    * @param num The BusArrival's new line number.
    */
//The method gets a new line number and set it to the object. 
public void setLineNum(int num)
{
    if (num >= MIN_LINE_NUMBER && num <= MAX_LINE_NUMBER && num != this.getLineNum())
        _lineNumber = num;
}
/**
    * Changes the BusArrival's number of passengers. if the parameter is illegal the number of passengers will remain unchanged
    * @param pass The BusArrival's new number of passengers.
    */
//The method gets new passengers number and set it to the object. 
public void setNoOfPass(int num)
{
    if (num >= MIN_NO_OF_PASSENGERS && num <= MAX_NO_OF_PASSENGERS && num != this.getLineNum() )
        _noOfPassengers = num;
}
/**
    * Changes the BusArrival's time.
    * @param t The BusArrival's new time.
    */
//The method gets new arrival time and set it to the object. 
public void setArrivalTime(Time1 t)
{
   _arrivalTime.setHour(t.getHour());
   _arrivalTime.setMinute(t.getMinute());
   _arrivalTime.setSecond(t.getSecond());
}

/**
    * Checks if the received BusArrival is equal to this BusArrival.
    * @param other The BusArrival to be compared with this BusArrival
    * @return True if the received BusArrival is equal to this BusArrival
    */
//The method checks if the received BusArrival is equal to the local BusArrival.
public boolean equals (BusArrival other)
{
    return (this.getLineNum() == other.getLineNum() && this.getNoOfPass() == other.getNoOfPass() && _arrivalTime.equals(other.getArrivalTime()) ) ? true : false ;
}
/**
    * Returns a string representation of this BusArrival (for example: "Bus no{@literal .} 27 arrived at 09:24:10 with 13 passengers").
    * @return String representation of this BusArrival (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers").
    */
//The method returns a string representation of this BusArrival (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers").
public String toString()
{
    String s = "Bus no. "+this.getLineNum()+ " arrived at "+this._arrivalTime.toString()+" with "+this.getNoOfPass()+" passengers";
    return s;
}
/**
    * Checks if this bus's number of passengers is larger than other bus's number of passengers.
    * @param other The BusArrival to be compared with this BusArrival
    * @return true if this bus's number of passengers is larger than other bus's number of passengers. false otherwise
    */
//The method checks if this bus's number of passengers is larger than other bus's number of passengers.   
public boolean fuller(BusArrival other)
{
    return (_noOfPassengers > other._noOfPassengers) ? true : false ;
}
/**
    * Checks if this bus's arrival time is before other bus's arrival time.
    * @param other The BusArrival to be compared with this BusArrival
    * @return true if this bus's arrival time is before other bus's arrival time. false otherwise
    */
//The method gets other busArrival and checks if this bus's arrival time is before other bus's arrival time.
public boolean before(BusArrival other)
{
    return (_arrivalTime.before(other.getArrivalTime()) ) ?  true : false ;
}
/**
    * Checks if this bus's number of passengers is equal to the maximum number of passengers allowed.
    * @return true if this bus's number of passengers is equal to the maximum number of passengers allowed. false otherwise
    */
//The method checks if this bus's number of passengers is equal to the maximum number of passengers allowed and eturn true/false.   
public boolean isFull()
{
    return (_noOfPassengers == MAX_NO_OF_PASSENGERS );
}
/**
    * Calculates the difference (in minutes) between this bus arrival time and other.
    * @param other The time to check the difference with.
    * @return int difference in minutes
    */
//The method calculates the difference (in minutes) between this bus arrival time and other.
public int elapsedTime(BusArrival other)
{
    if (equals(other))
        return 0;
    else if (this.before(other))
            return (other._arrivalTime.difference(this._arrivalTime)/ SEC_IN_MINUTE);
        else
            return (_arrivalTime.difference(other.getArrivalTime()) / SEC_IN_MINUTE);
}
  
}//END
