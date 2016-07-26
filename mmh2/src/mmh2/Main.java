package mmh2;

public class Main {

	
	public static void main(String[] args) {

	A a = new A(1);
	A b = new B(2, 22);
		
	
	B bb = (B)b;
	System.out.println(bb.superX());
	
	}
	
}
