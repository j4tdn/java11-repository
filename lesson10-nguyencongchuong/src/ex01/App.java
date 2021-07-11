package ex01;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		int[] digits = {1,2,3,4,3,1};
		int[] kqs = rmDuplicates(digits);
		for(int kq: kqs) {
			System.out.print(kq + " ");
		}
		
	}
	
	private static int[] rmDuplicates(int[] digits){
		int[] result = new int[digits.length];
		boolean[] checks = new boolean[digits.length]; 
		Arrays.fill(checks, true);
		for(int i = 0; i < digits.length; i++) {
			for(int j = 0; j < digits.length; j++) {
				if(i != j && digits[i] == digits[j]) {
					checks[i] = false;
				}
			}
		}
		int lenght = 0;
		for(int i = 0; i < checks.length; i++) {
			if(checks[i]) {
				result[lenght++] = digits[i];
			}
		}
		
		return Arrays.copyOfRange(result, 0, lenght);
	}
}
