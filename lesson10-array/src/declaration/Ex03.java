package declaration;

import bean.Dimension;

public class Ex03 {
 // multiple dimensions array
	public static void main(String[] args) {
		//1D
		int[] x = {1, 4, 5};
		//lenth = 3
		// x[0]  = 1;
		
		int [][] y = new int[4][3];
		System.out.println("y colums length: "+ y[0].length);
		System.out.println("y length: "+ y.length);
		
		
		int [][] w = {{1,2},{4,5}, {4,6}};
		System.out.println("w length" + w.length);
		
		System.out.println("w's class" + w.getClass());
		
		for(int row = 0; row < w.length; row++) {
			for(int col = 0; col < w[row].length; col++) {
				System.out.print(w[row][col]+ " ");
			}
			System.out.println();
		
		}
		Dimension[] dims = {new Dimension(1,3,5,6),new Dimension(4,5,5,3), new Dimension(3,3,56,6)};
		for(Dimension dim : dims) {
			System.out.println(dim);
		}
	}
}
