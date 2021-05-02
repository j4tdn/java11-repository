package data;

import utils.PrintUtils;

public class Ex06 {
	public static void main(String[] args) {
		Digit a = new Digit(10);
		Digit b = new Digit(20);

		PrintUtils.hash("hash a: ", a);
		PrintUtils.hash("hash b: ", b);

		swap(a, b);

		System.out.println("a: " + a);
		System.out.println("b: " + b);

		PrintUtils.hash("hash a: ", a);
		PrintUtils.hash("hash b: ", b);

		// final
		final int number = 100;
		// number = 200;

		final Integer digit = 10;
		// digit = 20;

		final Digit d1 = new Digit(20);
		Digit d2 = new Digit(30);
		// d1 = d2;
		d1.value = 30;
		

	}

	private static void swap(Digit d1, Digit d2) {
		int tmp = d1.value;
		d1.value = d2.value;
		d2.value = tmp;
	}

}
