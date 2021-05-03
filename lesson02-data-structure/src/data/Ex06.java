package data;

import utils.PrintUtils;

public class Ex06 {
	public static void main(String[] args) {
		Digit a = new Digit(10);
		Digit b = new Digit(20);
		swap(a, b);
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		PrintUtils.hash("hash a: ", a);
		PrintUtils.hash("hash b: ", b);
		
		// final (constant)
		final int number = 100;
		// number = 200; // error because if it's final it will be constant and can not be updated
		
		final Integer digit = 10;
		// digit = 20; // error because if it's final it will be constant and can not be updated
		
		final Digit d1 = new Digit(20);
		final Digit d2 = new Digit(30);
		// d1 = d2; // error!! to resolve must use ".value"
		d1.value = 30;
		// final: can not update value at stack
		// but  : can still update value at heap
		
		
	}

	private static void swap(Digit d1, Digit d2) {
		int tmp = d1.value;
		d1.value = d2.value;
		d2.value = tmp;
		PrintUtils.hash("hash d1", d1);
		PrintUtils.hash("hash d2", d2);
	}
}
