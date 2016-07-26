package agent;

@SuppressWarnings("unused")
public class TestInherit extends Test
{
	private static String staticInheritField = "testingInheritStatic";
	public static String creditNum = "inner_dominoNoShow!!!!";
	public static String cn = "dominoShow";

	private static boolean staticBool = true;
	private static byte staticByte = -7;
	private static char staticChar = ((char)-5);
	private static short staticShort = -33;
	private static int staticInt = -666;
	private static long staticLong = -999;
	private static float staticFloat = -111.5f;
	private static double staticDouble = -222.3;
	
	private static Long staticLongBoxed = null;
	
	public static void simpleException_nonce_12()
	{
		int i = -1;
		
		while(true)
		{
			i++;
			
			//inherit static fields
			staticInheritField = "testingInheritStatic_" + i;
			creditNum = "inherit_dominoNoShow!!!!" + " " + i;
			cn = "dominoShow_" + i;
			
			//super static fields
			staticField = "testingStatic_" + i;
			password = "dominoNoShow!!!!" + " " + i;
			pw = "dominoShow_" + i;
			
			// primitive static fields
			staticBool = true;
			staticByte = -7;
			staticChar = '\uFE85';
			staticShort = -33;
			staticInt = -666;
			staticLong = -999;
			staticFloat = -111.5f;
			staticDouble = -222.3;
			
			// null boxed static field
			staticLongBoxed = null;
			
			simpleException_nonce_12(i);
			
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println("exception: " + e);
				//e.printStackTrace();
			}
		}
	}

}
