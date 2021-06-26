package bt;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bt02 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String input;
		String regex = "^[A-Z]{1}[a-z]{1,}\\s{1}[[A-Z]{1}[a-z]{1,}\\s{1}]{1,}";
		// Format email: ki tu + @ + ki tu + .com
		while (true) {
			try {
				System.out.print("Enter mail: ");
				input = ip.nextLine();
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(input);
				if (matcher.find()) {
					System.out.println("Valid Name");
					break;
				} else {
					System.out.println("Invalid Name, try again");
				}
			} catch (Exception e) {
				input = ip.nextLine();
			}
		}
	}
}
