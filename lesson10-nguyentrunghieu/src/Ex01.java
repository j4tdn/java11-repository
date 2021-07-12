import java.util.Arrays;
import java.util.Random;

public class Ex01 {
	public static void main(String[] args) {
		int length = 10;
		int[] numbers = digits(length);

		System.out.println("Mảng ban đầu:");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		System.out.println("\n====================");

		System.out.println("Mảng sau khi loại bỏ các phần tử trùng nhau:");
		int[] distinct = distinct(numbers);
		Arrays.stream(distinct).forEach(number -> System.out.print(number + " "));
		System.out.println("\n====================");

		System.out.println("So sánh giá trị trung bình của 5 phần tử đầu tiên so với 5 phần tử cuối cùng:");
		compare(numbers);
		System.out.println("====================");

		System.out.println("Sắp xếp mảng theo thứ tự tăng dần sử dụng sắp xếp kiểu chèn insertion sort:");
		int[] insertionSort = insertionSort(numbers);
		Arrays.stream(insertionSort).forEach(number -> System.out.print(number + " "));
		System.out.println("\n====================");

		System.out.print("Số lớn thứ 3 trong mảng: ");
		thirdLargestNumber(numbers);
		System.out.println("====================");

		System.out.println("Mảng ban đầu:");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		System.out.println("\n====================");
	}

	private static int[] digits(int length) {
		int[] digits = new int[length];
		Random rd = new Random();
		int count = 1;
		do {
			digits[count] = rd.nextInt(10) + 1;
			count++;
		} while (count < 10);
		return digits;
	}

	private static int[] distinct(int[] numbers) {
		boolean[] arrBool = new boolean[numbers.length];
		Arrays.fill(arrBool, true);
		int[] distinct = new int[numbers.length];
		int count = 0;

		for (int i = 0; i < arrBool.length; i++) {
			if (arrBool[i] == true) {
				contains(numbers, arrBool, i);
			}
			if (arrBool[i] == true) {
				distinct[count++] = numbers[i];
			}
		}
		return Arrays.copyOfRange(distinct, 0, count);
	}

	private static void contains(int[] numbers, boolean[] digits, int index) {
		for (int i = index; i < numbers.length; i++) {
			if (numbers[index] == numbers[i] && index != i) {
				digits[i] = false;
				digits[index] = false;
			}
		}
	}

	private static void compare(int[] numbers) {
		int sumFirst = 0;
		int sumSecond = 0;

		for (int i = 0; i < numbers.length; i++) {
			if (i < 5) {
				sumFirst += numbers[i];
			} else {
				sumSecond += numbers[i];
			}
		}

		if (sumFirst == sumSecond) {
			System.out.println("Giá trị trung bình của 5 phần tử đầu tiên = 5 phần tử cuối cùng");
		} else if (sumFirst > sumSecond) {
			System.out.println("Giá trị trung bình của 5 phần tử đầu tiên > 5 phần tử cuối cùng");
		} else {
			System.out.println("Giá trị trung bình của 5 phần tử đầu tiên < 5 phần tử cuối cùng");
		}
	}

	private static int[] insertionSort(int[] numbers) {
		int[] insertionSort = copyArray(numbers);
		for (int i = 0; i < insertionSort.length; i++) {
			for (int j = 0; j < i; j++) {
				if (insertionSort[i] < insertionSort[j]) {
					swap(insertionSort, i, j);
				}
			}
		}
		return insertionSort;
	}

	private static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}

	private static int[] copyArray(int[] fistArray) {
		int[] secondArray = new int[fistArray.length];
		for (int i = 0; i < secondArray.length; i++) {
			secondArray[i] = fistArray[i];
		}
		return secondArray;
	}

	private static void thirdLargestNumber(int[] numbers) {
		int[] insertionSort = insertionSort(numbers);
		int count = 0;

		for (int i = insertionSort.length - 2; i >= 0; i--) {
			if (insertionSort[i] != insertionSort[i + 1]) {
				count++;
				if (count == 2) {
					System.out.println(insertionSort[i]);
				}
			}
		}
	}
}
