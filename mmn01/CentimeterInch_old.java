import java.util.Scanner;

import javafx.event.Event;

import com.takipi.sdk.v1.api.Takipi;
import com.takipi.sdk.v1.api.core.events.TakipiEvent;
import com.takipi.sdk.v1.api.core.events.TakipiEventFireOptions;

public class CentimeterInch_old {

	final static double MAX = 100;
	static Takipi takipi;
	static TakipiEvent event;
	
	public static void main(String[] args)
	{       
		  //  final variables  
		  final int DISTANCE_TYPE_CM = 1;
		  final int DISTANCE_TYPE_INCH = 2;
		  final double CM_IN_INCH = 2.54;
	//	  final double INCH_IN_CM = 1/2.54;
		  final double INCH_IN_FOOT = 12;
		  final double CM_IN_M = 100;
		  
		  // Regular variables 
		
		  String operation;
    	  double factor;
    	  double inch;
    	  double cm;
    	  double foot;
    	  double meter;
    	  
    	takipi = Takipi.create("hodaya-test");
      	event = takipi.events().createEvent("Very-Special-Failure");
  		  
        
		  // Getting distance and unit as input
	      Scanner scan = new Scanner (System.in);
	      System.out.println ("This program converts distances. ");
	      System.out.println ("Enter distance and unit (e.g. 37 1 or 100 2):");
	      double distance = scan.nextDouble();
	      int distanceType = scan.nextInt();
	      
	      // Check distance Type 
	      if (distanceType == DISTANCE_TYPE_CM) 
	      {
	    	  operation = "div" ;
	    	  factor = CM_IN_INCH;
	    	  inch = rounding(convert(distance, factor, operation));
	    	  factor = INCH_IN_FOOT;
	    	  foot = rounding(convert(inch, factor, operation));
		      System.out.println(inch);
		      System.out.printf("Distance in Feet:", foot);
	      }
	      else if (distanceType == DISTANCE_TYPE_INCH) 
	      {
	    	  operation = "mul" ;
	    	  factor = CM_IN_INCH;
	    	  cm = rounding(convert(distance, factor, operation));
	    	  factor = CM_IN_M;
	    	  meter = rounding(convert(cm, factor, operation));
		      System.out.printf("Distance in Centimeters:", cm );
		      System.out.printf("Distance in Feet:", meter );
	      }
	      
	  } // end of method main

	
	// get
	public static double convert(double distance, double factor , String operation) 
	{
		double result = 0;
		if (operation == "div") 
		{
			result = distance / factor;
		}
		else if (operation == "mul")
		{
			result = distance * factor;
		}
		return result;			
	}
	
	public static double  rounding(double beforeRounding) 
	{
		double afterRounding = Math.round (beforeRounding * MAX) / (MAX * 1.0);
        event.fire(TakipiEventFireOptions.newBuilder().withForceSnapshot(true).build());        
		return afterRounding;
	}
	
} //end of class CentimeterInch
