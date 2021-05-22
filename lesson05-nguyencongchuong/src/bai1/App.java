package bai1;

import java.util.Map;

public class App {
	public static void main(String[] args) {

		int[] array = { 3, 15, 21, 0, 15, 17, 21 };
		sortASC(array);
		for (int i = 0; i < array.length; i++) {
			if (getUniqueNumbers(array, array[i]) == 1)
				System.out.print(" " + array[i]);
		}

	}

	private static int getUniqueNumbers(int arr[], int i) {
		int count = 0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == i)
				count++;
		}
		return (count);
	}

	private static void sortASC(int[] arr) {
		int temp = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}

}