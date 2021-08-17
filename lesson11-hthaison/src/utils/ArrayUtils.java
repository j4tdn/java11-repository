package utils;

public class ArrayUtils {
	public ArrayUtils() {
		// TODO Auto-generated constructor stub
	}
	public static <T> void printfArray(T[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void printfArray(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i][j] == 0 ) {
					System.out.print("  ");
				}
				else {
					System.out.print(arr[i][j]+ " ");
					}
			}
			System.out.println();
		}
	}
}
