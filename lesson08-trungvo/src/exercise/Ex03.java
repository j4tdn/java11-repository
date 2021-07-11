package exercise;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("Please enter your text: ");
		Scanner ip = new Scanner(System.in);
		String text = ip.nextLine();
		System.out.println(noChar(text));
		
		
	}
	private static String noChar(String text) {
		String temp = Normalizer.normalize(text, Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "d").replaceAll("đ", "d");
	}
	
	
}
