package homework;

import java.util.Random;

import javax.naming.ldap.Rdn;

public class Ex07 {
	public static void main(String[] args) {
		int [] data = new int[5];
		Random rd = new Random();
		int i =0;
		while(i< data.length) {
			int ranNum = 20 + rd.nextInt(10);
			if (contains(data, i, ranNum)) {
				continue;	
			}
			data[i++] = ranNum;
			System.out.println(ranNum);
		}
		
	}
	
	private static boolean contains(int[]data, int noNull, int ranNum) {
		for(int i = 0; i< noNull; i++) {
			if (data[i] == ranNum ) {
				return true;
			}
		}
		return false;
	}
	
}
