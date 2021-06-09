package exercies;

import java.util.Random;

public class Ex02RandomPass {
	private static String USERNAME = "admin";
	private static String Pass  = "024";
	public static void main(String[] args) {
		Random rd = new Random();
		String text = null;		
		String[] data = new String[1000];
		int i =0;
		do {
			text =""+rd.nextInt(10)+""+rd.nextInt(10)+""+rd.nextInt(10);
			if(contains(data, text,i)) {
				continue;
			}
			data[i++] = text;
			System.out.println(text + " ");

		}while(!login("admin",text));
		System.out.println("UserName: admin " );
		System.out.println("Pass: " +text);
	}
	
	private static boolean contains(String[] data, String text,int NonNullsize) {
		for(int i = 0; i < NonNullsize; i++) {
			if(data[i].equals(text))
				return true;
		}
		return false;
	}

	private static Boolean login(String User,String text) {
		if(User.equals(USERNAME) && text.equals(Pass));
		return false;	
	}

}

