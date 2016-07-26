	package com.example;

import java.applet.*;
import java.awt.*;
import java.io.EOFException;
import java.io.IOException;
import java.lang.IllegalAccessError;
import java.net.SocketException;
import java.io.EOFException;

import javax.naming.NameAlreadyBoundException;

public class Trycaught2
{
	public static void main(String[] args) throws EOFException
	{	
		tryexception2();
	}
	public static void tryexception2() 
	{
		try 
		{
			throw new SocketException();	
	    } 
		catch (Exception e) 
		{
		 e.printStackTrace();
		 }
	}
	
//	 public void paint(Graphics g)
//	 {
//		 g.drawString("hodaya - this is mt first applet:) ", 20, 40);
//		 g.drawLine(1 , 1 , 50, 40) ;
//		 g.drawRect(20 , 20 , 60 , 60 );
//		 
//	 }
  }
