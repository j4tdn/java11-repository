package manipulation;

import utils.ArrayUtils;

public class Ex02 {
	public static void main(String[] args) {
		int[] digits = {1, 2, 3, 4, 5, 6};
		
		reverse(digits);
		ArrayUtils.printf(digits);
	}
	
	private static void reverse (int[] origin){
		
		for(int i = 0; i < origin.length / 2; i++) {
			int tmp = origin[i];
			origin[i] = origin[origin.length - i - 1];
			origin[origin.length - i - 1] = tmp;
		}
	}
}
