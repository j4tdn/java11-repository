package exercises;

import java.util.Comparator;

public class Ex04 {
	public static void main(String[] args) {
	}

	//buble sort
		public static int[] bubleSort(int[] arr) {
			int tem;
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[i] > arr[j]) {
						tem = arr[i];
						arr[i] = arr[j];
						arr[j] = tem;
					}
				}
			}

			return arr;
		}
	//insert sort
		public static int[] insertSort(int[] arr) {
			int temp = 0, j = 0;
			for (int i = 1; i < arr.length; i++) {
				j = i - 1;
				temp = arr[i];
				while (j >= 0 && temp < arr[j]) {
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j + 1] = temp;

			}
			return arr;

		}
	//quick sort
		public static int partition(int[] arrayInt, int left, int right) {
			int x = arrayInt[left];
			int i = left + 1, j = right;
			int temp = 0;
			do {
				while (i <= j && arrayInt[i] <= x) {
					i++;
				}
				while (i <= j && arrayInt[j] > x) {
					j--;
				}
				if (i < j) {
					temp = arrayInt[i];
					arrayInt[i] = arrayInt[j];
					arrayInt[j] = temp;
					i++;
					j--;
				}
			} while (i <= j);
			temp = arrayInt[left];
			arrayInt[left] = arrayInt[j];
			arrayInt[j] = temp;
			return j;
		}

		public static void quickSort(int[] arrayInt, int left, int right) {
			int k;
			if (left < right) {
				k = partition(arrayInt, left, right);
				quickSort(arrayInt, left, k - 1);
				quickSort(arrayInt, k + 1, right);
			}
		}
	//selection sort
		public static int[] selectionSort(int[] arr) {
			 for (int i = 0; i < arr.length - 1; i++)  
		        {  
		            int index = i;  
		            for (int j = i + 1; j < arr.length; j++){  
		                if (arr[j] < arr[index]){  
		                    index = j;//searching for lowest index  
		                }  
		            }  
		            int tem = arr[index];   
		            arr[index] = arr[i];  
		            arr[i] = tem;  
		        }  
			return arr;
		}

	}