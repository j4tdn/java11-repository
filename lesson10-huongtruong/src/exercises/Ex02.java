package exercises;

public class Ex02 
{
    public static void main( String[] args )
    {
    	int[][] matrix = {{4, 0, 1}, {3, 7, 1}, {4, 7, 9}};
    	transfer(matrix);
    
    }
    private static void transfer(int[][] matrix) {
    	int rowLength = matrix.length;
    	int colLength = matrix[0].length;
    	int[] row = new int[rowLength];
    	int[] col = new int[colLength];
    	for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				if(matrix[i][j] == 0) {
					row[i] = 1;
					col[j] = 1;
					
				}
			}
    	}
			for (int i = 0; i < rowLength; i++) {
				for (int j = 0; j < colLength; j++) {
					if(row[i] == 1 || col[j] == 1) {
						matrix[i][j] = 0;
					}
				}
			}
    	for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
    }
}