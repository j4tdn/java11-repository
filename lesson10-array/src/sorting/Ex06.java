package sorting;

import java.util.Arrays;
import java.util.Comparator;

import untils.ArrayUtils;

public class Ex06 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sequences = { "a", null, "d", null, null, "c", "b", "e" };
		Arrays.sort(sequences, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// o1 : previous
				// o2 : next
				// compare(o1, o2) = X as below
				// positive : o1 > o2
				// zero : o1 == o2
				// negative : o1 < o2
				if (o1 == null && o2 != null) {
					return 1;
				}
				if (o2 == null) {
					return -1;
				}
				return o1.compareTo(o2);
			}
		});
		ArrayUtils.printf(sequences);
	}
}
