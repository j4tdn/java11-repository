package declaration;

import bean.Dimension;

public class Ex03 {
	// multiple dimensions array
	public static void main(String[] args) {
		// 1D
		int[] a = {3, 6, 2, 26};
		System.out.println("a length: " + a.length);
		// length = 4
		// x[0] = 3;
		
		// 2D(x, y)
		int[][] b = new int[2][3];
		System.out.println("b length: " + b.length);
		System.out.println("b column length: " + b[0].length);
		// row 0 r0c0 r0c1 r0c2
		// row 1 r1c0 r1c1 r1c2
		
		int[][] t = { {3,5,7,8}, {1,5,7,3}, {4,9,3,6}};
		System.out.println("t length: " + t.length);
		System.out.println("t column length: " + t[0].length);
		
		System.out.println("t's class: " + t.getClass());
		
		for(int row = 0; row < t.length; row++) {
			for(int col = 0; col < t[row].length; col++) {
				System.out.print(t[row][col] + " ");
			}
			System.out.println(); // break line
		}
		
		// int[][] t = { {3,5,7,8}, {1,5,7,3}, {4,9,3,6}};
		Dimension[] dims = {new Dimension(3,5,7,8), new Dimension(1,5,7,3), new Dimension(4,9,3,6)};
		for (Dimension dim: dims) {
			System.out.println(dim);
		}
		
		// 3D (x, y, z)
		int[][][] w = { {{1,2}},{{3,4}},{{5,6}} };
		
		
	}
}
