import org.omg.CosNaming._BindingIteratorImplBase;


public class BusArrivalNode 
{

	private BusArrival _busArr; 
	private BusArrivalNode _next;
	
	/**
	 * Constructs a BusArrivalNode object 1
	 * @param b BusArrival object .
	 */
	public BusArrivalNode (BusArrival b)
	{
		_busArr = new BusArrival(b); //Initialize _busArr with b 
		_next = null; //Initialize _next as null
	}

	/**
	 * Constructs a BusArrivalNode object 2
	 * @param b BusArrival object .
	 * @param n BusArrivalNode object
	 */
	public BusArrivalNode (BusArrival b, BusArrivalNode n)
	{
		_busArr = new BusArrival(b);  //Initialize _busArr with b 
		_next = n; //Initialize _next to n 
	}
	
	/**
	 * Constructs a BusArrivalNode object 3
	 * @param b BusArrivalNode object .
	 */
	public BusArrivalNode (BusArrivalNode b) //Aliasing 
	{
		_busArr = b.getBusArr(); 
		_next = b.getNext();
	}
	
	/**
	 * The method returns copy of of busArrival object
	 * @return copy of of busArrival object
	 */
	public BusArrival getBusArr()
	{
		BusArrival busArr = new BusArrival(_busArr);  // Create copy _BusArr for prevent aliasing
		return busArr;
	}
	
	/**
	 * The method returns pointer to the next node of the list .
	 * @return pointer to the next node of the list .
	 */
	public BusArrivalNode getNext()
	{
		return this._next; 
	}
	
	/**
	 * The method get as parameter BussArrival object and update the BusArrival attribute. 
	 * @param b a BussArrival object
	 */
	public void aetBusArr (BusArrival b)
	{
		this._busArr.setArrivalTime( b.getArrivalTime()); //Copy the BusArrival attribute from b t _busArr 
	}
	
	/**
	 * The method get pointer and update the _next attribute. 
	 * @param next pointer to some node
	 */
	public void setNext(BusArrivalNode next)
	{
		this._next = next;   // update _next attribute
	}	
	
}
