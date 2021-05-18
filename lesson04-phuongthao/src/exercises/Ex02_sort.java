package exercises;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex02_sort {
	public static void main(String[] args) {
		int n;
		Scanner ip = new Scanner(System.in);
		System.out.println("n = ");
		n = ip.nextInt();

		Random rd = new Random();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = rd.nextInt(50);
		}

		sort(arr, n);

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static int[] sort(int[] arr, int n) {
		Arrays.sort(arr);
		int count7 = 0;
		for (int i = 0; i < n; i++) {
			if ((arr[i] % 7) == 0 && (arr[i] % 5)!=0) {
				int tmp = arr[i];
				arr[i] = arr[count7];
				arr[count7] = tmp;

				count7++;
			}
		}
		int count5 = n - 1;
		for (int i = 0; i < count5; i++) {
			if ((arr[i] % 5) == 0 && (arr[i] %7)!=0) {
				int tmp = arr[i];
				arr[i] = arr[count5];
				arr[count5] = tmp;
				count5--;
			}
		}
		return arr;

	}

}
