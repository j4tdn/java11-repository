package sorting;

import static utils.ArrayUtils.*;

import java.util.Arrays;

public class Sort {
	public Sort() {
	}
	// mode = 1: Ascending
	// mode = -1: Descending

	// Buble Sort
	public static void bubleSort(int[] arr, int mode) {
		int[] result = Arrays.copyOfRange(arr, 0, arr.length);
		if (mode == 1) {
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result.length - 1 - i; j++) {
					if (result[j] > result[j + 1]) {
						swap(result, j, j + 1);
					}
				}
			}
		}
		if (mode == -1) {
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result.length - 1 - i; j++) {
					if (result[j] < result[j + 1]) {
						swap(result, j, j + 1);
					}
				}
			}
		}
		printf(result);
	}

	// Selection Sort
	public static void selectionSort(int[] arr, int mode) {
		int[] result = Arrays.copyOfRange(arr, 0, arr.length);
		if (mode == 1) {
			for (int i = 0; i < result.length; i++) {
				int min_idx = i;
				for (int j = i + 1; j < result.length; j++) {
					if (result[min_idx] > result[j]) {
						swap(result, min_idx, j);
					}
				}
			}
		}
		if (mode == -1) {
			for (int i = 0; i < result.length; i++) {
				int max_idx = i;
				for (int j = i + 1; j < result.length; j++) {
					if (result[max_idx] < result[j]) {
						swap(result, max_idx, j);
					}
				}
			}
		}

		printf(result);
	}

	//
	// Insertion Sort
	public static void insertionSort(int[] arr, int mode) {
		int[] result = Arrays.copyOfRange(arr, 0, arr.length);
		if (mode == 1) {
			for (int i = 1; i < result.length; i++) {
				if (result[i] < result[i - 1]) {
					for (int j = 0; j < i; j++) {
						if (result[i] < result[j]) {
							swap(result, i, j);
						}
					}
				}
			}
		}
		if (mode == -1) {
			for (int i = 1; i < result.length; i++) {
				if (result[i] > result[i - 1]) {
					for (int j = 0; j < i; j++) {
						if (result[i] > result[j]) {
							swap(result, i, j);
						}
					}
				}
			}
		}
		printf(result);
	}

	// Merge Sort
	public static void merge(int[] arr, int l, int m, int r, int mode) {
		int i, j, k;
		int n1 = m - l + 1;
		int n2 = r - m;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for (i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for (j = 0; j < n2; j++) {
			R[j] = arr[m + 1 + j];
		}
		i = 0;
		j = 0;
		k = l;
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

	public static void mergeSort(int[] arr, int l, int r, int mode) {
		int[] result = Arrays.copyOfRange(arr, 0, arr.length);
		if (l < r) {
			int middle = (l + r) / 2;
			mergeSort(arr, l, middle, mode);
			mergeSort(arr, middle + 1, r, mode);
			merge(arr, l, middle, r, mode);
		}
	}

	public static void shellSort(int arr[], int mode) {
		int[] result = Arrays.copyOfRange(arr, 0, arr.length);
		int interval, i, j, temp;
		if (mode == 1) {
			for (interval = result.length / 2; interval > 0; interval /= 2) {
				for (i = interval; i < result.length; i++) {
					temp = result[i];
					for (j = i; j >= interval && result[j - interval] > temp; j -= interval) {
						result[j] = result[j - interval];
					}
					result[j] = temp;
				}
			}
		}
		if (mode == -1) {
			for (interval = result.length / 2; interval > 0; interval /= 2) {
				for (i = interval; i < result.length; i++) {
					temp = result[i];
					for (j = i; j >= interval && result[j - interval] < temp; j -= interval) {
						result[j] = result[j - interval];
					}
					result[j] = temp;
				}
			}
		}
		printf(result);
	}

	// Quick Sort

	public static int partition(int arr[], int low, int high, int mode) {
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

	// Object Sort
	public static void objectSort(Object[] object, int mode) {
		Arrays.sort(object);
		if (mode == 1) {
			printf(object);
		}
		if(mode==-1) {
			Object[] tmp = Arrays.copyOfRange(object, 0, object.length);
			for(int i=object.length-1;i>=0;i--) {
				tmp[object.length-i-1]=object[i];
			}
			printf(tmp);
		}
		
		

	}


	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
