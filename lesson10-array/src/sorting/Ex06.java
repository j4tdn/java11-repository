package sorting;

import java.util.Arrays;
import java.util.Comparator;

import utils.ArrayUtils;

public class Ex06 {
	public static void main(String[] args) {
		String[] sequences = { "a", null, "d", "c", "b", null, "e"};

		// Not handle null elements
		// Arrays.sort(sequences); >> Comparable

		Arrays.sort(sequences, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// ascending: o1(left) o2(right) of pivot
				// o1: previous
				// o2: next
				// o1 X o2
				// compare(o1, o2) = X as below
				// positive: o1 > o2 (default)
				// zero	   : o1 == o2
				// negative: o1 < o2

				// null first
				if(o1 == null) {
					return -1; // o1 > o2 swap(o1,o2)
				}
				// o1 != null
				if(o2 == null) {
					return 1; // o2 < o1
				}

				// ascending
				return o1.compareTo(o2);
			}
		});

		ArrayUtils.printf(sequences);
	}

}
