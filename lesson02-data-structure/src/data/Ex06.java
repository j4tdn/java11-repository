package data;

public class Ex06 {
	public static void main(String[] args) {
		Digit a = new Digit(10);
		Digit b = new Digit(20);
<<<<<<< HEAD
		swap(a, b);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		Integer digit = 10;
		digit = 20;
		
		Digit d1 = new Digit(20);
		Digit d2 = new Digit(30);
		d1 = d2;//error
		d1.value = 30;
		//final: cannot update value at stack
		//		: can update value at heap
		
	}
	
	private static void swap(Digit d1, Digit d2) {
		int tmp = d1.value;
		d1.value = d2.value;
		d2.value = tmp; 
	}
=======
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

>>>>>>> ba78b3a (lesson02-03 02.05.2021)
}
