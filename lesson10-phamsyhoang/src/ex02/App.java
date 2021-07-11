package ex02;

import static utils.ArrayUtils.*;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		int[][] arr1 = { { 1, 2, 3, 4 }, { 5, 6, 8, 7 }, { 1, 9, 0, 9 }, { 2, 9, 6, 5 }, { 1, 2, 4, 5 } };
		System.out.println("INPUT 1: ");
		printf(arr1);

		System.out.println("\nOUTPUT 1: ");
		convertMatrix(arr1);

		System.out.println("====================");

		int[][] arr2 = { { 1, 2, 3, 4 }, { 5, 0, 8, 7 }, { 1, 9, 0, 9 }, { 2, 0, 6, 5 }, { 1, 2, 4, 5 } };
		System.out.println("INPUT 2: ");
		printf(arr2);

		System.out.println("\nOUTPUT 2: ");
		convertMatrix(arr2);
	}

	private static void convertMatrix(int[][] arr) {
		int[] arr_i = new int[arr.length];
		int[] arr_j = new int[arr[0].length];
		int count_i = 0, count_j = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					arr_i[count_i++] = i;
					arr_j[count_j++] = j;
				}
			}
		}
		arr_i = Arrays.copyOfRange(arr_i, 0, count_i);
		arr_j = Arrays.copyOfRange(arr_j, 0, count_j);
//		printf(arr_i);
//		printf(arr_j);
		for (int index : arr_i) {
			for (int j = 0; j < arr[index].length; j++) {
				arr[index][j] = 0;
			}
		}
		for (int index : arr_j) {
			for (int i = 0; i < arr.length; i++) {
				arr[i][index] = 0;
			}
		}
		printf(arr);

	}

}
