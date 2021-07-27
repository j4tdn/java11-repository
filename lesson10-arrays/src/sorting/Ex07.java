package sorting;

import static java.util.Comparator.*;
import static java.util.function.Function.*;

import java.util.Arrays;

import utils.ArrayUtils;

public class Ex07 {
	public static void main(String[] args) {
		String[] sequences = {"A", null, "b", "D", "a", null, "B"};
				
		Arrays.sort(sequences, nullsLast(comparing(identity(), reverseOrder())));	
		ArrayUtils.printf(sequences);
	}
}
