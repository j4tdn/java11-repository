package utils;

public class ArrayUtils {
	public ArrayUtils() {
		
	}
	
	public static void printf(int[] digits) {
		for(int digit: digits) {
			System.out.print(digit + " ");
		}
		System.out.println();
	}
	
	public static void printf(Object[] objects) {
		for(Object object: objects) {
			System.out.println(object + " ");
		}
	}
}
