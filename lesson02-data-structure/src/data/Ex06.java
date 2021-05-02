package data;

public class Ex06 {
	public static void main(String[] args) {
		Digit a = new Digit(10);
		Digit b = new Digit(20);
		swap(a,b);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		// final
		final int number = 100;
		// number = 200;
		
		Integer digit = 1000;
		// digit = 4443;
		final Digit c = new Digit (5);
		Digit d = new Digit(10);
		// c = d erro
		c.value = 30;
		
	}
	private static void swap (Digit f, Digit s) {
		int tmp = f.value;
		f.value = s.value;
		s.value = tmp;
	}

}
