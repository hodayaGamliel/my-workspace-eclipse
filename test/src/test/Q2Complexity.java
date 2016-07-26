package test;

public class Q2Complexity 
{
	public static void main(String[] args) 
	{
		int[] array = new int[] {-20,-2,1,2,4,9,13,30};
		
		System.out.println(fixedPoint(array));
		
	}
	
	
	//Q1 a. return the max sum of sub-array for given array
	//	 b. Complexity is n^3
	//	 c. My method for this (complexity):
	public static int whatQ1()
	{
		int[] array = new int[] {-3,5,20,-35,10,-6};
		
		int m = array[0];
		for (int i = 0; i < array.length; i++) 
		{
			for(int j = i; j<array.length; j++)
			{
				int s = array[i];
				for(int k=i+1 ; k<=j;k++)
				{
					s+=array[k];
				}
				
				if (s > m)
				{
					m=s;
				}
					
			}				
		}
		
		return m ;
	}
	
	
	//Q2 
	public static void printPairs(int []a ,int k)
	{
		
	}

	//Q3 
	public static void p()
	{}
	
	//Q4 - return true if there is two num in the arrays that there sum is num 
	//Complexity is O(log n)
	public static boolean sum(int[] arr, int num)
	{
		int start = 0;
		int end = arr.length - 1;
		int sum = 0;
		
		while (start < end)
		{
			sum = arr[start] + arr[end];

			if (sum == num)
			{
				return true;
			}
			else if (sum > num)
			{
				end --;
			}
			else // sum smaller from num 
			{
				start ++;
			}
		}
		return false;
	}
	
	//Q4.2 - using i index 
	
	//5 sorted and shifted array - return index of max 
	//Complexity is O(n)
	public static int findMax(int[] arr)
	{
		int start = 0 ,end = arr.length-1 , mid = 0,max = 0;
		
		if (arr[end] > arr[start])
		{
			max = end;
			return max;
		}
		else
		{
			while(start < end)
			{
				mid = (start+end)/2;
				
				if (arr[start] > arr [mid])
				{
					if (arr[start] > arr[start +1])
					{
						max = start;
						return max;
					}
					else
					{
						start = start+1;
						max = start;
						end = mid;
					}
				}
				else // (arr[start] < arr [mid])
					if (arr[mid] > arr[mid +1])
					{
						max = mid;
						return max;
					}
					else
					{
						start = mid+1;	
						max = start;
					}
			}
			return max;
		}
	}
	
	//Q6 Returns true if there are 2 limits in the given array that match to conditions.
	public static boolean hod(int[] arr)
	{
		int positive = 0;
		int negative = 0;
		int sum = 0;
		
		if (arr[0] > 0 || arr[arr.length-1] < 0) // if all array is negative or positive return false
		{
			return false;
		}
		for (int i = 0; i<= arr.length-1;i++) //looking for the first positive number in array
		{
			if (arr[i] > 0)
			{
				positive = i;
				break;
			}
		}
		
		negative = positive -1; //initialize the biggest negative number in array
		
		sum = arr[positive];
		while((positive < arr.length-1) && (negative > 0)) 
		{		
			if (sum == 0)
			{
				return true;
			}
			else if(sum > 0)
			{
				sum += arr[negative];
			}
			else // sum is negative
			{
				sum += arr[positive];
			}
		}
		return false;
	}
	
	//Q7 fixed point ,complexity - o(log n)
	public static int fixedPoint(int[] a)
	{
		int start = 0 ;
		int end = a.length-1;
		int mid = 0;

		while(start <= end)
		{
			mid = (start+end)/2;
			if (mid == a[mid])
				{
					return mid;
				}
			else if(mid > a[mid])
			{
				start = mid+1;
			}
			else // (mid < a[mid])
			{
				end = mid-1;
			}
		}
		return -1;
	}
	
	//Q8 - like 1;
	
	// Q9 from the mmn - returns the count of num in sorted array ..

	
	//Q10 2015 moed b 94
}
