package sorting;

import utils.ArrayUtils;

public class Ex02 {
	public static void main(String[] args) {
		String[] sequences = { "a", null, "B", "c", null, "0", "2", null, "b", null, "1" };

		// bubble sort
		// null first, null last
		for (int i = sequences.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				// null first
//				if(sequences[j] == null && sequences[j+1] != null) {
//					swap(sequences, j, j + 1);
//					continue;
//				}
//				if(sequences[j+1] == null) {
//					continue;
//				}
//				
				if (sequences[j] == null && sequences[j + 1] != null) {
					continue;
				}
				if (sequences[j + 1] == null) {
					swap(sequences, j, j + 1);
					continue;
				}
				if (sequences[j].compareTo(sequences[j + 1]) > 0) {
					swap(sequences, j, j + 1);
				}
			}
		}
		ArrayUtils.printf(sequences);
	}

	public static void swap(String[] str, int i, int j) {
		String tmp = str[i];
		str[i] = str[j];
		str[j] = tmp;
	}

}
