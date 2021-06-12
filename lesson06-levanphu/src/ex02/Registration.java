package ex02;

import java.util.Scanner;
public class Registration {
   public static void main(String[] args) {
	Scanner ip = new Scanner(System.in);
	String account;
	String password = null;
	while(true) {
		try {
			System.out.println("Enter account");
			account = ip.nextLine();
			System.out.println("Enter password");
			System.out.println("Password: " + Password(account, password));
		}catch(Password e) {
			System.out.println(e.getMessage());
			System.out.println("Successful account registration");
		}
	}
}
   private static String Password(String account, String password) throws Password{
	   int capital = 0;
	   int lowercase = 0;
	   int number = 0;
	   int a=0;
	   String characters = "~!@#$%^&*()-_=+[]{}|;:,.<>/?";
    for(int i = 0;i < password.length();i++) {
    	if(password.charAt(i) >= '0' && password.charAt(i) <= '9') {
    		number++;
    	}
    	if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
    		lowercase++;
    	}
    	if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z' ) {
    		capital++;
    	}
    }
    for(int i = 0; i<password.length();i++) {
    	for(int j = 0 ; j< characters.length();j++) {
    	   if(password.charAt(i) == characters.charAt(j)) {
    		   a++;
    	   }
    	}
    }
    if(password.length() < 8 || password.length() > 256) {
    	throw new Password("Password must be between 8 and 256 characters long");
    }
    if(capital == 0 || lowercase == 0 || number == 0 || a == 0) {
    	throw new Password("Password must contain at least 1 uppercase letter 1 lowercase letter and 1 number");
    }
    	return password;
   }
}