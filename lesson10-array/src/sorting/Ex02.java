package sorting;

import utils.ArrayUtils;

public class Ex02 {
	public static void main(String[] args) {
		String[] sequences = { "a", null, "B", "c", null, "0", "2", "b", null, "1" };

		// bubble sort
		// null first, null last
		for (int i = 0; i < sequences.length; i++) {
			for (int j = 0; j < sequences.length - i - 1; j++) {
				// null last
				/*
				 * if(sequences[j]==null&& sequences[j+1]!=null) { swap(sequences, j, j + 1);
				 * continue; }
				 * 
				 * if(sequences[j+1]==null) { continue; }
				 */

				if (sequences[j] == null && sequences[j + 1] != null) {
					continue;
				}
				if (sequences[j + 1] == null) {
					swap(sequences, j, j + 1);
					continue;
				}

				if (sequences[j].compareToIgnoreCase(sequences[j + 1]) > 0) {
					swap(sequences, j, j + 1);

				}
			}
		}

		ArrayUtils.printf(sequences);
	}

	private static void swap(String[] a, int i, int j) {
		String tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
