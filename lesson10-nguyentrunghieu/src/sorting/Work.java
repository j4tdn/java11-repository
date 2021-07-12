package sorting;

import java.util.Arrays;
import java.util.Random;

public class Work {
	static int[] input(int index) {
		int[] numbers = new int[index];
		Random rd = new Random();
		for (int i = 0; i < index; i++) {
			numbers[i] = rd.nextInt(20) + 1;
		}
		return numbers;
	}

	static void input(Student[] students) {
		students[0] = new Student("sv01", "Nguyen Trung Hieu", 20);
		students[1] = new Student("sv02", "Hoang Thai Son", 20);
		students[2] = new Student("sv03", "Nguyen Van A", 18);
		students[3] = new Student("sv04", "Nguyen Thi B", 17);
		students[4] = new Student("sv05", "Le Van A", 21);
		students[5] = new Student("sv06", "Nguyen T", 17);
		students[6] = new Student("sv07", "Ho C", 19);
		students[7] = new Student("sv08", "Ngo Ba Kha", 18);
		students[8] = new Student("sv09", "Le Van Luyen", 20);
		students[9] = new Student("sv10", "Phan Thành Tùng", 19);
	}

	static void bubleSort(Student[] students, int[] numbers, int index) {
		Student[] std = coppyArray(students, index);
		int[] digits = coppyArray(numbers, index);

		System.out.println(" <> Sắp xếp tăng dần:");
		for (int i = digits.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (digits[j] > digits[j + 1]) {
					swap(digits, j, j + 1);
				}
			}
		}
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println("\n-----------");
		for (int i = std.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (std[j].getFullName().compareTo(std[j + 1].getFullName()) < 0) {
					swap(digits, j, j + 1);
				}
			}
		}
		Arrays.stream(std).forEach(student -> System.out.println(student));
		System.out.println(" <> Sắp xếp giảm dần:");
		reversed(digits);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println("\n-----------");
		reversed(std);
		Arrays.stream(std).forEach(student -> System.out.println(student));
	}

	static void selectionSort(Student[] students, int[] numbers, int index) {
		Student[] std = coppyArray(students, index);
		int[] digits = coppyArray(numbers, index);
		System.out.println(" <> Sắp xếp tăng dần:");
		for (int i = 0; i < digits.length; i++) {
			for (int j = i + 1; j < digits.length; j++) {
				if (digits[j] < digits[i]) {
					swap(digits, i, j);
				}
			}
		}
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println("\n-----------");
		for (int i = 0; i < std.length; i++) {
			for (int j = i + 1; j < std.length; j++) {
				std[i].getFullName().compareTo(std[j].getFullName());
			}
		}
		Arrays.stream(std).forEach(student -> System.out.println(student));
		System.out.println(" <> Sắp xếp giảm dần:");
		reversed(digits);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println("\n-----------");
		reversed(std);
		Arrays.stream(std).forEach(student -> System.out.println(student));
	}

	static void insertionSort(Student[] students, int[] numbers, int index) {
		Student[] std = coppyArray(students, index);
		int[] digits = coppyArray(numbers, index);
		System.out.println(" <> Sắp xếp tăng dần:");
		for (int i = 0; i < digits.length; i++) {
			for (int j = 0; j < i; j++) {
				if (digits[i] < digits[j]) {
					swap(digits, i, j);
				}
			}
		}
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println("\n-----------");
		for (int i = 0; i < std.length; i++) {
			for (int j = 0; j < i; j++) {
				std[j].getFullName().compareTo(std[i].getFullName());
			}
		}
		Arrays.stream(std).forEach(student -> System.out.println(student));
		System.out.println(" <> Sắp xếp giảm dần:");
		reversed(digits);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println("\n-----------");
		reversed(std);
		Arrays.stream(std).forEach(student -> System.out.println(student));
	}

	static void objectSort(Student[] students, int[] numbers, int index) {
		Student[] std = coppyArray(students, index);

		System.out.println(" <> Sắp xếp tăng dần:");
		for (int i = std.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				std[j].getFullName().compareTo(std[j + 1].getFullName());
			}
		}
		Arrays.stream(std).forEach(student -> System.out.println(student));
		System.out.println();
		System.out.println(" <> Sắp xếp giảm dần:");
		reversed(std);
		Arrays.stream(std).forEach(student -> System.out.println(student));
	}

	static void shellSort(int[] numbers, int index) {
		int[] digits = coppyArray(numbers, index);
//		Khoảng cách g = 2^k + 1 (g = 1, 3, 5, 9, 17, ...)
		int g = 0;
		int k = 0;
		do {
			g = (int) Math.pow(2, k++) + 1;
		} while (g < index / 2);
		System.out.println(" <> Sắp xếp tăng dần:");
		for (int i = k; i >= 0;) {
			for (int j = 0; j < g; j++) {
				for (int m = j + g; m < index; m += g) {
					int tmp = digits[m];
					int n = m;
					while (n > j && digits[n - g] > tmp) {
						digits[n] = digits[n - g];
						n -= g;
					}
					if (n < m) {
						digits[n] = tmp;
					}
				}
			}
			i--;
			if (i == 0) {
				g = 1;
			} else {
				g = (int) Math.pow(2, i) + 1;
			}
		}
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println();
		System.out.println(" <> Sắp xếp giảm dần:");
		reversed(digits);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println();
	}

	static void mergeSort(int[] numbers, int index) {
		int[] digits = coppyArray(numbers, index);
		int start = 0;
		int end = index - 1;

		System.out.println(" <> Sắp xếp tăng dần:");
		merge(digits, start, end);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println();
		System.out.println(" <> Sắp xếp giảm dần:");
		reversed(digits);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println();
	}

	private static void merge(int[] digits, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			merge(digits, start, mid);
			merge(digits, mid + 1, end);
			mSort(digits, start, mid, end);
		}
	}

	private static void mSort(int[] digits, int start, int mid, int end) {
		int count = start;
		int[] beforeArr = new int[mid - start + 1];
		int[] afterArr = new int[end - mid];

		for (int i = 0; i < beforeArr.length; i++) {
			beforeArr[i] = digits[start + i];
		}
		for (int i = 0; i < afterArr.length; i++) {
			afterArr[i] = digits[mid + i + 1];
		}
//		Trộn mảng
		int count1 = 0, count2 = 0;
		while (count1 < beforeArr.length && count2 < afterArr.length) {
			digits[count++] = (afterArr[count2] < beforeArr[count1]) ? afterArr[count2++] : beforeArr[count1++];
		}
		while (count1 < beforeArr.length) {
			digits[count++] = beforeArr[count1++];
		}
		while (count2 < afterArr.length) {
			digits[count++] = afterArr[count2++];
		}
	}

	static void quickSort(int[] numbers, int index) {
		int[] digits = coppyArray(numbers, index);
		int start = 0;
		int end = index - 1;
		System.out.println(" <> Sắp xếp tăng dần:");
		quick(digits, start, end);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println();
		System.out.println(" <> Sắp xếp giảm dần:");
		reversed(digits);
		Arrays.stream(digits).forEach(number -> System.out.print(number + " "));
		System.out.println();
	}

	private static void quick(int[] digits, int start, int end) {
		if (start < end) {
			int mid = qSort(digits, start, end);
			quick(digits, start, mid - 1);
			quick(digits, mid + 1, end);
		}
	}

	private static int qSort(int[] digits, int start, int end) {
		int tmp = start - 1;

		for (int i = start; i < end; i++) {
			if (digits[i] < digits[end]) {
				tmp++;
				swap(digits, tmp, i);
			}
		}
		swap(digits, tmp + 1, end);
		return tmp + 1;
	}

	private static int[] coppyArray(int[] numbers, int index) {
		int[] digits = new int[index];
		for (int i = 0; i < index; i++) {
			digits[i] = numbers[i];
		}
		return digits;
	}

	private static Student[] coppyArray(Student[] students, int index) {
		Student[] std = new Student[index];
		for (int i = 0; i < index; i++) {
			std[i] = students[i];
		}
		return std;
	}

	private static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}

	private static void reversed(int[] numbers) {
		for (int i = 0; i < numbers.length / 2; i++) {
			int tmp = numbers[i];
			numbers[i] = numbers[numbers.length - i - 1];
			numbers[numbers.length - i - 1] = tmp;
		}
	}

	private static void reversed(Student[] students) {
		for (int i = 0; i < students.length / 2; i++) {
			Student tmp = students[i];
			students[i] = students[students.length - i - 1];
			students[students.length - i - 1] = tmp;
		}
	}
}