package com.example;

import 	org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogSlf4j 
{
	   private final Logger slf4jLogger = LoggerFactory.getLogger(TestLog4j.class);
	   
	   public static void main(String[] args) 
	   {
		   TestLogSlf4j test = new TestLogSlf4j();
		   test.writeToLogSlf4j("hodaya");
	   }
	   
	   public void writeToLogSlf4j(String name)
	   {
	        slf4jLogger.info("Hi, {}", name);
	        slf4jLogger.info("Welcome to the HelloWorld example of SLF4J");
	   }
	   
}
