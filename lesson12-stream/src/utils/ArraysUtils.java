package utils;

import java.util.Arrays;

public class ArraysUtils {
	private ArraysUtils() {
		
	}
	
	public static void printf(int[] digits) {
		Arrays.stream(digits).forEach(System.out::println);
	}
}
