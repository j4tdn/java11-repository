package sorting;

import java.util.Comparator;
import java.util.Arrays;
import utils.ArrayUtils;
import static java.util.Comparator.*;
public class Ex061 {
public static void main(String[] args) {
	String[] sequences = { "a", null, "d", "c", "b", null, "e" };
	
	// lambda expression: instance of functional interface
	Comparator<String> precomparator = (s1, s2) -> s1.compareTo(s2);
	
	
	// Function<T, R> >> keyExtractor >> abstract method >> R apply(T t);
//body
	// (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2))
	
	// available method similar to "(s1, s2) -> s1.compareTo(s2)"
	Comparator<String> comparator = nullsLast(comparing(s->s, reverseOrder()));
	Arrays.sort(sequences, comparator);
	ArrayUtils.printf(sequences);
}
}
