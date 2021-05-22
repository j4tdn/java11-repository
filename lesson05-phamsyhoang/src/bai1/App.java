package bai1;

public class App {
	public static void main(String[] args) {
		int[] A = { 3, 15, 21, 0, 15, 17, 21 };
		getUniqueNumbers(A);

	}

	public static int[] getUniqueNumbers(int[] arr) {
		int[] B = new int[100];

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");

		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				System.out.print(arr[i] + " ");
				continue;
			}
			
			System.out.print(arr[i]+" ");
		}
		

		return B;
	}
}
