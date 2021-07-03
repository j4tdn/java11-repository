package utils;

public class ArrayUtils {
	private ArrayUtils() {
		
	}
	public static void printf(int[] elements) {
		for(int element: elements) {
			System.out.println(element + " ");
		}
		System.out.println();
	}

}
