package sorting;

import static java.util.Comparator.comparing;
import static java.util.Comparator.nullsLast;
import static java.util.Comparator.reverseOrder;
import static java.util.function.Function.identity;

import java.util.Arrays;
import java.util.Comparator;

import Utils.ArraysUtils;

public class Ex07 {
	public static void main(String[] args) {
		String[] sequences = { "A", null, "b", "D", "a", null, "B" };
		Arrays.sort(sequences, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1 == null) {
					return -1;
				}
				if (o2 == null) {
					return 1;
				}
				return o1.compareTo(o2);
			}
		});
		Comparator<String> comparator = nullsLast(comparing(identity(), reverseOrder()));
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
