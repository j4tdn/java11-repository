package sorting;

import static java.util.Comparator.*;
import static java.util.function.Function.*;

import java.util.Arrays;
import java.util.Comparator;

import Utils.ArraysUtils;

public class Ex08 {
	public static <R> void main(String[] args) {
		String[] sequences = { "A", null, "b", "D", "a", null, "B" };
		Comparator<String> comparator = nullsLast(comparing(identity(), reverseOrder()));
		Arrays.sort(sequences, comparator);
		ArraysUtils.printf(sequences);
	}
}
