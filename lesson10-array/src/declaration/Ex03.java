package declaration;

import bean.Dimension;

public class Ex03 {
	// multiple dimensions
	public static void main(String[] args) {
		// 1D
		int[] x = { 1, 3, 8 };
		System.out.println("x length : " + x.length);
		// length : 3
		// x[0] : 1

		// 2D : (row, column)
		int[][] y = new int[4][3];
		System.out.println("y length : " + y.length);
		System.out.println("y[0][] length : " + y[0].length);
		// r0c0 r0c1 r0c2
		// r1c0 r1c1 r1c2
		// r2c0 r2c0 r2c2
		// r3c0 r3c1 r3c2

		// => y[0] => r0c0 r1c0 r2c0
		// => y[1] => r1c0 r1c1 r1c2
		// => y[2][1] = r2c1

		int[][] w = { { 1, 2, 7, 8 }, { 4, 5, 9, 8 }, { 6, 7, 2, 3 } };
		System.out.println("w length : " + w.length);
		System.out.println("w[0][] length : " + w[0].length);
		System.out.println("w's class : " + w[0].getClass());

		for (int row = 0; row < w.length; row++) {
			for (int col = 0; col < w[row].length; col++) {
				System.out.print(w[row][col] + " ");
			}
			System.out.println(); // break line
		}

		Dimension[] dims = {new Dimension(1, 2, 3, 7) , new Dimension(3, 7, 8, 5)};
		for(Dimension dim : dims) {
			System.out.print(dim + " ");
		}
		
		// 3D (x, y, z)

	}
}
