package demo;

import java.util.Arrays;
import java.util.OptionalInt;

public class Ex11 {
	public static void main(String[] args) {
		int[] digits = { 1, 2, 1, 4, 5, 8, 10, 4, 12};
		boolean any = Arrays.stream(digits)
			  .anyMatch(digit -> digit % 10 == 0);
		System.out.println(any);
		
		OptionalInt optIntD4 =  Arrays.stream(digits)
		  		.filter(digit -> digit % 4 == 0)
			    .findFirst();
		if (optIntD4.isPresent()) {
			System.out.println("firstD4: " + optIntD4.getAsInt());
		}
		
		// findAny == findFirst
		OptionalInt optIntD5 =  Arrays.stream(digits)
		  		.filter(digit -> digit % 5 == 0)
			    .findAny();
		if (optIntD5.isPresent()) {
			System.out.println("firstD5: " + optIntD5.getAsInt());
		}
		
		//
		boolean allL100 = Arrays.stream(digits)
							.allMatch(item -> item < 100);
		System.out.println("allL100: " + allL100);
		
		
		boolean noneGt0= Arrays.stream(digits)
				.noneMatch(item -> item > 0);
		System.out.println("noneGt0: " + noneGt0);
	}
}
