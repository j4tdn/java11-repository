package utils;

import java.util.Arrays;

public class ArrayUtils {
	public ArrayUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static void printf(int[] digits) {
		Arrays.stream(digits).forEach(System.out::println);
	}
}
