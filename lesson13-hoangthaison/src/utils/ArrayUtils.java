package utils;

public class ArrayUtils {
	public static void printfArrays(int[][] arrs) {
		
		for(int i = 0; i< arrs.length;i++) {
			for(int j = 0; j <arrs[i].length;j++) {
				System.out.print(arrs[i][j] + " ");
			}
			System.out.println();
		}
	}

}
