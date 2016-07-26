package com.example; 

import java.util.logging.Logger;
import java.util.logging.Level;


public class Chinese {
	
	public static void main(String[] args) {
		rockyTestChinese_hod();

	}
	
	private static void rockyTestChinese_hod()
    {
        while(true)
        {
            try
            {
                Thread.sleep(5000);
            	Logger log = Logger.getLogger("logs"); 
                log.log(Level.SEVERE, "这基本上是随机的胡说");       
               
            }
            catch(Exception e)
            {
                //shouldn't reach this point
             
            }
        }
    }

}
