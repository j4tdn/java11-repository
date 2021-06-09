package Ex02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class App {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("======= REGISTER AN ACCOUNT =======");
		String pw;
		while (true) {
			try {
				System.out.print("Enter Password: ");
				pw = ip.nextLine();
				checkPassWord(pw);
				break;
			} catch (PassWordException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void checkPassWord(String pw) throws PassWordException {
		boolean lowerCase = false;
		boolean upperCase = false;
		boolean digit = false;
		
		if(pw.length()<8) {
			throw new PassWordException("At least 8 characters!");
		}

		if(pw.length()<8) {
			throw new PassWordException("At most 256 characters!");
		}
		
		for(int i =0; i< pw.length();i++) {
			if(Character.isLowerCase(pw.charAt(i))) {
				lowerCase= true;
				break;
			}
		}
		
		for(int i = 0; i < pw.length(); i++) {
			if(Character.isUpperCase(pw.charAt(i))) {
				upperCase = true;
				break;
			}
		}
		
		for(int i = 0; i < pw.length(); i++) {
			if(Character.isDigit(pw.charAt(i))) {
				digit = true;
				break;
			}
		}
		
		if(lowerCase == false) {
			throw new PassWordException("At least 1 lowercase alphabetic character (a, b, c...)!");
		}
		
		if(upperCase == false) {
			throw new PassWordException("At least 1 uppercase alphabetic character (A, B, C...)!");
		}
		
		if(digit == false) { 
			throw new PassWordException("At least 1 number (1, 2, 3...)!");
		}
		
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(pw);
		boolean b = m.find();

		if (!b) {
			throw new PassWordException("At least 1 special character!");
		}
		
		System.out.println("===================================");
		System.out.println("Successful account registration!!!");
		
	}
}
