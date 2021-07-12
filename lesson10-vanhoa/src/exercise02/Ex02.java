package exercise02;

import java.util.Arrays;

import utils.ArrayUtils;

public class Ex02 {
	public static void main(String[] args) {
		int[][] matrix = { {1, 2, 3, 4}, 
						   {5, 6, 8, 7}, 
						   {1, 9, 0, 9}, 
						   {2, 6, 3, 7}, 
						   {3, 6, 3, 7} };
		for (int[] i : matrix) {
			ArrayUtils.printf(i);
		}
		System.out.println("============ transform ==============");
		int[][] booms = zeroTransform(matrix);
		for (int[] boom : booms) {
			ArrayUtils.printf(boom);
		}
		
		System.out.println();
		int[][] a = { {1, 2, 3, 4}, 
				      {5, 0, 8, 7}, 
				      {1, 9, 0, 9}, 
				      {2, 0, 3, 7}, 
				      {3, 6, 3, 7} };
		for (int[] i : a) {
			ArrayUtils.printf(i);
		}
		System.out.println("============ transform ==============");

		
	}
	
	private static int[][] zeroTransform(int[][] matrix){
		int[][] result = Arrays.copyOfRange(matrix, 0, matrix.length);
		int col = 0;
		int row = 0;
		
		// find zero
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == 0) {
					row = i;
					col = j;
					break;
				}
			}
		}
		// boom
		for(int i = 0; i < matrix.length; i++) {
			result[i][col] = 0;
		}
		for(int i = 0; i < matrix[row].length; i++) {
			result[row][i] = 0;
		}
		
		return result;
	}
//	private static int[][] matrixTransform(int[][] matrix){
//		int[][] result = Arrays.copyOfRange(matrix, 0, matrix.length);
//		
//		for(int i = 0; i < matrix.length - 2; i++) {
//			for(int j = 0; j < matrix[i].length; j++) {
//				if(matrix[i][j] == 0) {
//					for(int row = 0; row < matrix[i].length; row++) {
//						result[i][row] = 0;
//					}
//					for(int col = 0; col < matrix.length; col++) {
//						result[col][j] = 0;
//					}
//				}
//			}
//		}
//		
//		
//		return result;
//	}
}
