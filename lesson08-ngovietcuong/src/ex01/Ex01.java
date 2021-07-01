package ex01;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String str;
		do {
			System.out.print("Moi nhap chuoi : ");
			str = ip.nextLine();
		} while (str.matches("[[a-z][A-Z]\\s]+") == false);

		System.out.println("Moi ky tu tren moi dong : ");
		eachCharacter(str);

		System.out.println("Moi tu tren moi dong : ");
		everyWord(str);

		System.out.println("Chuoi dao nguoc");
		reverse(str);
	}

	public static void eachCharacter(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
	}

	public static void everyWord(String s) {
		String[] arr = s.split(" ");
		for (String ar : arr) {
			System.out.println(ar);
		}
	}

	public static void reverse(String s) {
		String[] strings = s.split(" ");
		String name = "";
		for (String s1 : strings) {
			String s2 = new StringBuffer(s1).reverse().toString();
			name = name + " " + s2;
		}
		name = name.trim();
		System.out.println(name);
	}
}
