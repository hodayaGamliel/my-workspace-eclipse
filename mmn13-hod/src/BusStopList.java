public class BusStopList 
{

	private BusArrivalNode _head;
	
	
	/**
	 * Constructuctor - create empty list
	 */
	public BusStopList()
	{
		_head = null;
	}
	
	/**
	 * The method add new BussArrival object to the list.
	 * @param line The bus line number (should be between 1-99)
	 * @param pass The number of passengers (should be between 0-70)
	 * @param t The time of bus arrival
	 * @return True if the adding success, false otherwise.
	 */
	public boolean add(int line, int pass, Time1 t) 
	{
		BusArrival busArr = new BusArrival(line, pass, t);

		if (_head == null) // Checks if the list is empty 
		{
			_head = new BusArrivalNode(busArr); 
			return true;
		}
		
		BusArrivalNode prev = null;
		BusArrivalNode temp = _head;
		while (temp != null) // Iterate all the nodes in the list
		{ 
			if (temp.getBusArr().equals(busArr)) // If the getting BussArrival is exist in the list return false. 
			{
				return false; 
			}
			prev = temp; 
			temp = temp.getNext();
		}
		 // If the getting BussArrival isn't exist in the list - it's add as last node to the list - and return true.
		BusArrivalNode busArrNode = new BusArrivalNode(busArr);  
		prev.setNext(busArrNode); 
		return true;
	}
	
	/**
	 * The method  remove from list all the buses with the getting line 
	 * @param line The bus line number (should be between 1-99)
	 */
	public void removeAllLine (int line)
	{
		if (line > 0 && line <= 99) // Validate the line .
		{
			BusArrivalNode temp,prev; 			
			temp = _head;
			prev = null;
			while (temp != null) // Iterate all the nodes in the list
			{	
				if(temp.getBusArr().getLineNum() == line) // If the current node's line is equals to the getting line - Remove this node from the list
				{
					if (prev == null) // If it's the 1st node in the list , change the _head value.
					{
						_head = temp.getNext();
					}
					else // If the node isn't at the top of the list - Remove this node by changing the previous node to point the next of this node.
					{
						prev.setNext(temp.getNext());
					}
				}
				else // If the current node's line doesn't equal to the getting line
				{
				prev = temp; // Save the current node
				}	
				temp = temp.getNext(); // Move to the next node
			}
	
		}					
		
	} 
	
	/**
	 * The method returns the most popular bus line number in the list.
	 * @return the most popular bus line number in the list
	 */
	public int getPopularLine()
	{
		if (_head != null) // If list isn't empty
		{
			int mostPopularLine = 0;
			int[] lineNum = new int[100]; // Array for counter the instances for each line.

			BusArrivalNode temp = _head;
		
			while (temp != null) // Iterate all the nodes in the list
			{
				lineNum[temp.getBusArr().getLineNum()]++; // count all the instances for each line 
			
				if (lineNum[temp.getBusArr().getLineNum()] > lineNum[mostPopularLine])   // Looking for the most popular lin in the array
			     {
			    	 mostPopularLine =temp.getBusArr().getLineNum();
			     }
			
				temp = temp.getNext(); // Move to the next node
			}
		
			return mostPopularLine; 

		}
		else // If the list is empty - return 0.
		{
			return 0 ;
		}
				
	}
	
	/**
	 * The method returns the average time to wait for a bus (base on the the last day).
	 * @return the average time to wait for a bus (base on the the last day).
	 */
	public long getAverageTime()
	{
		BusArrival earliestBusArrivalTime = new BusArrival(_head.getBusArr());
		BusArrival latestBusArrivalTime = new BusArrival(_head.getBusArr()); 
	
		BusArrivalNode temp;
		int counter = 0;
		for (temp = _head; temp != null; temp = temp.getNext()) // Iterate all the nodes in the list
		{
			counter ++;
			if (temp.getBusArr().getArrivalTime().before(earliestBusArrivalTime.getArrivalTime())) //Looking for the earliest bus arrival time
			{				
				earliestBusArrivalTime = temp.getBusArr();		
			}
			if (latestBusArrivalTime.getArrivalTime().before(temp.getBusArr().getArrivalTime())) //Looking for the latest bus arrival time
			{
				latestBusArrivalTime = temp.getBusArr();	
			}
		}
		int sumTimeInSec = latestBusArrivalTime.getArrivalTime().difference(earliestBusArrivalTime.getArrivalTime()); //Calculate sum of time in seconds
		return (long)(sumTimeInSec / (counter -1)); //Returns the average  of time wait for bus .  
		
	}
	
	/**
	 * The method returns how many passengers arrived during the day.
	 * @return how many passengers arrived during the day.
	 */
	public int totalPassengers()
	{
		  int allPass = 0;
	        if (_head == null) //If the list is empty - return 0.
	        {
	            return 0;
	        }
	        
	        BusArrivalNode temp;

			for (temp = _head; temp != null; temp = temp.getNext()) // Iterate all the nodes in the list
			{
	            allPass+=temp.getBusArr().getNoOfPass(); // Count the passengers
	        }
	        return allPass;
	}
	
	/**
	 * The method Returns the BusArrival that has the maximum number of passengers during the day.
	 * @return the BusArrival that has the maximum number of passengers during the day.
	 */
	public BusArrival maxPassengers()
	{
		   int maxPassNum = 0; 
		   	BusArrivalNode maxPassLineNode = new BusArrivalNode(_head.getBusArr()); // We suggest the list isn't empty this case!! 
	        BusArrivalNode temp;
	        BusArrivalNode maxPassNumAdd;

	  		for (temp = _head; temp != null; temp = temp.getNext()) // Iterate all the nodes in the list
  			{
	  			if(temp.getBusArr().getNoOfPass() > maxPassNum)  // Looking for the maximum of passenger
	  			{
                maxPassNum = temp.getBusArr().getNoOfPass(); //update the maximum of passenger 
                maxPassLineNode = temp; //update the node with the maximum of passenger 
	            }
	        }
	        BusArrival bus = new BusArrival(maxPassLineNode.getBusArr()); // Copy the bussArrival with the maximum of passenger 
	        return bus;	        	        
	}
	
	/**
	 * The method returns a string representation of all the BussArrival which nodes in the list the start with _head (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers").
	 * @return a string representation of all the BussArrival which member in the list the start with _head (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers").
	 */
	public String toString()
	{
        BusArrivalNode temp;

		  String str="";
	  		for (temp = _head; temp != null;temp = temp.getNext()) // Iterate all the nodes in the list
	        {
	            str+= temp.getBusArr().toString()+"\n"; // Add representation of the current node to string .
	        }
	        return str;
		
	}	
}
