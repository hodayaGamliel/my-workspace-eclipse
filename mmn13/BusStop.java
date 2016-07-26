import java.lang.annotation.Retention;

import javax.swing.Popup;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.xml.transform.Templates;

public class BusStop 
{
	// Final variables
	final private int BUSES_ARR_MAX_SIZE = 1000;
	final private int MAX_OF_LINE_NUMBER = 99;
	final private int SECONDS_IN_MINTUE = 60;
		
	// Class Attributes 
	BusArrival [] _buses; 
	int _noOfBuses;
	
	public BusStop()
	{
		_buses = new BusArrival[BUSES_ARR_SIZE];
		_noOfBuses = 0;
	}
	
	public BusStop(int size) 
	{
		_buses = new BusArrival[size];
		_noOfBuses =  0; 
	}
	
	public int getNoOfBuses() 
	{
		return _noOfBuses;
	}
	
	public int getBuses() 
	{
		BusArrival[] temp_buses = new BusArrival[buses.length];
		for (int i = 0; i < buses.length; i++) 
		{
			temp_buses[i] = buses[i];
		}
		
		return temp_buses;
	}		
	
	public boolean add(int line, int pass, Time1 t)
	{
		if (_noOfBuses < _buses.length)
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
			 
	public void removeAllLine(int line)  ////??????? יותר יעיל http://pastebin.com/j1FsQucC  ?????????????
	{
		BusArrival[] temp_buses = new BusArrival[_buses.length];

		for (int i = 0; i < _buses.length; i++) 
		{
			if (_buses[i].getLineNum() != line)
			{
				temp_buses[i] = _buses[i];
			}
			else 
			{
				_noOfBuses--;
			}
		}
		removeHolesFromArr(_buses);
	}
		
	public int getPopularLine() 
	{
		if (_noOfBuses != 0)
		{
			int[] popularBusesArr = new int[MAX_OF_LINE_NUMBER+1]
			int mostPopularLine = 0;
			
			for (int i = 0; i < _noOfBuses; i++) 
			{
				popularBusesArr[_buses[i].getLineNum()]++;
				
				if (popularBusesArr[_buses[i].getLineNum()] > popularBusesArr[mostPopularLine]]) 
				{
					mostPopularLine = _buses[i].getLineNum()
				}
			}
			return mostPopularLine
			
		}
		else 
		{
			return 0;
		}
	}
	
	public long getAverageTime ()
	{
		int earliestBusArrivalTime = 0;
		int latestBusArrivalTime = 0; 
		for (int i=1; i < _noOfBuses; i++)
		{
			if (_buses[i].before(_buses[earliestBusArrivalTime]))
				earliestBusArrivalTime = i;
			else
			if (_buses[last].before(_buses[i]))
				latestBusArrivalTime = i;
			}
		
		int sumTimeInSec = (_buses[latestBusArrivalTime].elapsedTime(_buses[earliestBusArrivalTime]) * SECONDS_IN_MINTUE;
		retern (long)(sumTimeInSec / _noOfBuses -1);		
	}
	 
	public int totalPassengers() 
	{
		int sumOfPass = 0;
		for (int i = 0; i < _buses.length; i++) 
		{
			sumOfPass+=_buses[i].getNoOfPass();
		}
		return sumOfPass; 
	}
	
	public BusArrival maxPassengers() 
	{
		int maxPass = 0;
		for (int i = 0; i < _noOfBuses; i++) 
		{
			if (_buses[i].getNoOfPass() > maxPass)
			{
				maxPass = _buses[i].getNoOfPass();
			}
		}
	}
		
	public String toString() 
	{
		for (int i = 0; i < _noOfBuses; i++) 
		{
			System.out.println("Bus no. " + _buses[i].getLineNum() + " arrived at " + _buses[i].getArrivalTime().toString() + " with " + _buses[i].getNoOfPass() + " passengers");
		}
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//______________________________________
	
	
	public int removeHolesFromArr(BusArrival[] buses)
	{
		BusArrival[] temp_buses = new BusArrival[buses.length];
		int j = 0;
		for (int i = 0 ; i < buses.length && a[i] != 0 ; i++)
		{
			if (buses[i] != null)
			{
				temp_buses[j] = buses[i]
				j++:
			}
		}
	}
			
//	public int nextEmptyIndex(BusArrival[] buses)
//	{
//		BusArrival[] temp_buses = new BusArrival[buses.length];
//		
//		int i = 0;
//		for (i = 0 ; i < buses.length && a[i] != 0 ; i++)
//		{}
//		return i
//	}
//			
//	public BusArrival[] copyArr(BusArrival[] buses)
//	{
//		BusArrival[] temp_buses = new BusArrival[buses.length];
//		for (int i = 0; i < buses.length; i++) 
//		{
//			temp_buses[i] = buses[i];
//		}
//		
//		return temp_buses;
//	}

}
