package homework;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ex02 {
	private static final String SYSTEM_USERNAME = "admin";
	private static final String SYSTEM_PASSWORD = "259";

	private static final Random rd = new Random();

	public static void main(String[] args) {
		String username = "admin";
		String password = null;
		int noe = 1;
		int i = 0;
		String[] wp = new String[1000];// 1000 null elements
		do {

			password = "" + rd.nextInt(10) + rd.nextInt(10) + rd.nextInt(10);

			if (contain(wp, password, i)) {
				continue;
			}

			// put unique element into array
			wp[i++] = password;
			// require: max 1000 unique elements
			sleep(10);
			System.out.print(password + " ");
			if (noe % 13 == 0) {
				System.out.println();
			}
			noe++;

		} while (!logIn(username, password));

		System.out.println("==========LogIn Successsful !!!");
		System.out.println("Username: " + username);
		System.out.println("Password " + password);

		System.out.println("Noe: " + noe);
	}

	/**
	 * 
	 * @param wp       spaces
	 * @param password give password
	 * @return
	 */
	private static boolean contain(String[] wp, String password, int nonNullSizes) {
		// null.equals("text") => NPE
		// "text".equals(null); => false
		for (int i = 0; i < nonNullSizes; i++) {
			if (password.equals(wp[i])) {
				return true;
			}
		}
		return false;
	}

	private static boolean logIn(String username, String password) {
		return username.equals(SYSTEM_USERNAME) && password.equals(SYSTEM_PASSWORD);
	}

	private static void sleep(int timeout) {
		try {
			TimeUnit.MILLISECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
