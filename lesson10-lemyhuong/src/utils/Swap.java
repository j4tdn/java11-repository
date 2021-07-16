package utils;

import ex04.Student;

public class Swap {
	public Swap() {
	}
	
	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void swap(String[] string, int i, int j) {
		String tmp = string[i];
		string[i] = string[j];
		string[j] = tmp;
	}
	
	public static void swap(Student[] students, int i, int j) {
		Student tmp = students[i];
		students[i] = students[j];
		students[j] = tmp;
	}
}
