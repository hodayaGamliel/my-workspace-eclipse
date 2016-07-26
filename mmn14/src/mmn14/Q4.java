package mmn14;

public class Q4 
{
	public static void main(String[] args)
	{
        int [] a = new int [] {-1,1,0,-1,0,0};
        int [] b = new int [] {1,-1,0,0,-1,0};
        System.out.println(isPermutation(a, b));	
	}


	  public static boolean isPermutation (int [] a, int [] b)
	  {
	      //if length of the arrays is different return false
	      if (a.length != b.length)
	      {
	          return false;
	      }
	      return isPermutation(a,b,0,0);
	  }
	  private static boolean isPermutation (int [] a, int [] b, int i,int j)
	  {
	      if (i == a.length)
	          return true;
	      if (j == b.length)
	          return false;
	      
	      int tmp;
	      if (a[i] == b[j])
	      {
	          //if i=j continue to
	          if (i == j)
	              return isPermutation(a,b,i+1,j+1);
	          else
	          {
	              //replace the values in b array of the current location and array in i location
	              tmp  = b[j];
	              b[j] = b[i];
	              b[i] = tmp;
	              return isPermutation(a,b,i+1,i+1);
	          }
	      }
	      return isPermutation(a,b,i,j+1);
	  }
}
