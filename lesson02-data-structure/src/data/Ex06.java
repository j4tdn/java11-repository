package data;

public class Ex06 {
	public static void main(String[] args) {
		Digit a = new Digit(10);
		Digit b = new Digit(20);

		swap(a, b);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		// final
		final int number = 100;
		//number = 300;

		final Integer ditgit = 20;
		// digit =30;

		// final: cannot update value at stack
		// 			can update value at heap
	}

	private static void swap(Digit d1, Digit d2) {
		int tmp = d1.value;
		d1.value = d2.value;
		d2.value = tmp;
	}
}
