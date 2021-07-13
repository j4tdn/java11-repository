package ex02;

import utils.Utils;

public class Ex02 {
    public static void main(String[] args) {
    	int[][] digits = { 
				{ 1, 2, 3, 4 }, 
				{ 5, 0, 8, 7 }, 
				{ 1, 9, 0, 9 }, 
				{ 2, 0, 6, 5 }, 
				{ 1, 2, 4, 5 } 
				};
    
    	Utils.printf(changeToZero(digits));
		
	}
    
	private static int[][] changeToZero(int[][] digits) {
		int c = 0;
		int d = 0;
		for (int k = 0; k < digits.length; k++) {
			for (int i = 0; i < digits[k].length; i++) {
				if (digits[k][i] == 0) {
					d++;
				}
			}
		}
		int[] values = new int[d];
		for (int k = 0; k < digits.length; k++) {
			for (int i = 0; i < digits[k].length; i++) {
				if (digits[k][i] == 0) {
					values[c++] = i;
				}
			}
		}
		for (int k = 0; k < digits.length; k++) {
			for (int i = 0; i < digits[k].length; i++) {
				if (digits[k][i] == 0) {
					for (int j = 0; j < digits[k].length; j++) {
						digits[k][j] = 0;
					}
				}
			}
		}
		for (int s : values) {
			for (int j = 0; j < digits.length; j++) {
				digits[j][s] = 0;
			}
		}
		return digits;
	}
}
