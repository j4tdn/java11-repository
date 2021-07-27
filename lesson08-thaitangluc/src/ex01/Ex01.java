package ex01;

import java.util.Scanner;

import ex02.Input;
import ex03.StringUtils;

public class Ex01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String s;
		do {
			try {
				System.out.println("Nhap chuoi: ");
				s = ip.nextLine();
				String ss = StringUtils.removeAccent(s);
				check(ss);
				break;
			} catch (Input e) {
			}

		} while (true);
		printCharacters(s);
		System.out.println("=================");
		printWords(s);
		System.out.println("=================");
		printCharacters(s);
		System.out.println("=================");
		printReverseCharacters(s);
		System.out.println("=================");
		printReverseWords(s);
	}

	private static void check(String s) throws Input {
		
		if (!s.matches("[[a-zA-Z]+\\s+]+"))
			throw new Input("Chuỗi chỉ chứa các kí tự tiếng việt có dấu");
	}

	private static void printCharacters(String s) {
		System.out.println("In từng ký tự");
		String[] charArray = s.trim().replaceAll("\\s+", "").split("");
		for (String a: charArray) {
			System.out.println(a);
		}
	}

	private static void printWords(String s) {
		System.out.println("In từng từ");
		String[] wordsArray = s.trim().replaceAll("\\s+", " ").split(" ");
		for (String a: wordsArray) {
			System.out.println(a);
		}
	}
	
	private static void printReverseCharacters(String s) {
		System.out.println("In từng ký tự đảo ngược");
		String[] charArray = s.trim().replaceAll("\\s+", "").split("");
		for(int i = charArray.length - 1; i >= 0; i--) {
			System.out.println(charArray[i]);
		}
	}
	
	private static void printReverseWords(String s) {
		System.out.println("In từng từ đảo ngược");
		String[] wordsArray = s.trim().replaceAll("\\s+", " ").split("\\s");
		for(int i = wordsArray.length - 1; i >= 0; i--) {
			System.out.println(wordsArray[i]);
		}
	}
}
