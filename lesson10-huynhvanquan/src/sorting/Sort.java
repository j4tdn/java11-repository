package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {
	private Sort() {
	}

	// mode 1: ascending
	// mode -1: descending
	// Bubble sort
	public static void bubbleSort(int[] arr, int mode) {
		int n = arr.length;
		int temp = 0;
		if (mode == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < (n - i); j++) {
					if (arr[j - 1] > arr[j]) {
						swap(arr, j, j - 1);
					}
				}
			}
		}
		if (mode == -1) {
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < (n - i); j++) {
					if (arr[j - 1] < arr[j]) {
						swap(arr, j, j - 1);
					}
				}
			}
		}

	}

	// Inertion sort
	public static void insertionSort(int arr[], int mode) {
		int n = arr.length;
		if (mode == 1) {
			for (int i = 1; i < n; ++i) {
				int key = arr[i];
				int j = i - 1;
				while (j >= 0 && arr[j] > key) {
					arr[j + 1] = arr[j];
					j = j - 1;
				}
				arr[j + 1] = key;
			}
		}
		if (mode == -1) {
			for (int i = 1; i < n; ++i) {
				int key = arr[i];
				int j = i - 1;
				while (j >= 0 && arr[j] < key) {
					arr[j + 1] = arr[j];
					j = j - 1;
				}
				arr[j + 1] = key;
			}
		}
	}

	// Selection sort
	public static void selectionSort(int arr[], int mode) {
		int n = arr.length;
		if (mode == 1) {
			for (int i = 0; i < n - 1; i++) {
				int min_idx = i;
				for (int j = i + 1; j < n; j++)
					if (arr[j] < arr[min_idx])
						min_idx = j;
				int temp = arr[min_idx];
				arr[min_idx] = arr[i];
				arr[i] = temp;
			}
		}

		if (mode == -1) {
			for (int i = 0; i < n - 1; i++) {
				int min_idx = i;
				for (int j = i + 1; j < n; j++)
					if (arr[j] > arr[min_idx])
						min_idx = j;
				int temp = arr[min_idx];
				arr[min_idx] = arr[i];
				arr[i] = temp;
			}
		}

	}

	// Merge sort
	public static void mergeSort(int arr[], int l, int m, int r, int mode) {

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
		if (mode == 1) {
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
		}
		if (mode == -1) {
			while (i < n1 && j < n2) {
				if (L[i] >= R[j]) {
					arr[k] = L[i];
					i++;
				} else {
					arr[k] = R[j];
					j++;
				}
				k++;
			}
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

	public static void sort(int arr[], int l, int r, int mode) {
		if (l < r) {
			int m = l + (r - l) / 2;
			sort(arr, l, m, mode);
			sort(arr, m + 1, r, mode);
			mergeSort(arr, l, m, r, mode);
		}
	}

	// Shell sort
	public static int shellSort(int arr[], int mode) {
		int n = arr.length;
		if (mode == 1) {
			for (int gap = n / 2; gap > 0; gap /= 2) {
				for (int i = gap; i < n; i++) {
					int temp = arr[i];
					int j;
					// Dich phan tu voi khoang cach gap
					for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
						arr[j] = arr[j - gap];
					arr[j] = temp;
				}
			}
			return 0;
		}

		if (mode == -1) {
			for (int gap = n / 2; gap > 0; gap /= 2) {
				for (int i = gap; i < n; i++) {
					int temp = arr[i];
					int j;
					// Dich phan tu voi khoang cach gap
					for (j = i; j >= gap && arr[j - gap] < temp; j -= gap)
						arr[j] = arr[j - gap];
					arr[j] = temp;
				}
			}
			return 0;
		}
		return 0;

	}

	// Quick sort
	public static int partition(int[] arr, int low, int high, int mode) {
		int i = 0;
		if (mode == 1) {
			int pivot = arr[high];
			i = (low - 1);
			for (int j = low; j <= high - 1; j++) {
				if (arr[j] < pivot) {
					i++;
					swap(arr, i, j);
				}
			}
			swap(arr, i + 1, high);
		}

		if (mode == -1) {
			int pivot = arr[high];
			i = (low - 1);
			for (int j = low; j <= high - 1; j++) {
				if (arr[j] > pivot) {
					i++;
					swap(arr, i, j);
				}
			}
			swap(arr, i + 1, high);

		}
		return (i + 1);

	}

	public static void quickSort(int[] arr, int low, int high, int mode) {
		if (low < high) {
			int pi = partition(arr, low, high, mode);
			quickSort(arr, low, pi - 1, mode);
			quickSort(arr, pi + 1, high, mode);
		}
	}

	// Object sort
	public static void sortStudentByName(Student[] students, int mode) {
		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.getName().compareTo(s2.getName()) == 0 ? 0 : 
					   s1.getName().compareTo(s2.getName()) < 0 ? (-1) * mode : mode ;
			}
		});
	}
	public static void sortStudentByAge(Student[] students, int mode) {
		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.getAge() == s2.getAge() ? 0 : (s1.getAge() < s2.getAge()) ? (-1) * mode : mode;
			}
		});
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
