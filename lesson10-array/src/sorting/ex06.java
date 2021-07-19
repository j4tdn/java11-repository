package sorting;

import java.util.Arrays;
import java.util.Comparator;

import utils.ArrayUtils;

public class ex06 {
	public static void main(String[] args) {
		String[] sequences = {"a","d","null","c","b","null","e"};
		//		Arrays.sort(sequences);

		Arrays.sort(sequences, new Comparator<String>() {
			//compare > 0 => swap
			public int compare(String o1, String o2) {
				if (o1 == null && o2 != null) {
					return 1; // o1 > o2
				}
				
				if (o2 == null) {
					return -1; // o1 < 02
				}
				
				return o1.compareTo(o2);
			}
		});
		
		ArrayUtils.printf(sequences);
	}
}
