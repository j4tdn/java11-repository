package exercise;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ex02RandomPass {
	public static String USERNAME = "admin";
	public static String PASSWORD = "247";
	
	public static void main(String[] args) {
		String[] data = new String[1000];
		Random rd = new Random();
		String text = null;
		int breakline = 0;
		int i = 0;
		do {
			text = "" + rd.nextInt(10) + rd.nextInt(10) + rd.nextInt(10); 
			
			if(contains(data, i, text )) {
				continue;
			}
			data[i++]= text;
			sleep(50);
			
			System.out.print(text + " ");
			if (breakline % 13 == 0) {
				System.out.println();
			} breakline++;
			
		}while(!login("admin", text));
		System.out.println("Login Successfully");
		System.out.println("USER: admin");
		System.out.println("Pass: " + text);
	}
	private static boolean contains(String[]data,int nonNullSize, String text) {
		for (int i = 0; i < nonNullSize ; i++) {
			if (data[i].equals(text)) {
				return true;
			}
		}
		return false;
	}
	private static void sleep(int millis) {
		try {
			TimeUnit.MILLISECONDS.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static boolean login(String IPUN, String IPPW) {
		return IPUN.equals(USERNAME) && IPPW.equals(PASSWORD);
	}
}	 
