package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogback {

		static final Logger LOG = LoggerFactory.getLogger(TestLogback.class);
		
		
		public static void main(String[] args) throws InterruptedException
		{
			logback();
		}
		
		public static void logback() throws InterruptedException
		{
			
			String[] messages = new String[1];
			messages[0]="hodhodgodosdkasdas";
			
//			try 
//			{
//				throw new Exception() ;
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
				
			
				LOG.error("dfdsf" + messages[0]);
				LOG.error("dfdsf" + messages[0]);
				LOG.error("dfdsf" + messages[0]);
				LOG.error("dfdsf" + messages[0]);

//				
//				LOG.trace("Hello World!");
//				Thread.sleep(6000);
//
//				LOG.debug("How are you today?");
//				Thread.sleep(6000);
//
//				LOG.info("I am fine.");
//				Thread.sleep(6000);
//
//				LOG.warn("I love programming.");
//				Thread.sleep(6000);
//
//				LOG.error("I am programming.");
//				Thread.sleep(6000);
//
//				LOG.trace("Hello World!");
//				Thread.sleep(6000);
//
//				LOG.debug("How are you today?");
//				Thread.sleep(6000);
//
//				LOG.info("I am fine.");
//				Thread.sleep(6000);
//
//				LOG.warn("I love programming.");
//				Thread.sleep(6000);
//
//				LOG.error("I am programming.");
//				Thread.sleep(6000);
//			}
			
		}

}
