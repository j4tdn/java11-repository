package homework02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pw;
		System.out.println("***Create a new passwork***");

		while (true) {
			try {
				System.out.println("Enter your new passwork: ");
				pw = sc.nextLine();
				amount(pw);
				character(pw);
				break;
			} catch (AmountCharactersException | CharacterException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static boolean amount(String pass) throws AmountCharactersException {
		if (pass.length() < 8 || pass.length() > 256) {
			throw new AmountCharactersException("Your passwork at least 8 characters or at most 256 characters");
		}
		return true;
	}

	public static boolean character(String pass) throws CharacterException {
		int countLower = 0;
		for(int i = 0; i < pass.length(); i++) {
			if(Character.isLowerCase(pass.charAt(i))) {
				countLower++;
			}
		}
		if( countLower == 0) {
			throw new CharacterException("Your passwork must be have at least 1 lowercase alphabetic char");
		}
		
		int countUpper = 0;
		for(int i = 0; i < pass.length(); i++) {
			if(Character.isUpperCase(pass.charAt(i))) {
				countUpper++;
			}
		}
		if( countUpper == 0) {
			throw new CharacterException("Your passwork must be have at least 1 uppercase alphabetic char");
		}
		
		int countNumber = 0;
		for(int i = 0; i < pass.length(); i++) {
			if(Character.isDigit(pass.charAt(i))) {
				countNumber++;
			}
		}
		if( countNumber == 0) {
			throw new CharacterException("Your passwork must be have at least 1 number");
		}
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
		Matcher m = p.matcher(pass);
		boolean b = m.find();
		if(!b) {
			throw new CharacterException("Your passwork must be have at least 1 special character");
		}
		
		return true;
	}
}
