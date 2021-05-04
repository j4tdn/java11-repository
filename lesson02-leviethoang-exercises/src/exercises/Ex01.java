package exercises;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap n : ");
		int n = ip.nextInt();
		if(isLT2(n)) {
			System.out.println(n + " la luy thua cua 2");
		}else {
			System.out.println(n + " khong phai la luy thua cua 2");
		}
	}
	
	private static boolean isLT2(int n) {
		int i = 0;
		double s = 0;
		while(s < n) {
			s = Math.pow(2, i);
			if(s == n) {
				return true;
			}
			i++;
		}
		return false;
	}
}
