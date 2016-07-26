package com.example;

import java.awt.*;
import java.awt.event.*;

class ListenerForGetInfo implements ActionListener
{
	public void actionPer (ActionEvent e)
	{
		String s = e.getActionCommand();
		if (s.equals("first"))
		{
			System.out.println("You click on the first button");
		}
		if (s.equals("second"))
		{
			System.out.println("You click on the second button");
		}
	}
}
