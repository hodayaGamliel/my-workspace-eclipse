package test;

public class Q1Recursion 
{
	public static void main(String[] args) 
	{
//		int[] ar1 = new int[] {1,2,2} ;
//		int[] ar2 = new int[] {2,4,6} ;
//		merge(ar1, ar2);
		String s ="1231245";
		System.out.println(longOrNum(s));
	}	
	
	//Q1 problem if the array are with different size ????
	private static int[] merge(int[] merge_arr,int[] ar1, int[] ar2,int ar1i, int ar2i,int c)
	{
	
		if(ar1[ar1i] < ar2[ar2i])
		{
			merge_arr[c] = ar1[ar1i];
			merge_arr[c+1] = ar2[ar2i];
		}
		else // (ar2 <= ar1)
		{
			merge_arr[c] = ar2[ar2i];
			merge_arr[c+1] = ar1[ar1i];
		}

		return merge_arr;
	}
	
	public static int[] merge(int[] ar1, int[] ar2)
	{
		int lenth = (ar1.length) + (ar2.length);
		int[] merge_arr = new int [lenth];
		int c=0 ;
		int ar1i=-1 ,ar2i=-1;
		while(c <= lenth -2)
		{	
			ar1i++; ar2i++;
			merge(merge_arr,ar1, ar2, ar1i, ar2i, c);
			c+=2;
		}
		
		for (int i = 0; i < merge_arr.length; i++) 
		{
			System.err.print(merge_arr[i]);
		}
		
		return merge_arr;
	}
	
	//Q2
	public static int longOrNum(String s)
	{
		return longOrNum(s, 0, 0, -1);
	}
	private static int longOrNum(String s, int count, int maxCount,int prev)
	{
		if (s.length() == 0)
		{
			if (count > maxCount)
				return count;
			return maxCount;
		}
		System.out.println(s.charAt(0)); //???? why the number aren't big than 0 and small than 9 ???WHF 

		if(s.charAt(0)>=0 && s.charAt(0)<=9) // is a number 
		{
			System.out.println(s.charAt(0));

			if (s.charAt(0) > prev )
			{
				if(count > maxCount)
					maxCount = count;
				return longOrNum(s.substring(1),count+1, maxCount,s.charAt(0));
			}
			else // s.charAt(0) < prev
			{
				return longOrNum(s.substring(1), 0, maxCount, -1);
			}						
		}
		else // is a char
		{
			return longOrNum(s.substring(1), 0, maxCount, -1);

		}
	}
	
	
	//Q3

}
	