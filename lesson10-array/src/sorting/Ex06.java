package sorting;

import java.util.Arrays;
import java.util.Comparator;

import utils.ArrayUtils;

public class Ex06 {
	public static void main(String[] args) {
		String[] sequences = { "a", "B", null, "c", "0", null, "2", "b", "1" };

		// Not handle null elements
		// Arrays.sort(sequences); >> Comparable
		
		Arrays.sort(sequences, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// o1: previous
				// o2: next
				// o1 X o2
				// compare(o1, o2) = X as below
				// positive: o1 > o2
				// zero    : o1 == o2
				// negative: o1 < o2
				
				// null first
				if(o1 == null) {
					return -1;
				}
				
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
