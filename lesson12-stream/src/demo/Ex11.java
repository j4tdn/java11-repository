package demo;

import java.util.Arrays;
import java.util.OptionalInt;

public class Ex11 {
	public static void main(String[] args) {
		int[] digits = {1, 2, 1, 4, 5, 8, 10, 4, 12};
		
		// 1st
		boolean d10 = Arrays.stream(digits).anyMatch(n -> n % 10 == 0);
		System.out.println("any d10: " + d10);
		
		// 2nd
		OptionalInt d4 = Arrays.stream(digits).filter(n -> n % 4 == 0).findFirst();
		System.out.println("any d4: " + d4);
		
		// 3rd
		OptionalInt optIntD5 = Arrays.stream(digits).filter(n -> n % 5 == 0).findAny();
		if (optIntD5.isPresent()) {
			System.out.println("anyD5: " + optIntD5.getAsInt());
		}
		
		// 4th
		boolean allLT100 = Arrays.stream(digits).allMatch(n -> n < 100);
		System.out.println("allLT100: " + allLT100);
		
		// 5th 
		boolean noneGT100 = Arrays.stream(digits).noneMatch(n -> n > 0);
		System.out.println("noneGT0" + noneGT100);
	}
}
