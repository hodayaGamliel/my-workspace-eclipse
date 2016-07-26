package mmn14;

public class Ex14StudentTester {   
    
    public static void main(String[] argv) {
        
        System.out.println("\n====================================\n\nTesting Question 1\n------------------------------------\n");        
            
        int[] array1 =  {-5,-5,1,1,1,1,1,1,1,1,2,2,2,2,2,3,3,3,67,67,99};                 
       
        int returnResult = Ex14.count(array1,1);
              
        System.out.println("The result for array "+getArray(array1)+" and argument 1 should be: 8"  +"\tStudent result is: "+ returnResult);
        System.out.println(" note: you should add lots more tests to try out different cases.");
        System.out.println(" note: even if the method gives the right result, make sure the time and space comlexities are minimal");
        System.out.println(" the majority of points will be given according to the complexities");
        
        
        System.out.println("\n====================================\n\nTesting Question 2\n------------------------------------\n");
        
        String s;
        char c;
        int k;
        s = "abcbcabcacabcc";
        c = 'c';
        System.out.println("subStrC method return: " + Ex14.subStrC(s,c)); // should return 4
        
        s = "abcbc";
        k = 0;
        System.out.println("subStrMaxC method return: " + Ex14.subStrMaxC(s,c,k)); // should return 1

        s = "abcbcabcacab";        
        k = 2;
        System.out.println("subStrMaxC method return: " + Ex14.subStrMaxC(s,c,k)); // should return 6
        
        k = 3;
        System.out.println("subStrMaxC method return: " + Ex14.subStrMaxC(s,c,k)); // should return 6

        s = "abc";
        k = 2;
        System.out.println("subStrMaxC method return: " + Ex14.subStrMaxC(s,c,k)); // should return 0
        
        
        System.out.println("\n====================================\n\nTesting Question 3\n------------------------------------\n");
        
        int[] pattern = {1,0,2};
		int[] numbers  = {5,39,67};
		System.out.print("Testing array: {5,39,67}, with pattern: {1,0,2} (should be true): ");
		System.out.println(Ex14.match(numbers, pattern));
		        
        
        System.out.println("\n====================================\n\nTesting Question 4\n------------------------------------\n");
        
        int [] aa1 = {1, 2, 3, 4};
        int [] bb1 = {4, 3, 2, 1};
        int [][] aaArr = {aa1};
        int [][] bbArr = {bb1};
        boolean [] expec4Res = {true};
        boolean actIsPerm;
        String resStr;
        for (int i = 0; i < expec4Res.length; i++) {
            try {
                actIsPerm = Ex14.isPermutation(aaArr[i], bbArr[i]);
                resStr = (actIsPerm == expec4Res[i])? "\t OK" : "\t Error";
                resStr += ": exepted=" + expec4Res[i] + " : actual=" + actIsPerm;
                System.out.println(resStr);
            } catch (Exception e) {
                System.out.println("\t Exception - " + e.toString() + "\n");
            }
        }
    }
    
	public static String getArray(int []a){
	    String retA="";
        for (int i=0;i<a.length;i++)
            retA+=(" " + a[i]);
        return retA;  
    }
}