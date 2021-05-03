package input;

import java.util.Random;
public class bt7 {

	public static void main(String[] args) {
		String[] data = new String[5];
		Random rd = new Random();
		for(int i = 0 ; i < data.length;i++ ) {
			do {
				data[i] = ""  + (20 + rd.nextInt(10)) ;
			}while(contains(data, i,data[i]));
			System.out.print( data[i] + " " );
		}
	}

	private static boolean contains(String[] data, int notNULL, String text) {
		for(int i = 0 ; i < notNULL; i++ ) {
			if(data[i].equals(text)) 
				return true;
			}
		
		return false;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
