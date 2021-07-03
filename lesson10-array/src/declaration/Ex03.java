package declaration;

import bean.Dimension;

public class Ex03 {
	public static void main(String[] args) {
		//2D(row,col)
		int[][] y = new int[4][3];
		System.out.println("y length: " + y.length);
		System.out.println("y column length: " + y[0].length);

		int[][] w = {{1,2}, {3,5}, {5,8}};

		System.out.println("w length: " + w.length);
		System.out.println("w column length: " + w[0].length);

		for (int row = 0; row < w.length; row++) {
			for (int col = 0; col < w[row].length; col++) {
				System.out.print(w[row][col] + " ");
			}
			System.out.println(); //break line
		}

		Dimension[] dims = {new Dimension(1,2,7,8),
				new Dimension(5,2,0,8),
				new Dimension(1,4,7,6)
		};
		for (Dimension dim: dims) {
			System.out.println(dim);
		}
	}
}