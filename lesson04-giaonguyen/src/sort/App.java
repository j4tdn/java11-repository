package sort;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		int numOfArray = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Input amount of array: ");
		numOfArray = sc.nextInt();

		int[] arr = new int[numOfArray];
		int max = numOfArray - 1;
		for (int i = 0; i < numOfArray; i++) {
			System.out.printf("a[%d] = ", i);
			arr[i] = sc.nextInt();
		}
		
		System.out.println("\nArray: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		for (int i = 0; i < numOfArray; i++) {
			for (int j = i; j < numOfArray; j++) {
				if (arr[j] % 7 == 0 && arr[j] % 5 != 0) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				else if (arr[j] % 5 == 0 && arr[j] % 7 != 0) {
					int t = arr[j];
					arr[j] = arr[max];
					arr[max] = t;
					max--;
					numOfArray--;
					j--;
				}
			}
		}
		
		System.out.println("\nArray after sorting: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

