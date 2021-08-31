package demo;

import java.util.Arrays;
import java.util.OptionalInt;

public class Ex11 {
	public static void main(String[] args) {
		int[] digits = { 1, 2, 10, 15, 1, 4, 5, 8, 10, 4, 12 };

		// is there any element that is dividible by 10
		boolean d10 = Arrays.stream(digits).anyMatch(t -> t % 10 == 0);
		System.out.println(d10);

		// find the first element that is dividible by 4
		OptionalInt optIntD4 = Arrays.stream(digits).filter(item -> item % 4 == 0).findFirst();
		if (optIntD4.isPresent()) {

			System.out.println(optIntD4.getAsInt());
		}
		// find the element that is divisible by 5 in the list
		OptionalInt optIntD5 = Arrays.stream(digits).filter(item -> item % 5 == 0).findAny();

		if (optIntD5.isPresent()) {

			System.out.println(optIntD5.getAsInt());
		}

		// does all elements less than 100
		boolean allLT100 = Arrays.stream(digits).allMatch(item -> item < 100);
		System.out.println(allLT100);

		// does all elements greater than 0
		boolean allGT0 = Arrays.stream(digits).allMatch(item -> item > 0);
		System.out.println(allGT0);

	}

}
