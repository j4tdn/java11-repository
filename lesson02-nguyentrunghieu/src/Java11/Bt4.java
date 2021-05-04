package Java11;

import java.util.Scanner;

public class Bt4 {
	public static void main(String[] args) {
		int[] numbers = input();
		output(numbers);
		System.out.println("\nSo le lon nhat = " + maxOdd(numbers));
	}

	private static int maxOdd(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0 && arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static int[] input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap n: ");
		int n = Integer.parseInt(sc.nextLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("A[" + i + "]=");
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		return arr;
	}

	public static void output(int[] arr) {
		System.out.print("A[" + arr.length + "] = ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
