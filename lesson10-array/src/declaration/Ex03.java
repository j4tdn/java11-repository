package declaration;

import bean.Dimension;

public class Ex03 {
	// multi dimension array
	public static void main(String[] args) {
		//1D
		int[] x = {1, 2, 3};
		System.out.println("x lenght: " + x.length);
		
		//2D (row,column)
		int [][] y = new int[4][3];
		System.out.println("y lenght: " + y.length);
		System.out.println("y column lenght: " + y[0].length);
		
		int [][] w = { {1,2,7,8}, {4,5,9,8}, {6,7,2,3} };
		System.out.println("y lenght: " + w.length);
		System.out.println("y column lenght: " + w[0].length);
		System.out.println("w's class: " + w.getClass());
		
		for (int row = 0; row < w.length; row++) {
			for (int col = 0; col < w[row].length; col++) {
				System.out.print(w[row][col] + " ");
			}
			System.out.println();
		}
		
		Dimension[] dims = {new Dimension(1, 2, 7, 8), new Dimension(4, 5, 8, 9), new Dimension(6, 7, 2, 3)};
		for (Dimension dim : dims) {
			System.out.println(dim);
		}
		
		//3D(x,y,z)
		int[][][] t = { {{1,2}},{{3,4}},{{5,6}} };
	}
}
