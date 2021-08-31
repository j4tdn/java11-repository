package demo;

import java.util.Arrays;
import java.util.OptionalInt;

public class Ex11 {
	public static void main(String[] args) {
		int[] digits = {1, 2, 1, 4, 5, 8, 10, 4, 12};
		
		// 1st is there any element % 10
		boolean d10 = Arrays.stream(digits)
							.anyMatch(item -> item % 10 == 0);
		System.out.println("any d10: " + d10);
		
		// 2nd find first element % 4
		OptionalInt d4 = Arrays.stream(digits)
								.filter(item -> item % 4 == 0)
								.findFirst();
		if(d4.isPresent()) {
			System.out.println("any d4: " + d4.getAsInt());
		}
		
		// 3rd find element that % 5 in list
		OptionalInt optIntD5 = Arrays.stream(digits)
									 .filter(item -> item % 5 == 0)
									 .findAny();
		if (optIntD5.isPresent()) {
			System.out.println("anyD5: " + optIntD5.getAsInt());
		}
		
		// 4th does all elements <	 100
		boolean allLT100 = Arrays.stream(digits)
								 .allMatch(item -> item < 100);
		System.out.println("allLT100: " + allLT100);
		
		// 5th does no element > 0
		boolean noneGT100 = Arrays.stream(digits)
								  .noneMatch(item -> item > 0);
		System.out.println("noneGT0" + noneGT100);
	}
}