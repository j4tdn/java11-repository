package exercise;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Ex02 {
	public static void main(String[] args) {
		System.out.println("Please enter your name: ");
		Scanner ip =new  Scanner(System.in);
		String text = ip.nextLine();
		String pattern = "\\D+";
		if (Pattern.matches(pattern, text)) {
			System.out.println(printName(text));
		}
		else {
			System.out.println("You type wrong");
		}
	
		
	}
	
	private static String printName(String text) {
		String s = "";
		String[] name = text.split("\\s+");
		for(String names: name) {
			String firstName = names.substring(0,1).toUpperCase();
			String endName = names.substring(1).toLowerCase();
			 s+= firstName + endName +" ";
		}
	
		return s.replaceAll("[,\\s]+", " ");
	}
}
