package exercises;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ex02Random {
	private static String USERNAME = "admin";
	private static String PASSWORD = "237";
	
	
	
	public static void main(String[] args) {
		String[] data = new String[1000];
		Random rd = new Random();
		String text = null;
		int breakline = 1;
		int i = 0;
		
		do {
			text = "" + rd.nextInt(10) + rd.nextInt(10) + rd.nextInt(10);
			if(contains(data,i,text)) {
				continue;
			}
			data[i++] = text;	
			sleep(50);
			
			System.out.print(text + " ");	
			if(breakline % 12 ==0) {
				System.out.println();
			}
			breakline ++ ;
		}while(!login("admin",text));
		
		System.out.println("\n\nLogin Successfully !!!");
		System.out.println("USER : admin");
		System.out.println("PASSWORD : " + text);
	}
	
	private static boolean contains(String[] data, int notNULL, String text) {
		for(int i = 0 ; i < notNULL; i++ ) {
			if(data[i].equals(text)) {
				return true;
			}
		}
		return false;
	}

	private static boolean login(String ipUN, String ipPW) {
		return ipUN.equals(USERNAME) && ipPW.equals(PASSWORD);
	}
	private static void sleep(int milis) {
		try {
			TimeUnit.MILLISECONDS.sleep(milis);
			
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}