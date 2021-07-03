package declaration;

import bean.Dimension;

public class Ex03 {
	public static void main(String[] args) {
		// 1D
		int[] x = { 1, 5, 8 };
		System.out.println("x length: " + x.length);
		// length = 3
		// x[0] = 3

		// 2D (row, column)
		int[][] y = new int[4][3];
		System.out.println("y length: " + y.length);
		System.out.println("y column length " + y[0].length);

		int[][] w = { { 1, 2, 7, 8 }, { 2, 3, 4, 1 }, { 4, 6, 5, 1 } };
		System.out.println("w length: " + w.length);
		System.out.println("w column length: " + w[0].length);

		System.out.println("w's class: " + w.getClass());

		for (int row = 0; row < w.length; row++) {
			for (int col = 0; col < w[row].length; col++) {
				System.out.print(w[row][col] + " ");
			}
			System.out.println(); // break line
		}

//		int[][] w = { { 1, 2, 7, 8 }, { 2, 3, 4, 1 }, { 4, 6, 5, 1 } };
		Dimension[] dims = { new Dimension(1, 2, 7, 8), new Dimension(2, 3, 4, 1), new Dimension(4, 6, 5, 1) };
		for (Dimension dim : dims) {
			System.out.println(dim);
		}

		// 3D (x,y,z)
		int[][][] dims3d = {
				{ { 1, 2, 7, 8 }, { 2, 3, 4, 1 }, { 4, 6, 5, 1 }, { 1, 2, 7, 8 }, { 2, 3, 4, 1 }, { 4, 6, 5, 1 },
						{ 1, 2, 7, 8 }, { 2, 3, 4, 1 }, { 4, 6, 5, 1 } },
				{ { 1, 2, 7, 8 }, { 2, 3, 4, 1 }, { 4, 6, 5, 1 }, { 1, 2, 7, 8 }, { 2, 3, 4, 1 }, { 4, 6, 5, 1 },
						{ 1, 2, 7, 8 }, { 2, 3, 4, 1 }, { 4, 6, 5, 1 } } };

	}
}