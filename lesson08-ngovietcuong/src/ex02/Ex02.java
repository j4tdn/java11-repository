package ex02;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String name;
		do {
			System.out.print("Moi nhap ho ten : ");
			name = ip.nextLine();
		} while (name.matches("[[a-z][A-Z]\\s]+") == false);
		
		System.out.println("Ten truoc khi doi la : " + name);

		name = name.replaceAll("[\\s]+", " ");
		name = name.toLowerCase();

		String[] ss = name.split(" ");

		String fullName = "";
		for (String s : ss) {
			char[] c = s.toCharArray();
			c[0] = Character.toUpperCase(c[0]);
			String s1 = String.valueOf(c);
			fullName = fullName + " " + s1;
		}
		fullName = fullName.trim();
		System.out.println("Ten sau khi doi la : " + fullName);

	}
}
