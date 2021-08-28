package demo;

import java.util.Arrays;
import java.util.OptionalInt;

public class Ex11 {
	public static void main(String[] args) {
		// 1, 2, 1, 4, 5, 8, 10, 4, 12
		int[] digits = { 1, 2, 1, 4, 5, 8, 10, 4, 12 };

		// 1st: is there any element that is divisible by 10
		boolean d10 = Arrays.stream(digits).anyMatch(item -> item % 10 == 0);
		System.out.println("anyD10: " + d10);

		// 2nd: find the first element that is divisible by 4
		OptionalInt opIntD4 = Arrays.stream(digits).filter(item -> item % 4 == 0).findFirst();
		if (opIntD4.isPresent()) {
			System.out.println("firstD4: " + opIntD4.getAsInt());
		}

		// 3nd: find the element that is divisible by 5 in the list
		OptionalInt opIntD5 = Arrays.stream(digits).filter(item -> item % 5 == 0).findAny();
		if (opIntD5.isPresent()) {
			System.out.println("anyD5: " + opIntD5.getAsInt());
		}
		// 4th: does all elements less than 100 // allMath
		boolean allLT100 = Arrays.stream(digits).allMatch(item -> item < 100);
		System.out.println("allLt100: " + allLT100);

		// 5th: does no elements greater than 0 // noneMath
		boolean noneGT100 = Arrays.stream(digits).noneMatch(item -> item > 0);
		System.out.println("noneGt100: " + noneGT100);
	}
}
