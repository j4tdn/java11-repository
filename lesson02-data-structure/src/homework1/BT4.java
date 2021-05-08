package homework1;

import java.util.Iterator;
import java.util.Scanner;

public class BT4 {
	static Scanner ip = new Scanner(System.in);
	public static void main(String[] args) {
		int[] arr = new int[10];
		nhapArr(arr);
		xuatArr(arr);
		System.out.println("==========");
		System.out.println(findMax(arr));
		System.out.println("+=======");
		System.out.println(findNearMax(arr));
	}
	private static int findNearMax(int[] arr) {
		int nearMax = 0;
		int maxLe = findMax(arr);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]%2!=0 && arr[i] < maxLe) {
				nearMax = arr[i];
			}
		}
		return nearMax;
	}
	private static int findMax(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%2!=0) {
				if (arr[i] > max) {
					max = arr[i];
				}
			}
		}
		return max;
	}
	private static void nhapArr(int[] arr) {
		System.out.println("Nhap vao mang ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr["+i+"] = ");
			arr[i] = ip.nextInt();
		}
	}
	public static void xuatArr(int[] arr) {
		System.out.println("Xuat mang ra ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr["+i+"] = "+arr[i]);
		}
	}
}
