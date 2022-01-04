package utils;

import java.util.Arrays;

public class ArrayUtils {
	private ArrayUtils() {
	}

	public static void printf(int[] arr) {
		Arrays.stream(arr).forEach(System.out::println);
	}
}
