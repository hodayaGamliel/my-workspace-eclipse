package mmn14;

public class Q2 
{		

	public static void main(String[] args)
	{
		String s = "abcabcabcabccc";
		System.out.println(subStrMaxC(s, 'c', 3));
	}
	
	
	 //The complexity of this method is O(n)
	/**
	 * subStrC returns how many substrings that start and finish with c char , and contains one time the char c - exist in s string
	 * @param s String 
	 * @param c - char to find substrings that start ,finish , and contains him in s string. 
	 * @return  how many substrings that start and finish with c char , and contains one time the char c - exist in s string
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
		// if c character  ???
		if(counterOfCChar < 3)
			return 0;
		else
		{
		return counterOfCChar - 2; // returns the number of substrings contains c , start and end with c. 
		}
	}
		
	 //The complexity of this method is O(n)
	/**
	 * subStrMaxC returns how many substrings that start and finish with c char , and contains maximum k times the char c - exist in s string
	 * @param s string
	 * @param c the char to search
	 * @param k times in maximum that the substring contains c
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

		if(k > counterOfCChar - 2)
		{
			k = counterOfCChar - 2;
		}
		int tmp = counterOfCChar-1;
		int counterOfsubStrMaxC = 0;

		for(int i = 0; i <= k; i++)
		{
			counterOfsubStrMaxC += tmp;
			tmp--;
		}
		return counterOfsubStrMaxC;
	}
	
}
