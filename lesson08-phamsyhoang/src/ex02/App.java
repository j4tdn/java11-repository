package ex02;

import java.util.Scanner;

public class App {
	
	private static String FULL_NAME_PATTERN ="[A-Za-z\\s]+";
	
	public static void main(String[] args) {
		String s;
		while(true) {
			Scanner ip = new Scanner(System.in);
			System.out.print("Enter full name: ");
			s = ip.nextLine();
			if(s.matches(FULL_NAME_PATTERN)) {
				break;
			}
			System.out.println("Invalid name! Please enter again!");
		}
		Convert(s);
	}
	
	private static void Convert(String s) {
		String[] words = s.split("\\s");
		for(String w:words) {
			String w1= w.substring(0, 1);
			w1=w1.toUpperCase();
			String w2 = w.substring(1);
			w2=w2.toLowerCase();
			w=w1+w2;
			System.out.print(w + " ");
		}
	}
	
	
	
}
