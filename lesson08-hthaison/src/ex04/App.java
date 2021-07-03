package ex04;

import java.math.BigInteger;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("A = ");
		BigInteger A = new BigInteger(sc.nextLine());
		System.out.println("B = ");
		BigInteger B = new BigInteger(sc.nextLine());
		*/
		int[] A = uocchung(15);
		int[] B = uocchung(75);
		int otherzeroA = countNbOtherZero(A);
		int otherzeroB = countNbOtherZero(B);
		
		
		int count = 0;
		for(int i = 0; i < A.length; i++) {
			if(A[i] != 0)
				if(A[i] == B [i] ) {
					count ++;
				}
		}
		if(count == otherzeroA && count == otherzeroB) {
			System.out.println(" Là 2 số nguyên tố tương đương");
		}
		else System.out.println(("Không Phải"));
	}
	private static int[] uocchung (int n) {
		int[] arr = new int[n];
		int count = 0;
			for(int i = 1; i < n; i++) {
				count++;
				if(n % i == 0) {
				  if(isPrimNumber(i)) {
					  arr[count] = i;
				  }
			}
		}
		return arr;
	}
	private static boolean isPrimNumber(int n) {
		if(n < 2) {
			return false;
		}
		
		for(int i = 2; i < n/2; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
		
	}
	private static int countNbOtherZero(int[] arr) {
		int count = 0;
		for(int i: arr) {
			if(arr[i] != 0)
				count ++;
		}
		return count;
	}

}
