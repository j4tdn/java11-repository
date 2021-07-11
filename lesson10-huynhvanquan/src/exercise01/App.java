package exercise01;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		// 1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 2, 4, 4, 4, 4
		// 1, 2, 3, 4, 3, 1
		// 7, 8, 8, 8, 6, 2, 5, 1
		int[] arr = { 1, 2, 3, 4, 3, 1 };
		// Sentence 1
		printResultOfOne(arr);

		// Sentence 2
		System.out.println();
		printResultOfTwo(arr);

		// Sentence 3
		printResultOfThree(arr);

	}

	public static int[] removeDuplicateElement(int[] array) {
		int[] arr = array;
		int[] newArr;
		int count = arr.length;
		int length = arr.length;
		int key = 0;
		String s = "";

		int value = -1;
		// Idea: Danh dau phan tu giong nhau la -1
		// Xoa cac phan tu co gia tri la -1
		for (int i = 0; i < arr.length - 1; i++) {
			key = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j] && arr[i] != -1) {
					key = 1;
					arr[j] = -1;
					--count;
				}
			}
			if (key == 1) {
				arr[i] = -1;
				--count;
			}
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == -1) {
				for (int j = i; j < arr.length - 1; j++) {
					arr[j] = arr[j + 1];
				}
			}
		}
		return Arrays.copyOfRange(arr, 0, count);
	}

	public static int compare(int[] arr) {
		int sumAverageLeft = 0, sumAverageRight = 0;
		for (int i = 0; i < arr.length / 2; i++) {
			sumAverageLeft += arr[i];
		}
		for (int i = arr.length - 1; i >= arr.length / 2; i--) {
			sumAverageRight += arr[i];
		}
		return sumAverageLeft == sumAverageRight ? 0 : (sumAverageLeft > sumAverageRight ? 1 : -1);
	}

	public static int thirdMaxElement(int[] arr) {

		int min = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		int max1 = min, max2 = min - 1, max3 = min - 2;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max1) {
				max1 = arr[i];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max2 && arr[i] != max1) {
				max2 = arr[i];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max3 && arr[i] != max1 && arr[i] != max2) {
				max3 = arr[i];
			}
		}
		return max3;
	}

	public static void printResultOfOne(int[] arr) {
		int[] newArr = removeDuplicateElement(arr);
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + " ");
		}
	}

	public static void printResultOfTwo(int[] arr) {
		if (compare(arr) == 0) {
			System.out.println(
					"Gia tri trung binh cua n/2 phan tu dau tien bang gia tri trung binh cua n/2 phan tu cuoi cung");
		}
		if (compare(arr) == 1) {
			System.out.println(
					"Gia tri trung binh cua n/2 phan tu dau tien lon hon gia tri trung binh cua n/2 phan tu cuoi cung");
		}
		if (compare(arr) == -1) {
			System.out.println(
					"Gia tri trung binh cua n/2 phan tu dau tien be hon gia tri trung binh cua n/2 phan tu cuoi cung");
		}
	}

	public static void printResultOfThree(int[] arr) {
		int key = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == thirdMaxElement(arr)) {
				key = 1;
				break;
			}
		}
		if (key == 0) {
			System.out.println("Khong tim thay gia tri lon thu 3 trong mang.");
		} else {
			System.out.println("Gia tri lon thu 3 trong mang: " + thirdMaxElement(arr));
		}
	}
}
