package ex02;

public class App {
	public static void main(String[] args) {
		int[][] arr = {{1, 3, 4, 3},{3, 2, 0, 4},{2, 0, 8, 3},{2, 4, 2, 7}};
		output(del(arr));
	}
	
	private static int[][] del(int[][] arr) {
		Iszero[] iz = new Iszero[4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(arr[i][j]==0) {
					iz[i] = new Iszero(i,j);
				}
			}
		}
		for(Iszero z : iz) {
			if(z != null) {
				for(int i = 0; i < 4; i++) {
					for(int j = 0; j < 4; j++) {
						arr[z.getI()][j] = 0;
					}
					arr[i][z.getJ()] = 0;
					
				}
			}
		}
	
		return arr;
	}
	private static void output (int[][] arr) {
		int m, n;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
