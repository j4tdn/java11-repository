package bt04;

public class Bt04 {
	public static void main(String[] args) {

		int[] arr = { 1, 42, 55, 24, 77, 83, 91, 36, 69, 22 };
		System.out.println("BubleSort:");
		bubleSort(arr);

		System.out.println();
		System.out.println("SelectionSort:");
		SelectionSort(arr);

		System.out.println();
		System.out.println("InsertionSort:");
		insertionSort(arr);

	}

	// BubleSort
	private static void bubleSort(int[] number) {
		for (int i = 0; i < number.length; i++) {
			for (int j = i + 1; j < number.length; j++) {
				if (number[i] > number[j]) {
					int temp = number[i];
					number[i] = number[j];
					number[j] = temp;
				}
			}
			System.out.print(number[i] + " ");
		}

	}

	// SelectionSort
	private static void SelectionSort(int[] num) {
		for (int i = 0; i < num.length; i++) {
			// find min number
			int minIndex = i;
			for (int j = i + 1; j < num.length; j++) {
				if (num[j] < num[minIndex]) {
					minIndex = j;
				}
			}
			// swap min with 1st num
			int tmp = num[minIndex];
			num[minIndex] = num[i];
			num[i] = tmp;
			System.out.print(num[i] + " ");
		}
	}

	// insertionSort
	private static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
			System.out.print(arr[i] + " ");
		}
	}

}
