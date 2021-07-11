package ex02;

public class App {
	public static void main(String[] args) {
		
		int[][] arr = {{1,2,3,4},{5,0,8,7},{1,9,0,9},{2,0,6,5},{1,2,4,5}};
		boolean[] markCol = new boolean[arr[0].length];
		boolean[] markRow = new boolean[arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					markRow[i] = true;
					markCol[j] = true;
				}
			}
		}
		
		for (int i = 0; i < markRow.length; i++) {
			for (int j = 0; j < markCol.length; j++) {
				if ((markRow[i] == true) || (markCol[j] == true)) {
					arr[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}		
			System.out.print("\n");
		}
	}
}
