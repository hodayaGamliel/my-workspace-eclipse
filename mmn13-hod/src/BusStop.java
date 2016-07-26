
public class BusStop 
{
	// Final variables
	final private int BUSES_ARR_MAX_SIZE = 1000;
	final private int MAX_OF_LINE_NUMBER = 99;
	final private int NO_BUSS_ARRIVAL = 0;

		
	// Class Attributes 
	private BusArrival [] _buses; 
	private int _noOfBuses;
	
	/**
	 *   Constructs a BusStop object 
	 */
	public BusStop()
	{
		_buses = new BusArrival[BUSES_ARR_MAX_SIZE]; //initialize _buses to BUSES_ARR_MAX_SIZE = 1000
		_noOfBuses = NO_BUSS_ARRIVAL; //initialize _noOfBuses to 0 
	}
	
	/**
	 *  Constructs a BusStop object.
	 * @param size of the array.
	 */
	public BusStop(int size) 
	{
		if (size <= BUSES_ARR_MAX_SIZE) // validate size is less then 1000 or equals to 1000.
		{
			_buses = new BusArrival[size]; //initialize _buses to size
		}
		else // if size is bigger then 1000 , set 1000 
		{
			_buses = new BusArrival[BUSES_ARR_MAX_SIZE]; //initialize _buses to 1000
		}
		_noOfBuses =  0; //initialize _noOfBuses 
	}
	
	/**
	 *  Returns the current number of buses in the array
	 * @return the current number of buses in the array.
	 */
	public int getNoOfBuses() 
	{
		return _noOfBuses; 
	}
	
	/**
	 *  Returns copy of the current buses array.
	 * @return copy of the current buses array.
	 */
	public BusArrival[] getBuses() 
	{
		BusArrival[] copyOfBusesArr = new BusArrival[_buses.length];
		for (int i = 0; i < _buses.length; i++)  //using copy array
		{
			copyOfBusesArr[i] = _buses[i];
		}
		return copyOfBusesArr;// ????
	}		
	
	/**
	 * Add new  BusArrival object to array.
	 * @param line The bus line number (should be between 1-99)
	 * @param pass The number of passengers (should be between 0-70)
	 * @param t The time of bus arrival
	 * @return True if the array isn't full and the new BusArrival object added successfully. 
	 */
	public boolean add(int line, int pass, Time1 t)
	{
		if (_noOfBuses < _buses.length) // checks the the array isn't full
		{
			_buses[_noOfBuses] = new BusArrival(line,pass,t); 
			_noOfBuses++;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Remove from array all the buses with the grtting line 
	 * @param line The bus line number (should be between 1-99)
	 */
	public void removeAllLine(int line) 
	{
		if (line > 0 && line <= MAX_OF_LINE_NUMBER) //validate the line .
		{
			BusArrival[] temp_buses = new BusArrival[_buses.length]; 
			int j = 0;
			
			for (int i = 0; i < _noOfBuses; i++) // copy the non empty cells to new array 
			{
				if (_buses[i].getLineNum() != line && _buses[i] != null)
				{
					temp_buses[j] = new BusArrival ( _buses[i]);
					j++;
				}
			}			
			_noOfBuses=j; // update number of buses
			_buses=temp_buses; // update the original array. 
		}			
	}
	
	/**
	 * Returns the most popular bus line number.
	 * @return the most popular bus line number.
	 */
	public int getPopularLine() 
	{
		if (_noOfBuses != 0)
		{
			int[] popularBusesArr = new int[MAX_OF_LINE_NUMBER+1];
			int mostPopularLine = 0;
			
			for (int i = 0; i < _noOfBuses; i++) 
			{
				popularBusesArr[_buses[i].getLineNum()]++;
				
				if (popularBusesArr[_buses[i].getLineNum()] > popularBusesArr[mostPopularLine]) 
				{
					mostPopularLine = _buses[i].getLineNum();
				}
			}
			return mostPopularLine;	
		}
		else 
		{
			return 0;
		}
	}
	
//	//Solution
//	public int getPopularLine()
//	{
//		// if no lines at all
//		if (_noOfBuses == 0)
//			return -1; // or 0 
//		
//		int[] lineNum = new int[100];
//		
//		for (int i=0; i < _noOfBuses ; i++)
//			lineNum[_buses[i].getLineNum()]++;
//		
//		// scan for the popular line
//		int maxInx = 0;
//		int maxVal = 0;
//		for (int i=0; i < lineNum.length; i++)
//		{
//			if (lineNum[i] > maxVal)
//			{
//				maxVal = lineNum[i];
//				maxInx = i;
//			}
//			
//		}
//				
//		return maxInx;
//	}
	
	
	
	/**
	 * Returns the average time to wait for a bus (base on the the last day).
	 * @return the average time to wait for a bus
	 */
	public long getAverageTime ()
	{
		int earliestBusArrivalTime = 0;
		int latestBusArrivalTime = 0; 
		for (int i=1; i < _noOfBuses; i++)
		{
			if (_buses[i].before(_buses[earliestBusArrivalTime])) //looking for the earliest bus arrival time
				earliestBusArrivalTime = i;
			else
			if (_buses[latestBusArrivalTime].before(_buses[i])) //looking for the latest bus arrival time
				latestBusArrivalTime = i;
		}
		int sumTimeInSec = _buses[latestBusArrivalTime].getArrivalTime().difference(_buses[earliestBusArrivalTime].getArrivalTime()); //calculate sum of time in seconds
		return (long)(sumTimeInSec / (_noOfBuses -1)); //returns the average  of time wait for bus .  
	}
	
	/**
	 *  Return how many Passengers arrived during the day.
	 * @return how many Passengers arrived during the day.
	 */
	public int totalPassengers() 
	{
		int sumOfPass = 0;
		for (int i = 0; i < _noOfBuses; i++) 
		{
			sumOfPass+=_buses[i].getNoOfPass();
		}
		return sumOfPass; 
	}
	
	/**
	 * returns the BusArrival that has the maximum number of passengers during the day.
	 * @return the BusArrival that has the maximum number of passengers during the day.
	 */
	public BusArrival maxPassengers() 
	{
		BusArrival maxPassBuss = _buses[0];
		for (int i = 0; i < _noOfBuses; i++) 
		{
			if (_buses[i].getNoOfPass() > maxPassBuss.getNoOfPass())
			{
				maxPassBuss = _buses[i];
			}
		}
		return maxPassBuss;
	}
	
	
	/**
	 * Returns a string representation of this BusStop (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers").
	 * @return a string representation of this BusStop (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers").
	 */
	public String toString() 
	{
		String str = "";
		for (int i = 0; i < _noOfBuses; i++) 
		{		
			if (_buses[i] != null)
			{
				str+=_buses[i].toString() + "\n";
			}
		}
		return str;
	}	
}