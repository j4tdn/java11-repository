package Ex04;

import java.util.Random;

import utils.ArrayUtils;

public class Sorting {
	public static void main(String[] args) {
		Random rd = new Random();
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1 + rd.nextInt(99);
		}

		bubleSort(arr);
		// selectionSort(arr);
		// insertionSort(arr);
		// shellSort(arr);
		// mergeSort(arr, 0, arr.length-1);
		// quickSort(arr, 0, arr.length - 1);
		ArrayUtils.printf((arr));


		Student[] students = new Student[] { 
				new Student("1", "A", 7), 
				new Student("2", "B", 8),
				new Student("3", "D", 9), 
				new Student("4", "C", 1) };

		objectSort(students);
		ArrayUtils.printf((students));

	}

	private static void bubleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			for (int j = 0; j < arr.length - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

	private static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	private static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	private static void objectSort(Student[] students) {
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length - i - 1; j++) {
//				if(students[i].getName().compareTo(students[j+1].getName())<0) {

				if (students[i].getAge() > students[j + 1].getAge()) {
					Student tmp = students[j];
					students[j] = students[j + 1];
					students[j + 1] = tmp;
				}
			}
		}
	}

	private static void shellSort(int[] arr) {
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {

			for (int i = gap; i < arr.length; i += 1) {

				int temp = arr[i];

				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
					arr[j] = arr[j - gap];

				arr[j] = temp;
			}
		}

	}

	public static void merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public static void mergeSort(int arr[], int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;

			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	public static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	public static void quickSort(int arr[], int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

}
