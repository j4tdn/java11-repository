package ex05;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String s1 = ip.next();
		String s2 = ip.next();
		generalString(s1, s2);
	}
	
	private static void generalString(String s1, String s2) {
		int[][] f = new int[s1.length() + 1][s2.length() + 1];
		int length = 0;
		int end = 0;
		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					f[i][j] = f[i-1][j-1] + 1;
					if(f[i][j] > length) {
						length = f[i][j];
						end = i;
					}
				}
			}
		}
		System.out.println(length);
		String s = s1.substring(end - length, end);
		System.out.println(s);
	}
}
