package exercise;

import java.util.Arrays;

public class Ex04_oddMax {
	public static void main(String[] args) {
		int arr[] = { 5, 1, 9, 11, 20, 19, 17, 21, 30 };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for (int i = arr.length - 1; i > 0; i--) {
			if (oddNumber(arr[i])) {
				System.out.println("The largest odd number in the array is: " + arr[i]);
				break;
			}
		}

	}

	private static boolean oddNumber(int number) {
		return number % 2 != 0;

	}
}