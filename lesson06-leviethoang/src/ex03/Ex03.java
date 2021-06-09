package ex03;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String email;
		while(true) {
			try {
				System.out.print("Nhap Email :  ");
				email = ip.nextLine();
				System.out.println("Email cua ban la : " + inputEmail(email));
				break;
			} catch (EmailException e) {
				System.out.println(e.getMessage());
				System.out.println("=====================");
				System.out.println("Enter A Valid Email :  ");
			}
		}
		
	}
	
	private static String inputEmail(String email)  throws EmailException {
		char temp = '@';
		int count = 0;
		if(email.startsWith("@") || email.endsWith("@")) {
			throw new  EmailException("INVALID EMAIL !!!");
		}		
		for(int i = 0; i < email.length() ; i ++) {
				if(email.charAt(i) == temp) {
					count ++;
				}
		}
		if (count > 1 || count == 0) {
			throw new EmailException("INVALID EMAIL !!!");
		}	
		
		return email;
	}
}
