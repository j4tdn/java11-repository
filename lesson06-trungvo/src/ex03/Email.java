package ex03;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Email {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		String email = null;
		while(true) {
			try {
				System.out.println("Enter your email: ");
				email = ip.nextLine();
				String emailPattern = "^[a-zA-Z][\\w-]+@(gmail.com.vn)$";
				boolean result = Pattern.matches(emailPattern, email);
				if(result == true) {
					System.out.println(result);	
					break;
				}
				
				
			} catch (Exception e) {	
			} 
			System.out.println("Incorrect format. Please enter again");
	
			
		}
		
	
	}	
}
