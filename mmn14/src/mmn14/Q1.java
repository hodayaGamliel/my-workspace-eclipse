package mmn14;

public class Q1
{
    public static void main (String[]args)
    {
        int [] a = new int [] {-5,-3,1,1,1,2,2,2,3,3,44,67,67,99};
        
        System.out.println(count(a,-5));
    }
    /**
     * This method counts and return how many times the number x exist in a array 
     * @param a sort array contain numbers
     * @param x number to count how many times it appears in the given array(a).
     * @return how many times the number x exist in a array
     */
    public static int count (int [] a, int x)
    {
        int top = a.length-1;
        int buttom = 0;
        int mid;
        int firstNumLocation = 0;
        
        //Looking for the first location of x in the array - using binary search.
        while (top >= buttom)
        {
            mid=(top + buttom)  /2;
            if (x == a[mid])
            {
                firstNumLocation = mid + 1;
                top= mid - 1;
            }
            else if (x > a[mid])
            {
            	buttom = mid + 1;
            }
            else
            {
            	top = mid - 1;
            }
        }
      
        top = a.length-1;
        int lastNumLocation = 0;
        
        //Looking for the last location of x in the array - using binary search.
        while (top >= buttom)
        {
            mid=(top+buttom)/2;
            if (x == a[mid])
            {
                lastNumLocation=mid+1;
                buttom=mid+1;                
            }
            else if(x < a[mid])
            {
                top=mid-1;
            }
            else
            {
            	buttom = mid+1;
            }
        }
        
        // Checks if x is exist in array 
        if (lastNumLocation > 0)
        {
            return lastNumLocation-firstNumLocation+1; // return the number of times that x appears in the array
        }
        else
        {
            return 0; // if x isn't exist in array - return 0.
        }
    }

}
