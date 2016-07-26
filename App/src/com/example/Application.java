package com.example;

import java.awt.*;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.MyActionListener;

public class Application 
{
	
	MenuBar mb = new MenuBar(); 
	Menu m = new Menu("user");
	Frame f = new Frame("first App");
	Frame s = new Frame("second App");
	
	
	public Application()
	{
		f.setLayout(new FlowLayout());
		f.setSize(600,600);
		
		m.add(new MenuItem("help"));
		m.add(new MenuItem("open"));
		m.add(new MenuItem("close"));
		mb.add(m);
	
		
		Button b1 = new	Button("b1") ;
		Button b2 = new	Button("b2") ;
		b1.setEnabled(false);
		
		ActionListener al = new MyActionListener(); 
		b1.setActionCommand("first-command");
		b1.addActionListener(al);
		
		f.add(b1);
		f.add(b2);
//		s.setLayout(new FlowLayout());
//		Button b3 = new	Button("b1") ;
//		Button b4 = new	Button("b2") ;
//		b1.setEnabled(false);
//		s.add(b3);
//		s.add(b4);
//		s.setVisible(true);

		Label l = new Label("my first label");
		f.add(l);
		
		TextArea ta = new TextArea(3,10);
		TextField tf = new TextField(10);
		f.add(ta);
		f.add(tf);
		
		Checkbox c1 = new Checkbox("c1");
		Checkbox c2 = new Checkbox("c2");
		Checkbox c3 = new Checkbox("c3");
		f.add(c1);
		f.add(c2);
		f.add(c3);
		
		Choice c = new Choice();
		c.add("1111");
		c.add("2222");
		c.add("3333");
		f.add(c);
		f.setVisible(true);
		
		List ls = new List();
		ls.add("aaaa");
		ls.add("bbbb");
		ls.add("cccc");
		f.add(ls);
		
		
	}
	public static void main(String[] args)
	{
	Application app= new Application();
	}
}
