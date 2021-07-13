package utils;

public class ArrayUtils {
	private ArrayUtils() {
	}

	public static void printf(int[] arr) {
		System.out.print("{ ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("} ");
		System.out.println();
	}

	public static void printf(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void printf(String[] str) {
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i] + " ");
		}
		System.out.println();
	}
	
	public static void printf(Object[] object) {
		for (int i = 0; i < object.length; i++) {
			System.out.print(object[i] + " ");
		}
		System.out.println();
		
	}
	
}
