package bt;

import java.util.Scanner;

public class Bai3 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập vào số cần kiểm tra: ");
		int n = ip.nextInt();
		
		boolean kt = kiemTraDoiXung(n);
		
		if (kt) {
			System.out.println(n + " là số đối Xứng");
		}else {
			System.out.println(n + " không phải là số đối xứng");
		}
		
	}
	
	private static boolean kiemTraDoiXung(int n) {
		int reversed = 0;
		int original = n;
		for (; n != 0; n /= 10) {
			int digit = n % 10;
			reversed = reversed * 10 + digit;
		}
		if (reversed == original) {
			return true;
		}
		return false;
	}
	
}
