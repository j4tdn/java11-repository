package bt02;

public class Bt02 {
	public static void main(String[] args) {
		int[][] num = { { 1, 2, 3, 9 }
					, { 1, 9, 7, 8 }
					, { 1, 9, 9, 9 }
					, { 2, 0, 9, 5 }
					, { 1, 2, 4, 9 } };
		
		boolean check = false;
		for (int row = 0; row < num.length; row++) {
			for (int col = 0; col < num[row].length; col++) {
				// Check element = 0 and assign value 0 for element same row and column
				if (num[row][col] == 0) {
					check = true;
					for (int i = 0; i < num.length; i++) {
						num[i][col] = 0;
					}
					for (int j = 0; j < num[row].length; j++) {
						num[row][j] = 0;
					}
				}
				if (check) {
					break;
				}
			}
			if (check) {
				break;
			}
		}
		
		// Print value Result array
		System.out.println("Result array:");
		for (int row = 0; row < num.length; row++) {
			for (int col = 0; col < num[row].length; col++) {
				System.out.print(num[row][col] + " ");
			}
			System.out.println(); // break line
		}
	}
}
