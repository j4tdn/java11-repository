package sorting;

import java.util.Arrays;
import java.util.Comparator;

import utils.ArrayUtils;

public class Ex06 {
	public static void main(String[] args) {
		String[] sequences = { "a", null, "xx", "d", "c", "9", "b", "7", "e" , null};

//		Not handle elements
//		Arrays.sort(sequences); >>COmparable

		Arrays.sort(sequences, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				if (o1 == null && o2 != null) {
					return -1;
				}

				if (o2 == null) {
					return 1;
				}

				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});

		ArrayUtils.printf(sequences);

	}

}
