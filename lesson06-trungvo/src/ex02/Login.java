package ex02;

import java.util.Scanner;

public class Login {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhap vao id: ");
		String id = ip.nextLine();
		while(true){
			
			
			System.out.println("Nhap vao pass: ");
			String pass = ip.nextLine();
			try {
				passWord(id, pass);
			System.out.println("Login successfully");
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}
	private static boolean passWord(String id, String pass) throws PassException {
		if (pass.contains(id)) {
			throw new PassException("not must contain email");
		}
		if(pass.length() < 8 || pass.length() > 256 ) {
			throw new PassException("Exceed bound");
		}
		if (!pass.matches(".*[a-z].*")) {
			throw new PassException("At least have 1 lowcase");
		}
		if (!pass.matches(".*[A-Z].*")) {
			throw new PassException("At least have 1 upcase");
		}
		if (!pass.matches(".*[0-9].*")) {
			throw new PassException("At least have 1 lowcase");
		}
		if (!pass.matches(".*[a-z].*")) {
			throw new PassException("At least have 1 lowcase");
		}
		if (!pass.matches(".*[^A-Za-z0-9].*")) {
			throw new PassException("Your pass at least 1 special character !");
		}
		return true;
		
	}
}
