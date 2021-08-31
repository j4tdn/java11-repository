package demo;

import java.util.Arrays;
import java.util.OptionalInt;

import utils.ArrayUtils;
import utils.CollectionUtils;

public class Ex11 {
	public static void main(String[] args) {
		// 1, 2, 1, 4, 5, 8, 10, 4, 12
		int[] digits = {1, 2, 1, 4, 5, 8, 10, 4, 12};
		
		// 1st: is there any element that is divisible by 10
		boolean result = Arrays.stream(digits)
                .anyMatch(digit -> digit % 10 == 0);
		System.out.println(result);
		
		// 2nd: find the first element that is divisible by 4
		OptionalInt opt = Arrays.stream(digits).filter(digit -> digit % 4 == 0).findFirst();
		if (opt.isPresent()) {
			System.out.println("firstD4: " + opt.getAsInt());
		}
		
		// 3nd: find the element that is divisible by 5 in the list
		// findAny == findFirst
		OptionalInt optIntD5 = Arrays.stream(digits).filter(item -> item % 5 == 0).findAny(); 
		if (optIntD5.isPresent()) {
			System.out.println("anyD5: " + optIntD5.getAsInt());
		}
		
		// 4th: does all elements less than 100
		result = Arrays.stream(digits).allMatch(digit -> digit < 100);
		System.out.println(result);
		
		// 5th: does no elements greater than 0
		result = Arrays.stream(digits).anyMatch(digit -> digit <= 0);
		result = Arrays.stream(digits).noneMatch(digit -> digit > 0);
		System.out.println("noneGT0: " + result);
	}
}