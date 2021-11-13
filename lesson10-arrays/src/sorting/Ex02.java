package sorting;

import java.util.Comparator;

import Utils.ArraysUtils;

public class Ex02 {
	public static void main(String[] args) {
		String[] sequences = { "A", null, "b", "D", "a", null, "B" };

		Comparator<String> comparetor = new Comparator<String>() {

			@Override
			public int compare(String pre, String next) {
				// ascending

				if (pre == null) {
					return 1;
				}
				if (next == null) {
					return -1;
				}
				return pre.compareTo(next);
			}
		};
		sort(sequences, comparetor);
		ArraysUtils.printf(sequences);
	}

	private static void sort(String[] sequences, Comparator<String> comparator) {
		for (int i = 0; i < sequences.length; i++) {
			for (int j = 0; j < sequences.length - i - 1; j++) {
				String pre = sequences[j];
				String next = sequences[j + 1];
				if (comparator.compare(pre, next) > 0) {
					String tmp = sequences[j];
					sequences[j] = sequences[j + 1];
					sequences[j + 1] = tmp;
				}
			}
		}
	}
}
