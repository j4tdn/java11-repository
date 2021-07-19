package sorting;

import java.util.Arrays;
import java.util.Comparator;

import utils.ArrayUtils;

public class Ex06 {
	public static void main(String[] args) {
		String[] sequences = { "a", null, "d", "c", "b", null, "e" };
		
		// Not handle null elements
		// Arrays.sort(sequences); >> Comparable
		
		Arrays.sort(sequences, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// ascending: o1(left) o2(right) of pivot
				// o1: previous
				// o2: next
				// compare > 0 ==> swap
				
				// null d b null c e
				
				// null first
				if (o1 == null) {
					return -1;
				}
				// o1 != null
				if (o2 == null) {
					return 1;
				}
				
				// descending
				return o2.compareTo(o1);
			}
		});

		ArrayUtils.printf(sequences);
	}

}
