package declaration;

import bean.Dimension;

public class Ex03 {
	public static void main(String[] args) {
		int[] x = {1, 2, 3};
		System.out.println("x length: " + x.length);
		
		int[][] y = new int [4][3];
		System.out.println("y length: " + y.length);
		
		int[][] w = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println("w length: " + w.length);
		System.out.println("w column length: " + w[0].length);
		
	    System.out.println("w'class: " + w.getClass());
	    
	    for(int row = 0; row < w.length; row++) {
	    	for(int col = 0; col < w[row].length; col++) {
	    		System.out.print(w[row][col] + " ");
	    	}
	    	System.out.println();
	    }
	    Dimension[] dims = {new Dimension(1,2,3,4), new Dimension(1,2,3,4), new Dimension(1,2,3,4)};
	    for(Dimension dim:dims) {
	    	System.out.println(dim);
	    }
	    int[][][] z = {{{1,2}, {3, 4}}, {{5, 6}, {7, 8}}};
	}

}
