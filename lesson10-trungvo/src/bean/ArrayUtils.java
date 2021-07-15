package bean;

import objectsort.Student;

public class ArrayUtils {
	public ArrayUtils() {
	}
	
	public static void printf(int[] elements) {
		for(int element: elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	public static void printf(int elements) {
		System.out.println(elements);
	}
	
	public static void printf(Student[] elements) {
		for(Student element: elements) {
			System.out.println(element + " ");
		}
		//break line
		System.out.println();
	}
}
