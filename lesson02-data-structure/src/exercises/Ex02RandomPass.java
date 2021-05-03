package exercises;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ex02RandomPass {
	private static String USERNAME = "admin";
	private static String PASSWORD = "237";

	public static void main(String[] args) {
		String[] data = new String[1000];
		Random rd = new Random();
		String text = null;
		int breakLine = 1;
		int i = 0;
		do {
			text = "" + rd.nextInt(10) + rd.nextInt(10) + rd.nextInt(10);
			if(contains(data, i, text)) {
				continue;
			}
			data[i++] = text; // data[i] = text; i++;
			sleep(50);
			System.out.print(text + " ");
			if (breakLine % 13 == 0) {
				System.out.println();
			}
			breakLine++;
		} while (!login("admin", text));
		System.out.println("\n==== Login successfully!!! ====");
		System.out.println("USER: admin");
		System.out.println("PASS: " + text);
	}
	private static void sleep(int millis) {
		try {
			TimeUnit.MILLISECONDS.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static boolean contains(String[] data, int nonNullSize, String text) {
		for (int i = 0; i< nonNullSize; i++) {
			if (data[i].equals(text)) {
				return true;
			}
		}
		return false;
	}

	private static boolean login(String ipUN, String ipPW) {
		return ipUN.equals(USERNAME) && ipPW.equals(PASSWORD);
	}

}
