package bt03;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bt03 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String input;
		String regex = "^\\w+@{1}\\w+.com$";
		//Format email: ki tu + @ + ki tu + .com 
		while (true) {
			try {
				System.out.print("Enter mail: ");
				input = ip.nextLine();
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(input);
				if (matcher.find()) {
					System.out.println("Valid email");
					break;
				} else {
					System.out.println("Invalid email, try again");
				}
			} catch (Exception e) {
				input = ip.nextLine();
			}
		}
	}
}
