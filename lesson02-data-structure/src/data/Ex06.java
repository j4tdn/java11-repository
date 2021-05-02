package data;

import utils.PrintUtils;

public class Ex06 {
	public static void main(String[] args) {
		Digit a = new Digit(10);
		Digit b = new Digit(20);
		
		
		swap(a,b);
		System.out.println(a);
		System.out.println(b);
		
		//final 
		 int number = 100;
		number = 200;
		
		
		Integer digit = 10;
		digit = 20;
		System.out.println(digit);
		
		final Digit d1 = new Digit(20);
		Digit d2 = new Digit(30);
		d1.value = d2.value;
		System.out.println(d1);
		
		//final cannot update value at stack but can update value at heap.
		
	}

	private static void swap(Digit d1, Digit d2) {
		int tmp = d1.value;
		d1.value = d2.value;
		d2.value= tmp;
		
		
	}
}
