package sorting;

import java.util.Arrays;
import java.util.Comparator;

import utils.ArrayUtils;

public class Ex06 {
	public static void main(String[] args) {
		String[] sequences = { "a", null, null, "d", "c", "e", "b" };

		// not handle null elements
		// Arrays.sort(sequences);

		Arrays.sort(sequences, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// ascending: o1(left) o2(right) of pivot
				// o1: previous
				// o2: next
				// compare(o1, o2) == X as below
				// positive : o1 > o2
				// zero 	: o1 == o2
				// negative	: o1 < o2
				
				// null last
				if (o1 == null && o2 != null) {
					return 1; // o1 > o2 swawp(o1, o2)
				}
				
				if(o2 == null) {
					return -1; // o2 < o1
				}
				// ascending
				return o1.compareTo(o2);
			}
		});

		ArrayUtils.printf(sequences);

	}
}
