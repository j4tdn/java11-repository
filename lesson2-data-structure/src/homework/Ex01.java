package homework;

import java.util.Scanner;

public class Ex01 {
	/**
	 * Ex01: kiem tra chuoi nhap vao co phai la mot so hop le => 123 abc 1bc
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		int count = 0;
		while (true) {
			System.out.println("Enter a valid number: ");
			String text = ip.nextLine();
			
			if (isValidNumberPt(text)) {
				System.out.println("number: " + text);
				return;
				
			}
			count++;
			if (count == 3) {
				System.out.println("Wrong entering number exceeds 3 times >> Exit !!!");
				return;
			}
		}
	}
	
	private static boolean isValidNumber(String text) {
		for(int i = 0; i< text.length(); i++) {
			char tmp = text.charAt(i);
			if (!Character.isDigit(tmp)) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isValidNumberPt(String text) {
		String regex = "\\d+";
		return text.matches(regex);
	}
}
