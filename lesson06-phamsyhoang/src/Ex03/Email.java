package Ex03;

import java.util.Scanner;

public class Email {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String email;
		while (true) {
			try {
				System.out.print("Nhập Email: ");
				email = ip.nextLine();
				checkEmail(email);
				break;
			} catch (EmailException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private static void checkEmail(String email) throws EmailException {
		int count=0;
		
		for(int i=0;i<email.length();i++) {
			if(email.charAt(i)=='@') {
				count++;
			}
		}
		
		if (count == 0 || count > 1)
			throw new EmailException("Email không hợp lệ! Mời nhập lại!");
		
		if (email.startsWith("@") || email.endsWith("@"))
			throw new EmailException("Email không hợp lệ! Mời nhập lại");
		System.out.println("=========================");
		System.out.println("Email hợp lệ!!!");
	}
}
