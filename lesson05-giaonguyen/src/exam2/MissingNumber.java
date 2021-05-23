package exam2;

public class MissingNumber {
	public static void main(String[] args) {
		int[] arr1 = {3, 2, 1, 6, 5};
		int[] arr2 = {3, 7, 9, 2, 1, 6, 5, 4, 10};
		
		sort(arr1);
		sort(arr2);
		
		System.out.println("Missing number of arr 1 is: " + getMissingNumber(arr1));
		System.out.println("Missing number of arr 2 is: " + getMissingNumber(arr2));
		
	}
	
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
				}
			}
		}
	}
	
	public static int getMissingNumber(int[] arr) {
		int missNumber = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == missNumber) missNumber++;
			else break;
		}
		return missNumber;
	}
}
