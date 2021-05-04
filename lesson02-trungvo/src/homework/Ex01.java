package homework;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("nhap vao so: ");
		Scanner ip = new Scanner(System.in);
		int n = ip.nextInt();
		if (isPrimeofTwo(n)) {
			System.out.println(n+ " la so nguyen to cua 2");
		}
		else System.out.println(n + " khong la so nguyen to cua 2");
		
		
	}
	
	private static boolean isPrimeofTwo(int n) {
		//8
		if (n ==0 || n == 1)
			return true;
		int x = n%2;
		int y = n/2;
		if (x !=0) {
			return false;
		}
		return isPrimeofTwo(y);
		
			} 
	}
	
	

