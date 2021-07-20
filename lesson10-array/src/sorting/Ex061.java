package sorting;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.*;
import static java.util.function.Function.*;

import untils.ArrayUtils;

public class Ex061 {
	public static void main(String[] args) {
		String[] sequences = { "a", null, "d", null, null, "c", "b", "e" };
//		String[] sequences = { "a", "d", "c", "b", "e" };
		
		// lambda expression: instance of functional interface
		Comparator<String> preComparator = (o1, o2) -> o1.compareTo(o2);
		
		// available method : 
		// Function<? super T, ? extends U> keyExtractor)
		Comparator<String> comparator = nullsFirst(comparing(identity(), Comparator.reverseOrder()));	
		Arrays.sort(sequences, comparator);
		
		ArrayUtils.printf(sequences);
	}
}
