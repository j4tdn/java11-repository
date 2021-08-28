package demo;

import java.util.Arrays;
import java.util.OptionalInt;

public class Ex11 {
	public static void main(String[] args) {
		int[] digits = {1, 2, 1, 4, 5, 8, 10, 4, 12};
		
		// 1st
		boolean ex1 = Arrays.stream(digits)
						    .anyMatch(a -> a % 10 == 0);
		System.out.println("ex1: " + ex1);	   
		// 2st
		OptionalInt optIntD4 = Arrays.stream(digits)
						.filter(item -> item % 4 == 0)
						.findFirst();
		if(optIntD4.isPresent()){
			System.out.println("ex2: " + optIntD4.getAsInt());
		}
		// 3st
		OptionalInt optIntD5 = Arrays.stream(digits)
				.filter(item -> item % 5 == 0)
				.findFirst();
		if(optIntD5.isPresent()){
			System.out.println("ex2: " + optIntD5.getAsInt());
		}
		
		// 4st
		boolean ex4 = Arrays.stream(digits)
							.allMatch(a -> a < 100);
		System.out.println("ex4: " + ex4);
		
		// 5st
		boolean ex5 = Arrays.stream(digits)
							.noneMatch(a -> a > 0);
		System.out.println("ex5: " + ex5);
	}
}
