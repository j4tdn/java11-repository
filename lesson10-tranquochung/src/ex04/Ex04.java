package ex04;

import java.util.Arrays;
import java.util.Comparator;

public class Ex04 {
	public static void main(String[] args) {
		int[] digits = { 1, 5, 6, 9, 39, 20, 9, 30, 8, 1, 2, 4 };
		// Run Bubble Sort
		// bubbleSort(digits);

		// Run quickSort
		// quickSort(digits, 0, digits.length - 1);

		// Run Insertion Sort
		// insertionSort(digits);

		// Run Selection Sort
		// selectionSort(digits);

		// Run Shell Sort
		// shellSort(digits);

		// Run Merge Sort
		mergeSort(digits, 0, digits.length - 1);

		// Run Object Sort
		Student[] students = { new Student(1, "Nguyen Quoc Hung", 20), new Student(2, "Bui Quoc Khang", 21),
				new Student(3, "Tuan Quoc Tuan", 22), new Student(4, "Nghia Quoc Kien", 45),
				new Student(5, "Le Quoc Phung", 50), new Student(6, "Ai Quoc Phuong", 10),
				new Student(7, "Mac Quoc Tu", 30), };
		objectSort(students);
		
		// print array digits
		print(digits);
		System.out.println("\n ==============");
		// print array students
		print(students);
	}

	// Bubble Sort
	private static void bubbleSort(int[] numbers) {
		int tmp;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 1; j < numbers.length - i; j++) {
				if (numbers[j - 1] > numbers[j]) {
					tmp = numbers[j - 1];
					numbers[j - 1] = numbers[j];
					numbers[j] = tmp;
				}
			}
		}
	}

	// Quick Sort
	private static void quickSort(int[] numbers, int low, int high) {
		if (low < high) {
			int pi = partition(numbers, low, high);
			quickSort(numbers, low, pi - 1);
			quickSort(numbers, pi + 1, high);
		}
	}

	private static int partition(int[] numbers, int low, int high) {
		int pivot = numbers[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (numbers[j] <= pivot) {
				i++;

				int tmp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = tmp;
			}
		}

		int tmp = numbers[i + 1];
		numbers[i + 1] = numbers[high];
		numbers[high] = tmp;

		return i + 1;
	}

	// Insertion Sort
	private static void insertionSort(int[] numbers) {
		int n = numbers.length;
		for (int i = 1; i < n; i++) {
			int key = numbers[i];
			int j = i - 1;

			while (j >= 0 && numbers[j] > key) {
				numbers[j + 1] = numbers[j];
				j = j - 1;
			}
			numbers[j + 1] = key;
		}
	}

	// Selection Sort
	private static void selectionSort(int[] numbers) {
		int n = numbers.length;
		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (numbers[j] < numbers[min_idx])
					min_idx = j;
			}
			// Swap
			int tmp = numbers[min_idx];
			numbers[min_idx] = numbers[i];
			numbers[i] = tmp;
		}

	}

	// Shell Sort
	private static void shellSort(int numbers[]) {
		int n = numbers.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i += 1) {
				int temp = numbers[i];
				int j;
				for (j = i; j >= gap && numbers[j - gap] > temp; j -= gap)
					numbers[j] = numbers[j - gap];
				numbers[j] = temp;
			}
		}
	}

	// Merge Sort
	private static void merge(int numbers[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int L[] = new int[n1];
		int R[] = new int[n2];
		for (int i = 0; i < n1; ++i)
			L[i] = numbers[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = numbers[m + 1 + j];
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				numbers[k] = L[i];
				i++;
			} else {
				numbers[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			numbers[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			numbers[k] = R[j];
			j++;
			k++;
		}
	}

	private static void mergeSort(int numbers[], int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			mergeSort(numbers, l, m);
			mergeSort(numbers, m + 1, r);
			merge(numbers, l, m, r);
		}
	}

	// Object Sort
	public static Comparator<Student> studentNameComparator = new Comparator<Student>() {
		public int compare(Student student1, Student student2) {
			String nameStudent1 = student1.getName().toUpperCase();
			String nameStudent2 = student2.getName().toUpperCase();
			return nameStudent1.compareTo(nameStudent2);
		}
	};

	public static void objectSort(Student[] students) {
		Arrays.sort(students, studentNameComparator);
	}

	// Print array
	private static void print(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}
	
	private static void print(Student[] students) {
		for (Student student : students) {
			System.out.println(student + "; ");
		}
	}
}
