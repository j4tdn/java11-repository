package exercise;

import java.util.Arrays;
import java.util.Random;


public class Ex07_randomArr {
	public static void main(String[] args) {
		Random rd = new Random();
		int arr[] = new int[5];
		
		for(int i=0; i<arr.length;i++) {
			arr[i] = getNumber(arr);
		}
		
		System.out.println(Arrays.toString(arr));

	}

	private static int getNumber(int arr[]) {
		Random rd = new Random();
		int number;
		do {
			number = 20 + rd.nextInt(11);
		} while (isExist(arr, number));
		return number;

	}

	private static boolean isExist(int arr[], int number) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == number)
				return true;
		}
		return false;
	}

}
