package sorting;

import java.util.Arrays;
import java.util.Comparator;

import utils.ArrayUtils;

public class Ex06 {
	public static void main(String[] args) {
		String[] sequences = { "a", null, "c", "d", "b", null, "e"};
		
		// Not handle null elements
		// Arrays.sort(sequences); >> Comparable
		
		Arrays.sort(sequences, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// ascending: o1(left) o2(right) of pivot
				// o1: previous
				// o2: next
				// compare > 0 ==> swap
				
				// a null b null c d
				
				// null first
				if (o1 == null && o2 != null) {
					return -1; // no swap (o1, o2)
				}
				
				if (o2 == null) {
					return 1; // swap (o1, o2)
				}

				// descending
				return o2.compareTo(o1);
			}
		});
		
		ArrayUtils.printf(sequences);
	}
}
