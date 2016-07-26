package main;

import a.A1;
import a.b.B1;
import a.b.c.C1;
import a.b.c.d.D1;
import a.b.c.d.D5;

public class MainHod 
{
	public static void main(String[] args) {
	//	while (true)
	//	{
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
				ex.printStackTrace();
			}
	//	}
	}
}
