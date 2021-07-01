package ex06;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String s = "1234567891011121314";
		int k;
		do {
			System.out.print("Ban muon lay so o vi tri thu : ");
			k = ip.nextInt();
		} while (k > s.length());

		System.out.println("So o vi tri thu " + k + " la : " + s.charAt(k - 1));
	}
}
