

//Raya Dimarski
//MMN_13
//The program represents a BusStop. BusStop is represented by its array of BusArrivals(line number, arrival time, number Of passengers) and number of passengers.
/**
 * Represents a BusArrival. BusArrival is represented by its line number, arrival time, number Of passengers.
 */
public class BusStop2
{
    //Variables
    private final int  MAX_BUSES = 1000;
    private final int  EMPTY_BUS = 0;
    private final int MAX_NUM_OF_LINES=100;
    //Private attributes
    private BusArrival [] _buses;
    private int _noOfBuses;
   
    //Constructors
    /** Constructs a BusStop object.
    * Constructs a BusStop object.
    */
    //The default constructor. constructs the BusStop object. Set the length og the buses array to maximum(MAX_BUSES = 1000) and zero the number of buses.
    public BusStop2()
    {
        _buses = new BusArrival[MAX_BUSES];
        _noOfBuses=EMPTY_BUS;
    }
    /** Constructs BusStop object.
    * Constructs BusStop object. with line number, number of passengers, and time of arrival if the parameters are illegal they will be set to 0.
    * @param size Set the BusStop- BusArrival array (should be between 1-1000)
    */
    //The constructor gets the size of the BusArrival array. if the value illegal it will be set to 0. 
    public BusStop2(int size)
    {
        if (size > MAX_BUSES || size <= 0)
            size = MAX_BUSES;
        _buses = new BusArrival[size];
        _noOfBuses=EMPTY_BUS;
    }
    
    //Methods
    /**
    * Returns the number of buses.
    * @return the number of buses.
    */
    public int getNoOfBuses()
    {
        return _noOfBuses;
    }
     /**
    * Returns a copy of the BusArrival array.
    * @return a copy of the BusArrival array.
    */
    public BusArrival[] getBuses()
    {
        BusArrival [] temp = new BusArrival[_buses.length];
        for (int i=0; i < _buses.length;i++)
        {
            if(_buses[i] != null)
                temp[i] = new BusArrival(_buses[i]);
        }
        return temp;
    }
    /**
    * Add a new BusArrival object to BusArrival array.
    * @param line bus line number
    * @param pass number of passengers
    * @param t Time1 object
    * @return if sucsesfully added new BusArrival to the BusArrival array. 
    */
    public boolean add(int line, int pass, Time1 t )
    {
        //checks whether the buses if full
        if(_noOfBuses == _buses.length )
            return false;
        else
        {
            _buses[_noOfBuses]=new BusArrival(line, pass, t);
            _noOfBuses++;
            return true;
        }
    }
    /**
    * Remove all objects of specific bus line number.
    * @param line bus line number.
    */
    public void removeAllLine (int line)
    {
        int tmp =0;
        BusArrival [] _busesCopy = new BusArrival [_buses.length];
       
         // zeroing the cells of the lines 
        for(int i =0;i < _buses.length;i++)
        {
          if ( _buses[i] != null && _buses[i].getLineNum() == line)
          {
               _buses[i]= null;
               _noOfBuses--;
          }
        }
        //copy the array
        for (int i =0;i < _buses.length;i++)
        {
          if (_buses[i] != null)
          {
              _busesCopy[tmp] = _buses[i];
              tmp++;
          }
        }
        //copy back the array
        for (int i =0;i < _buses.length;i++)
        {
            _buses[i] =  _busesCopy[i];    
        }
    }
     /**
    * Return the most popular bus.
    * @return Return the most popular bus.
    */
   //The mothod return the most popular bus.
    public int getPopularLine()
    {
        int popularLine=0;
        int [] allBuses = new int[MAX_NUM_OF_LINES];

        if (_noOfBuses == 0)
              return 0;
        else 
        {
             for (int i=0 ; i < _noOfBuses; i++)
             {
                 allBuses[_buses[i].getLineNum()] ++;
                 if (allBuses[_buses[i].getLineNum()] > allBuses[popularLine])
                        popularLine = _buses[i].getLineNum();
                                   
             }      
             return popularLine;    
        }
    }
    /**
    * Return average time to waight for a bus.
    * @return Raverage time to waight for a bus.
    */
    public long getAverageTime()
    {
        int earliestBus = 0; 
        int latestBus = 0; 
        long avgTime=0;
        //find the earliest and the latest buss in order to find the average time.
        for(int i = 1 ; i < _noOfBuses ; i++) 
        {
             if( _buses[i].before(_buses[earliestBus]) ) 
                earliestBus = i;    
             if( _buses[latestBus].before(_buses[i]) ) 
                latestBus = i; 
        }
        //Calculate the avarage time by using the .difference method of Time1.
        avgTime=(long)(_buses[latestBus].getArrivalTime().difference(_buses[earliestBus].getArrivalTime()))/ (_noOfBuses-1);
        return avgTime;  
     }  
    
    
    /**
    * Return number of all passengers arrived during the day.
    * @return number of all passengers arrived during the day.
    */
   //The method return number of all passengers arrived during the day.
    public int totalPassengers()
    {
        int allPass=0;
        if (_noOfBuses == 0) //if there is no buses return 0.
            return 0;
        for (int i=0; i<_noOfBuses;i++)
        {
            allPass+=_buses[i].getNoOfPass();
        }
        return allPass;
    }
    /**
    * Return BusArrival that has maximum number of passengers.
    * @return BusArrival that has maximum number of passengers.
    */
   //The method return BusArrival that has maximum number of passengers.
    public BusArrival maxPassengers()
    {
        int maxPassNum=0; //maxminum number of passengers
        int maxPassLineLocation=0; //line number of the bus with maximum number of passengers. 
        for (int i=0;i<_noOfBuses;i++)
        {
            if(_buses[i].getNoOfPass()> maxPassNum)
            {
                maxPassNum=_buses[i].getNoOfPass();
                maxPassLineLocation=i;
            }
        }
        BusArrival bus=new BusArrival(_buses[maxPassLineLocation]);
        return bus;
    }
    /**
    * Returns a string representation of this BusStop attributes (for example: "Bus no{@literal .} 27 arrived at 09:24:10 with 13 passengers").
    * @return String representation of  BusStop (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers").
    */
    //The method returns a string representation of this BusStop (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers").
    public String toString()
    {
        String str="";
        for (int i=0; i< _buses.length; i++)
        {
            if (_buses[i]!= null) //Dont print if the value is null
                str+= _buses[i].toString()+"\n";
        }
        return str;
    }
}

