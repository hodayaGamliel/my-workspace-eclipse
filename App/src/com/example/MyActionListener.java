package com.example;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;

public class MyActionListener implements ActionListener
{
	public void actionPerformed (ActionEvent e)
	{
		String s = e.getActionCommand();
		if (s.equals("first"))
			System.out.println ("the first button was switced");
		if (s.equals("second"))
			System.out.println ("the second button was switced");
	}
}
