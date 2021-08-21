package utils;

import java.util.Arrays;

public class ArrayUtils {
	public ArrayUtils() {
	}

	public static void printf(int[] digits) {
		Arrays.stream(digits).forEach(System.out::println);
	}
}
