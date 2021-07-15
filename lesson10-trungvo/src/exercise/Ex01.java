package exercise;

import java.util.Arrays;

import bean.ArrayUtils;

public class Ex01 {
	public static void main(String[] args) {
		int[] arr1= {1, 5 ,3 , 5 , 1 , 2 ,6,6,6 };
	
		System.out.println("Array after remove duplicate elements: ");
		ArrayUtils.printf(removeDup(arr1));
		System.out.println("===============================");
		compareAverage(arr1);
		System.out.println("==============================");
		ArrayUtils.printf(deleteE(arr1));
		ArrayUtils.printf(thridNumber(arr1)); 
	}
	
	//xoa phan tu trung
	private static int[] removeDup(int[] arr ) {
		int[] result = new int[arr.length];
		int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if(checkDup(arr, arr[i]) ) {
					result[count++] = arr[i];
				}
			}
		
		return Arrays.copyOfRange(result, 0, count);
	}
	
	//kiem tra phan tu trung nhau
	private static boolean checkDup(int[] arr, int number) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == number) {
				count++;
			}
		}
		if(count >1) {
			return false;
		}
		return true;
	}
	
	//compare average n/2 number in array
	private static void compareAverage(int[] arr) {
		int firstE =0;
		int lastE = 0;
		for (int i = 0; i < arr.length/2; i++) {
			firstE += arr[i];
			lastE +=  arr[arr.length - i -1];
		}
		if(firstE > lastE) {
			System.out.println("Array in left > array in right");
		}else if(firstE < lastE) {
			System.out.println("Array in left < arry in right");
		}else {
			System.out.println("Array in left = array in right");
		}
		
	}
	
	//third in the array
	private static int thridNumber(int[]arr) {
		int[] result = deleteE(arr);
		return result[result.length-3];
	}
	//delete duplicated elements and sorting
	private static int[] deleteE(int[] arr) {
		int[] result = new int[arr.length];
		
		int count =0;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length-1; i++) {
				if(arr[i] != arr[i+1]) {
					result[count++] = arr[i];
			}
		}
		result[count++]= arr[arr.length-1];
		
		return Arrays.copyOfRange(result, 0, count);
 	}
	
}
