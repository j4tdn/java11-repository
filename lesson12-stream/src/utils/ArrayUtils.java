package utils;

import java.util.Arrays;

public class ArrayUtils {
	private ArrayUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static void printf(int[] arr) {
		Arrays.stream(arr).forEach(System.out::println);
	}
}
