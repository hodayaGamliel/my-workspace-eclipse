package agent;

public class test2 {
	public static void main(String[] args) 
	{
		
		System.out.println("ssss");
		int[] a = new int[5];
		a[0] = 2;
		a[1] = 2;
		a[2] = 2;
		a[3] = 1;
		a[4] = 0;
	
	    int previous = a[0];
	    int popular = a[0];
	    int count = 0;
	    int maxCount = 0;
	    
		int i;
		for ( i = 0 ; i < a.length  ; i++)
		{
			 if (a[i] == previous)
		            count++;
		        else {
		            if (count > maxCount) {
		                popular = a[i-1];
		                maxCount = count;
		            }
		            previous = a[i];
		            count = 0;
		        }
			
		}
		
		
		int x = count > maxCount ? a[a.length-1] : popular;

		System.out.println(x);
		

//			int i = 0;	
//		while (i < a.length && a[i] != 0)
//		{
//			i++;
//		}
	


	
	
	}
	
	

}

