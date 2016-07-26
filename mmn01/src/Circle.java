import java.util.Scanner; 

//  This program calculates the radius ,area and perimeter of the external circle and the internal circle of a given rectangle.      
 
public class Circle
{
	public static void main (String [] args) 
	{
		// Regular variables - for external circle 
		 double exdiameter = 0;
		 double exradius = 0;
		 double exarea = 0;
		 double experimeter = 0; 
		 // Regular variables - for internal circle 
		 double indiameter = 0;
		 double inradius = 0;
		 double inarea = 0;
		 double inperimeter = 0;
		
		// Declaration on new Scanner object for getting input
		Scanner scan = new Scanner (System.in); 
		
		// Explain message for the user 
		System.out.println ("This program calculates the areas " + "and the perimeters of the excircle and the incircle " + "of a given rectangle ");     
		// Asking the left-upper point of the rectangle
		System.out.print ("Please enter the two coordinates of the " + "left-upper point of the rectangle"); 
		int leftUpX = scan.nextInt();
		int leftUpY = scan.nextInt();		
		// Asking the right-down point of the rectangle
	    System.out.print ("Please enter the two coordinates of the " + "right-down point of the rectangle"); 		
		int RightDownX = scan.nextInt(); 
		int RightDownY = scan.nextInt();	

		 // Calculation diameter, radius, area and perimeter for the internal circle
		 indiameter = Math.sqrt((Math.pow((leftUpX - leftUpX), 2)) + (Math.pow((RightDownY - leftUpY), 2))); 
		 inradius = indiameter / 2;
		 inarea = (Math.PI * Math.pow(inradius, 2));
		 inperimeter = 2 * Math.PI * inradius;
		 
		 // Calculation diameter, radius, area and perimeter for the external circle
		 exdiameter = (Math.sqrt((Math.pow((leftUpX - RightDownX), 2) + Math.pow((RightDownY - leftUpY), 2)))); 
		 exradius = exdiameter / 2;
		 exarea = (Math.PI * Math.pow(exradius, 2));
		 experimeter = 2 * Math.PI * exradius;

		 // Printing radius, area and perimeter for the internal and external circle 
		 System.out.println("Incircle: radius = " + inradius + ", area = " + inarea + ", perimeter = "+ inperimeter);
		 System.out.println("Excircle: radius = " + exradius + ", area = " + exarea + ", perimeter = "+ experimeter);
	
	} // end of method main
} // end of class Circle
