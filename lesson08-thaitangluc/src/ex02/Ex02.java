package ex02;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String s;
		do {
			try {
				System.out.println("Nhap ho va ten: ");
				s = ip.nextLine();
				check(s);
				break;
			} catch (Input e) {
			}
		} while (true);
		s = removeSpace(s);
		s = upperCase(s);
		System.out.println(s);
	}

	private static void check(String s) throws Input {
		if (!s.matches("[[a-zA-Z]+\\s+]+"))
			throw new Input("Ten chi chua ky tu [A-Za-z]");
	}

	private static String upperCase(String s) {
		s = s.toLowerCase();
		char[] charArray = s.toCharArray();
		charArray[0] = Character.toUpperCase(charArray[0]);
		for(int i = 1; i < charArray.length; i++) {
			if(!Character.isLetter(charArray[i-1])) {
				charArray[i] = Character.toUpperCase(charArray[i]);
			}
		}
		s = String.valueOf(charArray);
//		char[] charArray = s.toCharArray();
//		boolean kt = true;
//		for (int i = 0; i < charArray.length; i++) {
//			if (Character.isLetter(charArray[i])) {
//				if (kt) {
//					charArray[i] = Character.toUpperCase(charArray[i]);
//				} else {
//					charArray[i] = Character.toLowerCase(charArray[i]);
//				}
//				kt = false;
//			} else kt = true;
//		}
//		s = String.valueOf(charArray);
		return s;
	}
	
	private static String removeSpace(String s) {
		s = s.trim().replaceAll("\\s+", " ");
		return s;
	}
}
