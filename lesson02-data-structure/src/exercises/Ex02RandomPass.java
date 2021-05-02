package exercises;

import java.util.Random;

public class Ex02RandomPass {
	private static String USENAME = "admin";
	private static String PASSWORD = "237";

	public static void main(String[] args) {
		Random rd = new Random();
		String text = null;
		int i =0;
		String[] data = null;

		do {
			text = "" +rd.nextInt(10) +rd.nextInt(10)+rd.nextInt(10);

			if(contains(data, text, i)) {
				continue;
			}
			
		} while (!login("admin", text, i));
		System.out.println("Login succesfully");

	}

	private static boolean login(String ipAD, String ipPASS, int i) {
		if(ipAD.equals(USENAME) && ipPASS.equals(ipPASS)) {
			return true;
			
		}
		return false;
	}

	private static void sleep(int millis) {
		
	}
	private static boolean contains(String[] data, String text, int nonNunSize) {
		for (int i = 0; i < nonNunSize; i++) {
			if (data[i].equals(text)) {
				return true;
			}
		}

		return false;
	}

}
