package demo;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntPredicate;

public class Ex11 {
	public static void main(String[] args) {
		int[] digits = {1, 2, 1, 4, 5, 8, 10, 4, 12};
		
		boolean d10 = Arrays.stream(digits).anyMatch(item -> item % 10 == 0);
		System.out.println("anyD10: " + d10);
		
		OptionalInt optIntD4 = Arrays.stream(digits).filter(item -> item % 4 == 0).findFirst();
		if (optIntD4.isPresent()) {
			System.out.println("firstD4: " + optIntD4.getAsInt());
		}
		
		//findAny = findFirst
		OptionalInt optIntD5 = Arrays.stream(digits).filter(item -> item % 5 == 0).findAny();
		if (optIntD5.isPresent()) {
			System.out.println("firstD4: " + optIntD4.getAsInt());
		}
		
		boolean allLT100 = Arrays.stream(digits).allMatch(item -> item < 100);
		System.out.println("anyD10: " + allLT100);
		
		boolean noneGT100 = Arrays.stream(digits).noneMatch(item -> item > 0);
		System.out.println("anyD10: " + noneGT100);
	}
}
