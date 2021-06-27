package ex02;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		String name = new String(inputName());
		name = formatText(name);
		System.out.println("(1) " + name);
		System.out.println("(2) " + addSpaceBetweenChar(name));
	}
	
	private static String addSpaceBetweenChar(String text) {
	    return String.valueOf(text.replace(" ", "")).replaceAll(".", "$0  ");
	}
	
	private static String formatText(String text) {
		String newText = "";
		for (CharSequence s:text.split("\\s")) {
			newText += Character.toUpperCase(s.charAt(0)) + ((String) s).substring(1).toLowerCase() + " ";
		}
		return newText.trim();
	}
	
	private static String inputName() {
		String name = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name (a-zA-Z): ");
		name = sc.nextLine();
		while(!name.matches("^[a-zA-Z\\s]+$")) {
			System.out.println("Name is invalid! Enter again!");
			System.out.println("Enter name (a-zA-Z): ");
			name = sc.nextLine();
		}
		return name;
	}
}
