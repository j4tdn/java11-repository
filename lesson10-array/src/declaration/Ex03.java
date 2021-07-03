package declaration;

import bean.Dimension;

public class Ex03 {
// multiple dimensions array
	public static void main(String[] args) {
		// 1D
		int[] x = {1, 5, 8};
		//length = 3
		// x[0] = 1;
		
		// 2D (row,column)
		int[][] y = new int[2][3];
		// r0c0 r0c1 r0c2
		// r1c0 r1c1 r1c2
		// r2c0 r2c1 r2c2
		// r3c0 r3c1 r3c2
		
		// => y[0] => r0c0 r0c1 r0c2
		// => y[1] => r1c0 r1c1 r1c2
		// => y[2][1]=> r2c1
		int[][] w = {{1,2},{4,5},{6,7}};
		System.out.println("w length: " + w.length);
		
		System.out.println("w's class: " + w.getClass());
		for(int row = 0; row < w.length; row++) {
			for(int col = 0; col < w[row][col];col++) {
				System.out.println(w[row][col] + " ");
			}
			System.out.println(); // break line
		}
		// int[][] w = {{1,2,7,8},{4.5.9.8},{6,7,2,3}};
		Dimension[] dims = {new Dimension(1,2,7,8),new Dimension(4,5,9,8),new Dimension(6,7,2,3)};
		for(Dimension dim: dims) {
			System.out.println(dim);
		}
		
		// 3D(x,y,z)
		int[][][] z = {{{1,2},{3,4},{5,6},{7,8}}};
	}
}
