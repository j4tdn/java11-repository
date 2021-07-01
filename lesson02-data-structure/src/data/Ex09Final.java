package data;

public class Ex09Final {
	public static void main(String[] args) {
		// final: cannot update value in stack
		final int a = 10; // a = 11;
		final int b = 20; // b = 21;
		final Integer c = 30; // c = 31; // c update stack
		final Digit d = new Digit(40);
		d.value = 50;
		System.out.println("d: " + d);
		
	}
	
}
