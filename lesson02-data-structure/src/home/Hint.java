package home;

import java.util.Random;

public class Hint {
	private static final String username = "admin";
	private static final String password = "259";
	private static Random rd = new Random();
	
	public static void main(String[] args) {
		int breakLine = 1;
		String text = null;
		do {
			text = "" + rd.nextInt(10) + rd.nextInt(10) + rd.nextInt(10);
			breakLine ++;
			if (breakLine % 13 == 0) {
				System.out.println();
			}
			System.out.print(text + "  ");
		} while(!signIn("admin", text));
		
		System.out.println("\n=== Sign In successfully ===");
		System.out.println("Username: admin");
		System.out.println("Password: " + text);
	}
	
	// ==: compare variables in stack (object type)
	// ==: compare value (primitive type)
	private static boolean signIn(String ipUsername, String ipPassword) {
		return ipUsername.equals(username)  && ipPassword.equals(password);
	}
	
}
