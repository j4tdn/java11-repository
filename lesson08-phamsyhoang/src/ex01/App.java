package ex01;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập chuỗi: ");
		String s = ip.nextLine();

		System.out.println("==========================");

		for (char c : s.toCharArray()) {
			System.out.println(c);
		}

		System.out.println("==========================");

		for (String w : s.split("\\s")) {
			System.out.println(w);
		}

		System.out.println("==========================");

		for(int i = s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
	}
}
