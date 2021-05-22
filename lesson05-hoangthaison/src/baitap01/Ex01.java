package baitap01;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex01 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int [] arr = {15,1,14,15,7,1,1,9};
		int [] a = new int [10];
		for(int i = 0; i < 10; i++) {
		   System.out.println(getUniqueNumber(arr,arr[i])[i]);
		}
		
	}
	
	private static int[] getUniqueNumber(int [] arr,int x) {
		int []a = new int [10];
		for(int i = 0; i < 10; i++) {
			if(dem(arr,x)==1) {
				a[i]= x;
			}
		}
		return a;
	}
	private static int dem(int []arr,int x) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]==x)
				count ++;
		}
		return count;
	}

}
