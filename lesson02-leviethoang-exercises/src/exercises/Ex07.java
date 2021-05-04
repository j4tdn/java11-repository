package exercises;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ex07 {
	// Random 5 different numbers from 20 -> 30
	
	public static void main(String[] args) {
		String[] data = new String[1000];
		Random rd = new Random();
		String text = null;
		int i = 0 , count = 0;
		
		do {
			text = "" +(20 + rd.nextInt(10)) ;
			if(contains(data,i,text)) {
				continue;
			}
			data[i++] = text;	
			sleep(50);		
			count ++;
			System.out.print(text + " ");	
		}while(count < 5);
	}
	
	private static void sleep(int milis) {
		try {
			TimeUnit.MILLISECONDS.sleep(milis);
			
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean contains(String[] data, int notNULL, String text) {
		for(int i = 0 ; i < notNULL; i++ ) {
			if(data[i].equals(text)) {
				return true;
			}
		}
		return false;
	}
}
