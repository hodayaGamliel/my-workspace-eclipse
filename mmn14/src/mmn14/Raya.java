package mmn14;

//Dimarski Raya
//MMn 14
/**
* MMN 14
*/
public class Raya
{
//Q1
  //The method gets as parameters a sorted array of integers and another integer x
  //The method returns the number of occurrences of the number x
  //The complexity of this method is 2log(n) => log(n)
  /**
   * The method gets as parameters a sorted array of integers and another integer x
   * @param a sorted array
   * @param x integer number that will be searched in the array
   * @return the occurrences of the number x in the array
   */
  public static int count (int [] a, int x)
  {
      int up = a.length-1;  //The top of the array
      int down=0; //The bottom of the array
      int middle;
      int firstLocation=0;
      
      //Find first ocurence of number x in the array using binary search
      while (down <= up)
      {
          middle=(up+down)/2;
          if (x == a[middle])
          {
              firstLocation=middle+1;
              up=middle-1;
          }
          else 
          {
              if (x < a[middle])
                  up=middle-1;
              else
                  down=middle+1;
          }
      }
      //Return 0 if we didnt find any occurence of the number x in the array
      if (firstLocation == 0)
          return 0;
      up = a.length-1;  //The top of the array
      //down=0;
      int lastLocation=0;
      //Find last ocurence of number x in the array using binary search
      while (down <= up)
      {
          middle=(up+down)/2;
          if (x == a[middle])
          {
              lastLocation=middle+1;
              down=middle+1;                
          }
          else
          {
              if(x > a[middle])
                  down=middle+1;
              else
                  up=middle-1;
          }
      }
      //if (lastLocation > 0)
        //  return lastLocation-firstLocation+1;
      return lastLocation-firstLocation+1;
  }
//Q2
//The method gets a string "s" and character "c" and returns how many sub-strings there is in the "s" string that start and end within "c" and content just once the character "c".
//The complexity of this method is O(n)
/**
 * The method gets a string "s" and character "c" 
 * @param s string value to search in
 * @param c character to search in the string
 * @return how many sub-strings there is in the "s" string that start and end within "c" and content just once the character "c".
 */
  public static int subStrC (String s, char c)
  {
      int count=0;
      //count the number of characher c occurences
      for (int i=0;i < s.length() ; i++)
      {
          if(s.charAt(i) == c)
              count++;
      }
      if (count < 3)
          return 0;
      else
          return count-2;
  }
  //The method gets a string s, character c and positive integer k
  //The method returns true if the string has a sub-strings starting and ending with the char c and contain maximum of "k" occurence of the character c
  //The complexity of this method is O(n)
  /**
   * The method gets a string s, character c and positive integer k.
   * @param s string value to search in.
   * @param c character to search in the string.
   * @param k maximum value for the sub-string.
   * @return true if the string has a sub-strings starting and ending with the char c and contain maximum of "k" occurence of the character c.
   */
  public static int subStrMaxC(String s, char c, int k)
  {
      int charCount=0;
      int count=0;
      //count the number of characher c occurences
      for (int i=0; i< s.length() ;i++)
      {
          if(s.charAt(i) == c)
              charCount++;
      }
      //if k is bigger than the count of the characters , set k to charCount-2 (withought the start and end)
      if (k > charCount-2)   //?????
          k=charCount-2;    
      int x = charCount-1;
      //Count all the maximum combinations upto k
      for (int i=0;i<=k;i++)
      {
          count=count+x;
          x--;
      }
      return count;
  }
//Q3
  //The boolean method gets two arrays.
  //The first array (a) contains integers, the second array (pattern) contains the numbers 0, 1 or 2 (only).
  //The method return true if there is a sub-setin the first array that matches the pattern of the second array, and false otherwise.
  /**
   * The method gets two arrays.
   * The first array (a) contains integers, the second array (pattern) contains the numbers 0, 1 or 2 (only).
   * @param a first array contains integers
   * @param b pattern (second) array contains the numbers 0, 1 or 2 (only).
   * @return true if there is a sub-string the first array that matches the pattern of the second array, and false otherwise
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
      return true;
      
      if(a.length < pattern.length)
      return false;
     
      if (i == a.length)
      return false;
      //Case where the number id single digit
      if ((a[i] > 9 && a[i] < 100 || a[i] < -9  && a[i] > -100) && (pattern[j] ==2 ||pattern[j] == 0))
      return match(a,pattern,i+1,j+1,count+1);
      //Case where the number contain double digits
      if (a[i] < 10 && a[i] > -10 && (pattern[j] ==1 || pattern[j] == 0))
      return match (a,pattern,i+1,j+1,count+1);
      //Case where the number is lager then double digits
      if (a[i] > 99 || a[i]< -99)
      return match(a,pattern,i+1,0,0);
      else
      return match(a,pattern,i-j+1,0,0);
  }
//Q4
  //The method gets two arrays that contain integers and returns true if they represent permutation of each other.
  //Permutation mean that both of the arrays contain same values, but they may appear in a different order.
  /**
   * The method gets two arrays that contain integers
   * @param a first array
   * @param b second array
   * @return true if the two arrays represent permutation of each other.
   */
  public static boolean isPermutation (int [] a, int [] b)
  {
      //if length of the arrays is different return false
      if (a.length != b.length)
          return false;
      return isPermutation(a,b,0,0);
  }
  private static boolean isPermutation (int [] a, int [] b, int i,int j)
  {
      int tmp;
      if (i ==a.length)
          return true;
      if (j == b.length)
          return false;
      
      if (a[i] ==b[j])
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
