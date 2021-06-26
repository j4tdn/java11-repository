package ex02;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
	public static void main(String[] args) {
		String regex = "[a-zA-Z\\s]+";
		String name;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name: ");
		name = sc.nextLine();
		
		while (!Pattern.matches(regex, name)) {
			System.out.println("Enter name: ");
			name = sc.nextLine();	
		}
		
		String str = name.toLowerCase();
		
		String[] _name = str.split("\\s");
		String result = "";
	
		for (String t_name : _name) {
			String s = t_name.substring(0, 1).toUpperCase() + t_name.substring(1);
			result += s + " ";
		}
		
		result.trim();
		System.out.println("result: " + result);
		
	}
}
