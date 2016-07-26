package mmn14;

public class Q3 
{
	public static void main(String[] args) 
	{
        int [] a = new int [] {23,2,39,3,44};
        int [] pattern = new int [] {1,0,2};
        System.out.println(match(a, pattern));	
	}

	
	  /**
	   * 
	   * @param a
	   * @param pattern
	   * @return
	   */
	  public static boolean match (int [] a, int [] pattern)
	  {
	     //Return false if the pattern array is longer then the first array.
	     if (pattern.length > a.length) 
	          return false;
	     //Return true if the pattern array is empty
	     if (pattern.length == 0)
	          return true;
	     return match (a,pattern,0,0,0);
	  }
	  private static boolean match(int [] a, int [] pattern, int i, int j, int count)
	  {
	      if (count == pattern.length)
	      {
	      return true;
	      }
	      if(a.length < pattern.length)
	      {
	    	  return false;
	      }
	     ;
	      if (i == a.length)
	      {
	    	  return false;
	      }
	      //Case where the number id single digit
	      if (( a[i] < -9  && a[i] > -100) || a[i] > 9 && a[i] < 100 && (pattern[j] ==2 ||pattern[j] == 0))
	      {
	          return match(a,pattern,i+1,j+1,count+1);
	      }
	      //Case where the number contain double digits
	      if ( a[i] > -10 && a[i] < 10 && (pattern[j] ==1 || pattern[j] == 0))
	      {
	          return match (a,pattern,i+1,j+1,count+1);
	      }
	      
	      //Case where the number is lager then double digits
	      if (a[i]< -99 || a[i] > 99 )
	      {
	    	  return match(a,pattern,i+1,0,0);
	      }
	      else
	      {
		      return match(a,pattern,i+1-j,0,0);
	      }
	  }


	
	
}
