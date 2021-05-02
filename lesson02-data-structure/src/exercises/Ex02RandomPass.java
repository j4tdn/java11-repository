package exercises;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ex02RandomPass {
	private static String USERNAME = "admin";
	private static String PASSWORD = "237";

	public static void main(String[] args) {
		Random rd = new Random();
		String text = null;
		String[] list = new String[1000];
		int breakLine = 0;
		int i = 0;
		int count;
		do {
			text = "" + rd.nextInt(10) + rd.nextInt(10) + rd.nextInt(10);
			if (check(list, text, i)) {
				continue;
			}
			sleep(10);
			list[i++] = text;
			breakLine++;
			System.out.print(text + " ");
			if (breakLine % 13 == 0) {
				System.out.println("");
			}
		} while (!login("admin", text));
		System.out.println("\nLogin successfully !!");
		System.out.println("User: admin");
		System.out.println("Password: " + text);
	}

	private static void sleep(int millis) {
		try {
			TimeUnit.MILLISECONDS.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean check(String[] list, String text, int notnull) {
		for (int i = 0; i < notnull; i++) {
			if (text.equals(list[i]))
				return true;
		}
		return false;
	}

	private static boolean login(String string, String text) {
		if (string.equals(USERNAME) && text.equals(PASSWORD))
			return true;
		return false;
	}

}
