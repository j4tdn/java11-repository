package exercise;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
	System.out.println("Nhap vao dong: ");
	Scanner ip = new Scanner(System.in);
	String text = ip.nextLine();
	System.out.println("===========");
	oneChar(text);
	System.out.println("===========");
	oneWord(text);
	System.out.println("===========");
	print(text);
	}
	
	private static void oneChar(String text) {
		for (int i = 0; i < text.length(); i++) {
				System.out.println(text.charAt(i) + " ");
			}
		}
	
	private static void oneWord(String text) {
		String[]words = text.split("\\s");
		for(String word:words) {
			System.out.println(word);
		}
	}
	private static void print(String text) {
		String[]words = text.split("\\s");
		for(String word: words) {
			StringBuffer str = new StringBuffer(word);
			System.out.print(str.reverse() + " ");
			
	}
		System.out.println("");
		StringBuffer str = new StringBuffer(text);
		System.out.println(str.reverse());
	}
	
	
	
}
