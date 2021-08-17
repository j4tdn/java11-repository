package ex01;

import utils.ArrayUtils;

public class App {
	public static <T> void main(String[] args) {
		int n = 3;
			

		ArrayUtils.printfArray(output(n));
	}
	private static int[][] output(int n){
		int len = 2*n - 1;
		int [][]A = new int[len][len];
		for(int i = 0; i < n; i++) {
			for(int j = i; j < len - i; j++) {
				A[j][i] = i+1;
			}
		}
		for(int i = n; i < len; i++) {
			for(int j = len - i - 1; j < i +1; j++) {
				A[j][i] = i+1;
			}
		}
		return A;
	}

}
