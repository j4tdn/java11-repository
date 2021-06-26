package ex04;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao 1 chuoi: ");
		String s = sc.nextLine();
		System.out.println(revert(s));
	}
	private static String revert(String s) {
		String result = "";
		s = s.trim();
		String[] words = s.split("[\\s]++");
		for (String word:words) {
			String revert = "";
			for (int i = word.length()-1; i >= 0; i--) {
				revert += word.charAt(i);
			}
			
			result += revert + " ";
		}
		
		return result;
	}
}
