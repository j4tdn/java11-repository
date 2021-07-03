package declaration;

import bean.Dimenssion;

public class Ex03 {
	// multiple dimensions array
	public static void main(String[] args) {
		// 1D
		int[] x = { 1, 5, 8 };
		// length = 3;
		// x[0] = 1;

		// 2D (row, column)
		int[][] y = new int[4][3];
		System.out.println("y length: " + y.length);
		System.out.println("y column length: " + y[0].length);

		int[][] w = { { 1, 2, 3 }, { 4, 5, 3 } };
		System.out.println("w length: " + w.length);
		System.out.println("w column length: " + w[0].length);

		System.out.println("w's class: " + w.getClass());

		Dimenssion[] dims = { new Dimenssion(1, 2, 3), new Dimenssion(7, 8, 9) };

		// 3D (x, y, z)
		int[][][] z = { { { 1, 2, 3 }, { 1, 2, 3 } }, { { 5, 5, 3 }, { 6, 8, 3 } } };
	}

}
