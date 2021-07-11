package ex04;

import utils.ArrayUtils;

public class Ex04 {
	public static void main(String[] args) {
		int[] arr = {1, 5, 3, 2, 7, 1, 3};
		ArrayUtils.printf(bubbleSort(arr));
		ArrayUtils.printf(insertionSort(arr));
		ArrayUtils.printf(selectionSort(arr));
		ArrayUtils.printf(shellSort(arr));
		
		
		
	}
	private static int[] bubbleSort(int a[]){
		for (int i = a.length-1; i >= 1; i--){
			boolean swapped= true;
			for (int j = 0; j < i; j++){
				if (a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					swapped = false;
				}
			}
			if (swapped){
				break;
			}
		}
		return a;
	}
	private static int[] insertionSort(int a[]){
		int index, value;
		for (int i = 1; i < a.length; i++){
			index = i;
			value = a[i];
			while (index > 0 && a[index - 1] > value){
				a[index] = a[index - 1];
				index --;
			}
			a[index] = value;
		}
		return a;
	} 
	private static int[] selectionSort(int a[]){
		int indexMin;
		for (int i = 0; i < a.length-1; i++){
			indexMin = i;
			for (int j = i+1; j < a.length; j++){
				if (a[indexMin] > a[j]){
					indexMin = j;
				}
			}
			if (i != indexMin){
				int temp = a[i];
				a[i] = a[indexMin];
				a[indexMin] = temp;
			}
		}
		return a;
	} 
	private static int[] shellSort(int[] a) {

	
        for (int gap = a.length/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < a.length; i += 1)
            {
                int temp = a[i];
                int j;
                for (j = i; j >= gap && a[j - gap] > temp; j -= gap)
                    a[j] = a[j - gap];
                a[j] = temp;
            }
        }
        return a;
	}

}
