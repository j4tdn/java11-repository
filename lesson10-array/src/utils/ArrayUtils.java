package utils;

public class ArrayUtils {
	private ArrayUtils() {
	}
	
	public static void printf(int[] elements) {
		System.out.println();
		for (int element : elements) {
			System.out.print(element + " ");
		}
	}
	
}
