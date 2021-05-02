package data;

public class Ex06 {
	public static void main(String[] args) {
		Digit a = new Digit(10);
		Digit b = new Digit(20);
		swap(a, b);
		System.out.println("a : " + a);
		System.out.println("b : " + b);

		// final : hang so
		final int number = 100;
		// number = 200;

		final Integer digit = 10;
		// digit = 20;
		
		Digit d1 = new Digit(20);
		Digit d2 = new Digit(30);
		d1.value = d2.value;
		//  final :  + primitive :can't update value at stack
		// 			 + Object : can update value at heap
	}

	private static void swap(Digit a, Digit b) {
		// TODO Auto-generated method stub
		int temp = a.value;
		a.value = b.value;
		b.value = temp;
	}
}
