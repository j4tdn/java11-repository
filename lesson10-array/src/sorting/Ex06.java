package sorting;

import java.util.Arrays;
import java.util.Comparator;

import utils.ArrayUtils;

public class Ex06 {
	public static void main(String[] args) {
		String[] sequences = {"a", null, "d", "c", "b", null, "e"};
		//Arrays.sort(sequences);
		Arrays.sort(sequences, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				//ascending o1(left) o2(right) of pivot
				//o1: previous
				//o2: next 
				//compare > 0 ==> swap
				if (o1 == null && o2 != null) {
					return 1; // -1 -> descending 
				}
				if (o2 == null) {
					return -1; // 1 -> descending
				}
				// ascending
				return o1.compareTo(o2);
			}
		});
		
		ArrayUtils.printf(sequences);
	}
}
