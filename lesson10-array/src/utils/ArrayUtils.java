package utils;

public class ArrayUtils {
	private ArrayUtils() {
		
	}
	
	public static void printf(int[] elements) {
		for(int element: elements) {
			System.out.print(element + " ");
		}
		//break line
		System.out.println();
	}
}	
