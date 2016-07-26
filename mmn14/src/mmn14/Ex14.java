package mmn14;

public class Ex14 
{

	//Q1 
	 /**
     * This method gets sort array (a) and integer (x)  , counts and returns how many times the number x exist in a array. 
     * Complexity - 2log(n) --> log(n). 
     * @param a Sort array contain integer numbers
     * @param x Number to count how many times it appears in the given array (a).
     * @return How many times the number x exist in a array.
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
            mid=(top + buttom)  / 2;
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
      
    
    //Q2 - a   
   	/**
   	 * subStrC gets string (s) and char (c) - returns how many substrings that start and end within c,
   	 * and contains c one time there are in the given string (s).  
   	 * complexity - O(n)
   	 * @param s String - for search.
   	 * @param c - char to find substrings that start ,finish , and contains him in s string. 
   	 * @return  how many substrings that start and end with c char , and contains one time the char c are exist in s string
   	 */
   	public static int subStrC(String s, char c)
   	{
   		int counterOfCChar = 0 ;
   		// Counts how many times c appears in s
   		for (int i = 0; i< s.length();i++)
   		{
   			if (s.charAt(i) == c)
   			{
   				counterOfCChar++;
   			}
   		}
   		// if the counter (without the first and last c) is smaller then 3, there is 0 match substring.
   		if(counterOfCChar < 3)
   			return 0;
   		else
   		{
   		return counterOfCChar - 2; // returns the number of substrings contains c , start and end with c. 
   		}
   	}
   	
   	
   	//Q2 - b
   	/**
   	 * subStrMaxC gets string (s) and char (c)
   	 * returns how many substrings that start and finish with c char , and contains maximum k times the char c - exist in s string
   	 * complexity - O(n)
   	 * @param s string to search
   	 * @param c the char to search in string.
   	 * @param k maximum times that the substrings contains c
   	 * @return returns how many substrings that start and finish with c char , and contains maximum k times the char c - exist in s string
   	 */
   	public static int subStrMaxC(String s, char c, int k)
   	{
   		int counterOfCChar = 0 ;
   		
   		// Counts how many times c appears in s
   		for (int i = 0; i< s.length();i++)
   		{
   			if (s.charAt(i) == c)
   			{
   				counterOfCChar++;
   			}
   		}
   		
   		//if k is bigger then the counter without the first and last c , set couter-2 as k.
   		if(k > counterOfCChar - 2)
   		{
   			k = counterOfCChar - 2;
   		}
   		
   		int tmp = counterOfCChar-1; 
   		int counterOfsubStrMaxC = 0;
   		// count all the match substrings until k.
   		for(int i = 0; i <= k; i++)
   		{
   			counterOfsubStrMaxC += tmp;
   			tmp--;
   		}
   		return counterOfsubStrMaxC; 
   	}
   	
   	
   	//Q3    	
	  /**
	   * match gets 2 arrays (a and pattern) ,returns true if a array contains the sequence
	   * of numbers that match to pattern that given as array, false otherwise
	   * @param a array - contain integer numbers.
	   * @param pattern array - contains 0,1 or 2:
	   * 0 - Represent numbers with 1 or 2 digits
	   * 1 - Represent numbers with 1 digits
	   * 2 - Represent numbers with 2 digits
	   * @return returns true if a array contains the sequence of numbers that match to pattern that given as array, false otherwise
	   */
	  public static boolean match (int [] a, int [] pattern)
	  {
	     // if the pattern array length is bigger then a array length - return false.
	     if (pattern.length > a.length) 
	          return false;
	     // if the pattern array is empty - return true
	     if (pattern.length == 0)
	          return true;
	     return match (a,pattern,0,0,0); // call to private method - overloading
	  }
	  
	  // private method - overloading
	  private static boolean match(int [] a, int [] pattern, int i, int j, int count)
	  {
		  // if length of pattern array is like the count it means that we reached match sequence (or its 0 - that always match for any array).
	      if (count == pattern.length) 
	      {
	      return true;
	      }
	      // if a is shorter then pattern - it's can't contain match sequence.
	      if(a.length < pattern.length)
	      {
	    	  return false;
	      }
	      // if i equals to a length - its means we are in the end of a and we haven't match sequence yet - so return false.
	      if (i == a.length)
	      {
	    	  return false;
	      }     
	      //Checks if the number with a 2 digits - for option 2 in pattern.
	      if (( a[i] < -9  && a[i] > -100) || a[i] > 9 && a[i] < 100 && (pattern[j] ==2 ||pattern[j] == 0))
	      {
	          return match(a,pattern,i+1,j+1,count+1);
	      }
	      //Checks if the number with a single digit - for option 1 in pattern
	      if ( a[i] > -10 && a[i] < 10 && (pattern[j] == 1 || pattern[j] == 0))
	      {
	          return match (a,pattern,i+1,j+1,count+1);
	      }
	      //Checks if the number doesn't contains more then 2 digits 
	      if (a[i]< -99 || a[i] > 99 )
	      {
	    	  return match(a,pattern,i+1,0,0); 
	      }
	      else //if is contains more then 2 digits
	      {
		      return match(a,pattern,i+1-j,0,0);
	      }
	  }
	  
	  
	  //Q4 
	  /**
	   * isPermutation gets 2 arrays contains integer numbers, return true if they're permutation one of each other, false otherwise.
	   * @param a First integer array
	   * @param b Second integer array
	   * @return True if they're permutation one of each other, false otherwise.
	   */
	  public static boolean isPermutation (int [] a, int [] b)
	  {
	      //if length of a and b is different - the arrays are can't be permutation
	      if (a.length != b.length)
	      {
	          return false;
	      }
	      return isPermutation(a,b,0,0);  
	  }
	  
	  // private method - overloading
	  private static boolean isPermutation (int [] a, int [] b, int i,int j)
	  {
	      if (i == a.length) 
	          return true;
	      if (j == b.length)
	          return false;
	      
	      int tmp;
	      if (a[i] == b[j])
	      {
	    	  if (i == j)
	              return isPermutation(a,b,i+1,j+1);
	          else
	          {
	              //Using tmp variable for change the places in b array to the current locations .
	              tmp  = b[j];
	              b[j] = b[i];
	              b[i] = tmp;
	              i++; 
	              return isPermutation(a,b,i,i);
	          }
	      }
	      return isPermutation(a,b,i,j+1);  
	  }

	
}

