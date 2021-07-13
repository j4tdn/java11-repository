package sorting;

import java.util.Arrays;
import java.util.Random;

import static utils.ArrayUtils.*;

import static sorting.Sort.*;

public class App {
	// mode = 1: Ascending
	// mode = -1: Descending

	public static void main(String[] args) {
		Random random = new Random();
		int[] digits = new int[10];
		for (int i = 0; i < digits.length; i++) {
			digits[i] = random.nextInt(100) + 1;
		}

		System.out.print("Mảng số nguyên a = ");
		printf(digits);

		System.out.println("\n=====BUBLE SORT=====");
		System.out.print("Ascending: a = ");
		bubleSort(digits, 1);
		System.out.print("Decending: a = ");
		bubleSort(digits, -1);

		System.out.println("\n=====SELECTION SORT=====");
		System.out.print("Ascending: a = ");
		selectionSort(digits, 1);
		System.out.print("Decending: a = ");
		selectionSort(digits, -1);

		System.out.println("\n=====INSERTION SORT=====");
		System.out.print("Ascending: a = ");
		insertionSort(digits, 1);
		System.out.print("Decending: a = ");
		insertionSort(digits, -1);

		System.out.println("\n=====MERGE SORT=====");
		int[] m_arr = Arrays.copyOfRange(digits, 0, digits.length);
		System.out.print("Ascending: a = ");
		mergeSort(m_arr, 0, m_arr.length - 1, 1);
		printf(m_arr);
		System.out.print("Ascending: a = ");
		mergeSort(m_arr, 0, m_arr.length - 1, -1);
		printf(m_arr);

		System.out.println("\n=====SHELL SORT=====");
		System.out.print("Ascending: a = ");
		shellSort(digits, 1);
		System.out.print("Decending: a = ");
		shellSort(digits, -1);

		System.out.println("\n=====QUICK SORT=====");
		int[] q_arr = Arrays.copyOfRange(digits, 0, digits.length);
		System.out.print("Ascending: a = ");
		quickSort(q_arr, 0, q_arr.length - 1, 1);
		printf(q_arr);
		System.out.print("Decending: a = ");
		quickSort(q_arr, 0, q_arr.length - 1, -1);
		printf(q_arr);

		System.out.println("\n=====OBJECT SORT=====");
		Student[] students = { new Student(1, "Mikasa", 19), new Student(3, "Eren", 20), new Student(2, "Armin", 18) };
		String[] names = new String[students.length];
		for (int i = 0; i < students.length; i++) {
			names[i] = students[i].getName();
		}
		System.out.print("Ascending By Name: ");
		objectSort(names, 1);
		System.out.print("Decending By Name: ");
		objectSort(names, -1);

		Integer[] ages = new Integer[students.length];
		for (int i = 0; i < students.length; i++) {
			ages[i] = students[i].getAge();
		}
		System.out.println();
		System.out.print("Ascending By Age: ");
		objectSort(ages, 1);
		System.out.print("Decending By Age: ");
		objectSort(ages, -1);
	}
}
