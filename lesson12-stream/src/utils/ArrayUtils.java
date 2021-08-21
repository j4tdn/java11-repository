package utils;

import java.util.Arrays;

public class ArrayUtils {
	private ArrayUtils() {

	}

	public static void prinf(int[] digits) {
		Arrays.stream(digits).forEach(System.out::println);
	}
}
