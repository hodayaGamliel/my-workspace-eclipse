package selenium;


public class test  
{

	public static void main(String[] args) 
	{

			String[] buses = new String[4];
			buses[0] = "a";
			buses[1] = "a";
			buses[2] = "a";
			buses[3] = "a";
			
			int i = 0;
			while (i < buses.length && buses[i] != null)
			{
				System.out.println(i);
				System.out.println(buses[i]);
				i++;
			}
			System.out.println(i); 
		}
}


