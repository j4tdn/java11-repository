package ex03;

import java.text.Normalizer;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input: ");
		String text = sc.nextLine();
		System.out.println(stripAccents(text));
	}
	public static String stripAccents(String text) 
	{
		if(text == "") {
			return "Input null !";
		}
		else {
			text = Normalizer.normalize(text, Normalizer.Form.NFD);
			text = text.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
			return text;
			}
	}
}
