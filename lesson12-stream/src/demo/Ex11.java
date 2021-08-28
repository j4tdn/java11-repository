package demo;

import java.util.Arrays;
import java.util.OptionalInt;

public class Ex11 {
	public static void main(String[] args) {

		int[] digits = { 1, 2, 1, 4, 5, 8, 10, 4, 12 };

		// 1
		boolean d10 = Arrays.stream(digits).anyMatch(d -> d % 10 == 0);
		System.out.println("anyD10: " + d10);

		// 2
		OptionalInt optIntD4 = Arrays.stream(digits)
					.filter(i -> i % 4 == 0).findFirst();
		if(optIntD4.isPresent()) {
			System.out.println("firstD4" + optIntD4.getAsInt());
		}
		
		//3 findAny = findFirst
		OptionalInt optIntD5 = Arrays.stream(digits)
				.filter(i -> i % 5 == 0).findAny();
		if(optIntD4.isPresent()) {
			System.out.println("firstD4" + optIntD5.getAsInt());
		}
		
		//4:
		boolean allL100 = Arrays.stream(digits).allMatch(d -> d > 100);
		System.out.println(allL100);
		
		//5:
		boolean noneGt0  = Arrays.stream(digits).noneMatch(d -> d > 0);
		System.out.println("noneGT0: " + noneGt0);
		
	}
}