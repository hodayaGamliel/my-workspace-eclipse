package com.example ;

import java.applet.*;
import java.awt.*;

import javax.swing.JApplet;

public class MyFirstApplet extends java.applet.Applet
{	
	public void paint(java.awt.Graphics g)
	{
		g.drawString("hello!", 25, 25);
	}
}
