package utils;

import ex04.Student;

public class ArrayUtils {
	private ArrayUtils() {
	}
	
	public static void printf (int[] elements) {
		for (int element: elements) {
			System.out.print(element + " ");
		}
		
		System.out.println();
	}
	
	public static void printf (String[] elements) {
		for (String element: elements) {
			System.out.print(element + " ");
		}
		
		System.out.println();
	}
	
	public static void printf (Student[] elements) {
		for (Student element: elements) {
			System.out.print(element + " ");
		}
		
		System.out.println();
	}
}
