package ex02;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 8, 7 }, { 1, 9, 0, 9 }, { 2, 9, 6, 5 }, { 1, 2, 4, 5 } };
		matrixTransform(matrix);
		print(matrix);
	}
	
	private static int[][] matrixTransform(int[][] matrix){
		int[][] result = new int[matrix.length][matrix.length];
			
		int row = 0;
		int col = 0;
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == 0) {
					row = i;
					col = j;
				}
			}
		}
		
		Arrays.fill(matrix[row], 0);
		
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(j == col) {
					matrix[i][j] = 0;
				}
			}
		}
		result = matrix;
		
		return result;
	}
	
	private static void print(int[][] arrays) {
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				System.out.print(arrays[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
}
