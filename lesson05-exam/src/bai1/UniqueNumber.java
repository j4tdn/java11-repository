package bai1;

import java.util.Arrays;

public class UniqueNumber {
	public static void main(String[] args) {
		int[] A = {3, 15, 21, 0, 15, 17, 21};
		System.out.println(getUniqueNumber(A));
	}
	
	private static int [] getUniqueNumber(int[] list) {
		
		Arrays.sort(list);

	    for (int i = 0; i < list.length; i++){
	    	if (i == i+1) {
	    	}
	    }
	        
	    
	    return list;
	}
}
