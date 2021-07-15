package exercise;

import java.util.Arrays;

import bean.ArrayUtils;
import objectsort.Student;

public class Ex04 {
	public static void main(String[] args) {
		int[] numbers = {2,5,4,1,7,14,3,18,8,20,30,22};
		
		ArrayUtils.printf(bubbleSort(numbers));
		
		System.out.println("====================");
		ArrayUtils.printf(selectionSort(numbers));
		
		System.out.println("====================");
		ArrayUtils.printf(insertionSort(numbers));

	}
	private static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
	
	//sap xep bubble
	private static int[] bubbleSort(int[] numbers) {
		int[] result = Arrays.copyOf(numbers, numbers.length);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length-i-1; j++) {
				if(result[j] > result[j+1]) {
					swap(result, j, j+1);
				}
			}
		}
		return result;
	}
	
	//Selection sort
	private static int[] selectionSort(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			int min = i;
			for (int j = i+1; j < numbers.length; j++) {
				if(numbers[j] < numbers[min]) {
					min = j;
				}
				swap(numbers, min, i);
			}
		}
		return numbers;
	}
	
	//Insertion sort
	private static int[] insertionSort(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			int j = i-1;
			int tmp = numbers[i];
			while(j>=0 && tmp < numbers[j]) {
				numbers[j+1] =numbers[j];
				j--;
			}
			numbers[j+1] = tmp;
		}
		return numbers;
	}
	
	
}
