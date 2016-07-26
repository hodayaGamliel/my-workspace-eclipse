package main;

import ee.A1;
import ee.b.B1;
import ee.b.c.C1;
import ee.b.c.d.D1;

public class Main11
{
	public static void main(String[] args) throws InterruptedException
	{	
		while (true)
		{
			try
			{
				A1 a1 = new A1();
				a1.a();
				
				B1 b1 = new B1();
				b1.b();
				
				C1 c1 = new C1();
				c1.c();
				
				D1 d1 = new D1();
				d1.d();
				
				Thread.sleep(5000);
			}
			catch (Exception ex)
			{
				
			}
		}
	}
}
