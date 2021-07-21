package sorting;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.*;
import java.util.function.Function;
import static java.util.function.Function.*;
import utils.ArrayUtils;

public class Ex061 {
	public static void main(String[] args) {
		String[] sequences = { "a", null, "d", "c", "b", null, "e" };

		// lambda expression: instance of functional interface
		Comparator<String> precomparator = (s1, s2) -> s1.compareTo(s2);

		// Function<T, R> >> keyExtractor >> abstract method >> R apply(T t);
		// body
		// (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2))

		// available method similar to "(s1, s2) -> s1.compareTo(s2)"
		Comparator<String> test = Comparator.comparing(new Function<String, String>(){
			@Override
			public String apply(String t) {
				return t;
			}
			
		});
		
		Comparator<String> test1 = comparing(s -> s);
		
		Comparator<String> test2 = comparing(s -> s, reverseOrder());
		
		Comparator<String> test3 = comparing(Function.identity(), reverseOrder());
		
		Function<String, String> f1 = s -> s;
		
		Function<String, String> f2 = Function.identity();
		
		Function<String, String> f3 = identity();
		
		Comparator<String> comparator = nullsLast(comparing(identity(), reverseOrder()));
		
		ArrayUtils.printf(sequences);
	}

}
