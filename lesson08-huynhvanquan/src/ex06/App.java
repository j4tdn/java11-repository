package ex06;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		int k;
		String s = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("How many numbers do you want to input?");
		k = sc.nextInt();
		System.out.println("Enter numbers: ");
		for (int i = 0; i < k; i++) {
			s += sc.nextInt() + "";
		}
		System.out.println("Your numbers line: " + s);
		System.out.println("Number at" +  k + "position: " + s.charAt(k - 1));
	}
}
