package ex02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.UpAlphabeticException;
import exception.IsNumberException;
import exception.LengthOfPassException;
import exception.LowAlphabeticException;
import exception.SpecialCharacterException;

public class App {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("User Name: ");
			String userName = sc.nextLine();
			System.out.println("Pass Word: ");
			String passWord = sc.nextLine();
			try {
				checkLengthPass(passWord);
				upAlphabetic(passWord);
				lowAlphabetic(passWord);
				IsNumber(passWord);
				specialCharacter(passWord);
			}
			catch(LengthOfPassException e) {
				System.out.println(" length of Pass muss least 8 character and most 256 character");
			}
			catch(UpAlphabeticException e) {
				System.out.println("not hava uppercase Alphabetic!!");
			} catch (LowAlphabeticException e) {
				System.out.println("must have at least 1 lowercase Alphabetic");
			} catch (IsNumberException e) {
				System.out.println("Must have at least 1 number");
			} catch (SpecialCharacterException e) {
				System.out.println("Must have at least 1 special character");
			}

			
	}
	private static boolean checkLengthPass(String passWord)  throws LengthOfPassException{
		if(passWord.length() <= 8 || passWord.length() >= 256) {
			throw new LengthOfPassException("Wrong length of PassWord !");			
		}
		return true;
		
	}
	private static boolean upAlphabetic(String passWord) throws UpAlphabeticException{
		int k =0;
		for(int i = 0; i < passWord.length(); i++) {
			if(65 <= passWord.codePointAt(i) && passWord.codePointAt(i)<=90) {
				k ++;
			}
		}
		if(k == 0) {
			throw new UpAlphabeticException("uppercase Alphabetic");
		}
		return true;
		
	}
	private static boolean lowAlphabetic(String passWord)  throws LowAlphabeticException {
		int k =0;
		for(int i = 0; i < passWord.length(); i++) {
			if(97 <= passWord.codePointAt(i) && passWord.codePointAt(i) <= 122) {
				k ++;
			}
		}
		if(k == 0) {
			throw new LowAlphabeticException("lowercase Alphabetic");
		}
		return true;
	}
	
	private static boolean IsNumber(String passWord)  throws IsNumberException {
		int k =0;
		for(int i = 0; i < passWord.length(); i++) {
			if(48 <= passWord.codePointAt(i) && passWord.codePointAt(i) <= 57) {
				k ++;
			}
		}
		if(k == 0) {
			throw new  IsNumberException(" Must contain at least 1 Number ");
		}
		return true;
	}

	
	private static boolean specialCharacter(String passWord)  throws SpecialCharacterException {

		if(passWord == null || passWord.isEmpty()) {
			System.out.println("Incorrect format of String");
			return false;
		}
		Pattern p = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
		Matcher m = p.matcher(passWord);
		if(!m.find()) {
			throw new SpecialCharacterException("Must contain at least a special character");
			
		}
		else return true;
	}
	
	
}
