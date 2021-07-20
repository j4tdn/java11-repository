package sorting;

import untils.ArrayUtils;

public class Ex02 {
	public static void main(String[] args) {
		String[] sequences = { "a", "B", "c", null, null, "C", "B", null, "2", "0", "1" };
		for (int i = 0; i < sequences.length; i++) {
			for (int j = 0; j < sequences.length - i - 1; j++) {
				// last null
//				if (sequences[j] == null) {
//					swap(sequences, j, j + 1);
//					continue;
//				}
//
//				if (sequences[j + 1] == null) {
//					continue;
//				}

				// first null
				if (sequences[j] == null) {
					continue;
				}

				if (sequences[j + 1] == null && sequences[j] != null) {
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

	private static void swap(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
