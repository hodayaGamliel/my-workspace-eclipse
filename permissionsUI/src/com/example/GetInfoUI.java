package com.example;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetInfoUI extends Frame implements ActionListener
{
	public void init()
	{
		ActionListener actListenerforb1 = new ListenerForGetInfo();
		Button b ;
		
		setLayout(new FlowLayout());
		setSize(300,300);
		
		add(b = new Button("first"));
		b.setActionCommand("first");
		b.addActionListener((ActionListener) this);

		add(b = new Button("second"));
		b.setActionCommand("second");
		b.addActionListener((ActionListener) this);		
		
		setVisible(true);
	}
	
	public GetInfoUI (String caption)
	{
		super(caption);
		init();		
	}
	
	public static void main(String[] args) 
	{
		GetInfoUI m = new GetInfoUI("Active buttons"); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
