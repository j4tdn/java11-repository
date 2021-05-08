package data;

public class Ex06 {
	public static void main(String[] args) {
		Digit a = new Digit(10);
		Digit b = new Digit(20);
		swap (a,b);
		System.out.println("a: " +a);
		System.out.println("b: " +b);
		
		//final
		final int number = 100;
		//number = 200;
		
		final Integer Digit = 10;
		//digit = 20;
		
		Digit d1 = new Digit(20);
		Digit d2 = new Digit(30);
		d1 = d2; //error
		d1.value = 30;
		//final: cannot update value at stack
		// can update value at heap
		
	}
	private static void swap(Digit d1, Digit d2) {
		int tmp = d1.value;
		d1.value = d2.value;
		d2.value = tmp;
	}
}
