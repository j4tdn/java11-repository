package sorting;

import java.util.Arrays;
import java.util.Comparator;

import utils.ArrayUtils;

public class Ex06 {
	public static void main(String[] args) {
		String[] sequences = {"A", null, "b", "D", "a", null, "B"};
		
		
		// Arrays.sort(E[]) >> E implements Comparable<E>
		// Not handle in case of NULL values
		// Arrays.sort(sequences);
		
		Arrays.sort(sequences, new Comparator<String>() {

			@Override
			public int compare(String left, String right) {
				// left++ pivot
				// right-- pivot
				if (left == null) {
					return 1;
				}
				
				// left != null
				if(right == null) {
					return -1;
				}
				
				// left, right != null
				return left.compareTo(right);
			}
			
		});
		ArrayUtils.printf(sequences);
	}
}
