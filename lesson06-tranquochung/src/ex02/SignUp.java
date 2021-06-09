package ex02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignUp {
	public static void main(String[] args) {
		String pass;
		Scanner ip = new Scanner(System.in);
		while(true) {
			try {
				System.out.println("Nhập PassWord:  ");
				pass = ip.nextLine();
				checkPass(pass);
				break;
			} catch (PassWordException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private static void checkPass(String pass) throws PassWordException {
		
		boolean lowerCase = false;
		boolean upperCase = false;
		boolean digit = false;
		
		if(pass.length() < 8) throw new PassWordException("At least 8 character");
		if(pass.length() > 256) throw new PassWordException("At most 256 charcters");
	
		for(int i = 0; i < pass.length(); i++) {
			if(Character.isLowerCase(pass.charAt(i))) {
				lowerCase = true;
				break;
			}
		}
		
		for(int i = 0; i < pass.length(); i++) {
			if(Character.isUpperCase(pass.charAt(i))) {
				upperCase = true;
				break;
			}
		}
		
		for(int i = 0; i < pass.length(); i++) {
			if(Character.isDigit(pass.charAt(i))) {
				digit = true;
				break;
			}
		}
		
		if(lowerCase == false) 
			throw new PassWordException("At least 1 lowercase alphabetic character (a, b, c...) ");
		
		if(upperCase == false) 
			throw new PassWordException("At least 1 uppercase alphabetic character (A, B, C...) ");
		
		if(digit == false) 
			throw new PassWordException("At least 1 number (1, 2, 3...) ");
		
		Pattern p = Pattern.compile("[^a-z0-9]",Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(pass);
		if(!m.find()) throw new PassWordException("At least 1 special character");
		
		System.out.println("<<==== SUCCESSFULLY ====>>");
	}
}
