package view;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số lượng phần tử: ");
		int length = Integer.parseInt(sc.nextLine());
		int[] arr = new int[length];

		for (int i = 0; i < length; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}

		int C7 = 0;
		int C5 = length - 1;
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (i == length - 1 - count) {
				break;
			}
			if (arr[i] % 7 == 0 && arr[i] % 5 != 0) {
				swap(arr, i, C7);
				C7++;
				i--;
				continue;
			}
			if (arr[i] % 5 == 0 && arr[i] % 7 != 0) {
				swap(arr, i, C5);
				C5--;
				i--;
				count++;
				continue;
			}
		}
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void swap(int[] arr, int i, int c) {
		int tmp = arr[i];
		arr[i] = arr[c];
		arr[c] = tmp;
	}

}
