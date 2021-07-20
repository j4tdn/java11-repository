package sorting;

import java.util.Arrays;
import java.util.Comparator;

import utils.ArrayUtils;

public class Ex06 {
	public static void main(String[] args) {
		String[] sequences = {"a", "d", null, "c", "b", null, "e" };
		// Not handle null element
		// Arrays.sort(sequence); >> Comparable
		
		Arrays.sort(sequences, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// ascending: o1(left) o2(right) of pivot
				// o1: previous
				// 02: next
				// o1 X o2
				// compare(o1, o2) = X
				// compare(o1, o2) = X as below
				// positive: o1 > o2 (default)
				// zero: o1 == o2
				// negative: o1 < o2
				
				// null first
				if (o1 == null && o2 != null) {
					return -1; // o1 > o2 swap(o1, o2)
				}
				if (o2 == null) {
					return 1; // o2 < o1 no swap 
				}
				// descending
				return o1.compareTo(o2);
			}
			
		});
		ArrayUtils.printf(sequences);
		
	}
}
