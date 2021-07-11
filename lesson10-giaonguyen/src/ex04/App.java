package ex04;

public class App {
	public static void main(String[] args) {
		int[] arr = {4,7,2,9,6};

//		int[] result = bubbleSort(arr);
//		int[] result = selectionSort(arr);
//		int[] result = insertionSort(arr);
		int[] result = shellSort(arr);
		
		for (int r: result) 
			System.out.print(r + " ");
		
		System.out.println("\n==================");
		
		mergeSort(arr, 0, arr.length - 1);
		for (int r: arr) 
			System.out.print(r + " ");
		
		System.out.println("\n==================");

		quickSort(arr, 0, arr.length - 1);
		for (int r: arr) 
			System.out.print(r + " ");
		
	}
	
	/**
	 * Bubble sort algorithm
	 * @param arr
	 * @return
	 */
	public static int[] bubbleSort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		return arr;
	}
	
	public static void swap(int[] arr, int first, int second) {
		int tmp = arr[first];
		arr[first] = arr[second];
		arr[second] = tmp;
	}
	
	/**
	 * Selection sort algorithm
	 * @param arr
	 * @return
	 */
	public static int[] selectionSort(int[] arr) {
		int min = 0;
		int min_Index = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			min = arr[i];
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					min_Index = j;
				}
			}
			swap(arr, i, min_Index);
		}                  
		
		return arr;
	}
	
	/**
	 * Insertion sort algorithm
	 * @param arr
	 * @return
	 */
	public static int[] insertionSort(int[] arr) {
		int tmp = 0;
		int cur = 0;
		
		for(int i = 1; i < arr.length; i++) {
			tmp = i - 1;
			cur = arr[i];
			while ((tmp >= 0) && (cur < arr[tmp])) {
				arr[tmp + 1] = arr[tmp];
				tmp--;
			}
			arr[tmp + 1] = cur;
		}
		
		return arr;
	}
	
	/**
	 * Shell sort algorithm
	 * @param arr
	 * @return
	 */
	public static int[] shellSort(int[] arr) {
		int interval, i, j, tmp;
		
		for (interval = arr.length/2; interval > 0; interval /= 2) {
			for (i = interval; i < arr.length; i++) {
				tmp = arr[i];
				for (j = i; j >= interval && arr[j - interval] > tmp; j -=  interval) {
					arr[j] = arr[j - interval]; 
				}
				arr[j] = tmp;
			}
		}
		
		return arr;
	}
	
	/**
	 * Merge sort algorithm
	 * @param arr
	 * @param firstIndex
	 * @param middleIndex
	 * @param secondIndex
	 */
	
	public static void merge(int[] arr, int firstIndex, int middleIndex, int secondIndex) {
		int i = 0;
	    int j = 0; 
	    int k = firstIndex;
	    int n1 = middleIndex - firstIndex + 1;
	    int n2 = secondIndex - middleIndex;
	 
	    // Tạo các mảng tạm
	    int[] L = new int[n1];
	    int[] R = new int[n2];
	    
	    for (int m = 0; m < n1; m++)
	        L[m] = arr[firstIndex + m];
	    for (int n = 0; n < n2; n++)
	        R[n] = arr[middleIndex + 1+ n];

	    while (i < n1 && j < n2)
	    {
	        if (L[i] <= R[j])
	        {
	            arr[k] = L[i];
	            i++;
	        }
	        else
	        {
	            arr[k] = R[j];
	            j++;
	        }
	        k++;
	    }
	 
	    while (i < n1)
	    {
	        arr[k] = L[i];
	        i++;
	        k++;
	    }
	 
	    while (j < n2)
	    {
	        arr[k] = R[j];
	        j++;
	        k++;
	    }
	}
	
	public static void mergeSort(int[] arr, int firstIndex, int secondIndex) {
		if (firstIndex < secondIndex) {
			int middleIndex = (firstIndex + secondIndex) / 2;
			
			mergeSort(arr, firstIndex, middleIndex);
			mergeSort(arr, middleIndex + 1, secondIndex);
			
			merge(arr, firstIndex, middleIndex, secondIndex);
		}
	}
	
	/**
	 * Quick sort algorithm
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int left = low;
		int right = high - 1;
		
		while (true) {
			// check arr[left] > pivot
			while (left <= right && arr[left] < pivot)
				left++;
			// check arr[right] < pivot
			while (left <= right && arr[right] > pivot)
				right--;
			if (left > right)
				break;
			//swap 
			swap(arr, left, right);
			left++;
			right--;
		}
		//pick new pivot
		swap(arr, left, high);
		
		return left;
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}
}
