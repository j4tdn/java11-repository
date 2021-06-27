package ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		String text = input();
		printChar(text);
		printWords(text);
		printReversedChar(text);
		printReversedWord(text);
	}
	
	private static void printReversedChar(String text) {
		System.out.println("===== In chuỗi đảo ngược ký tự =====");
		StringBuilder sb = new StringBuilder(text);
		for (int i = text.length() - 1; i >= 0; i--) {
			System.out.print(text.charAt(i));
		}
	}
	
	private static void printReversedWord(String text) {
		System.out.println("\n===== In chuỗi đảo ngược theo từ =====");
		for(CharSequence c:text.split("\\s")) {
			for(int i = c.length() - 1; i >= 0; i--) {
				System.out.print(c.charAt(i));
			}
			System.out.print(" ");
		}
	}
	
	private static void printWords(String text) {
		System.out.println("===== In mỗi từ trên mỗi dòng, các ký tự cách nhau bởi ký tự trống =====");
		for(CharSequence c:text.split("\\s")) {
			for(int i = 0; i < c.length(); i++) {
				System.out.print(c.charAt(i) + " ");
			}
			System.out.print("\n");
		}
	}
	
	private static void printChar(String text) {
		System.out.println("===== In mỗi ký tự trên một dòng ===== ");
		for (int i = 0; i < text.length(); i++) {
			System.out.println(text.charAt(i));
		}
	}
	
	private static String input() {
		String text = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập chuỗi (Chỉ chứa ký tự có dấu): ");
		text = sc.nextLine();
		while (!text.matches("^[ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨ"
				+ "ẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉị"
				+ "ọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$")) {
			System.out.println("Chuỗi nhập không hợp lệ! Vui lòng nhập lại!");
			System.out.println("Nhập chuỗi (Chỉ chứa ký tự có dấu): ");
			text = sc.nextLine();
		}
		return text;
	}
}
