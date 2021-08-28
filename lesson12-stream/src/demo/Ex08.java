package demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import utils.ArrayUtils;
import utils.CollectionUtils;

public class Ex08 {
	public static void main(String[] args) {
		// source: List<E>, E[]
		int [] digits = {1,2,1,3,7,3,2,4};
		
		// Stream Object: Stream<T>
		// Stream Primitive: IntStream, DoubleStream, LongStream
		
		// IntStream
		int[] evenNumbers = Arrays.stream(digits)
							    .filter(digit -> digit % 2 == 0)
							    .distinct()
							    .toArray();
		ArrayUtils.printf(evenNumbers);
		
		/*List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
		
		Set<Integer> evenNumbers = numbers.stream()
				   						   .filter(nbr -> nbr %2 == 0)
				   						   //.distinct() // Set, Map, HashTable >> hashcode, equal
				   						   .collect(Collectors.toSet());
		
		System.out.println(evenNumbers.getClass().getSimpleName());
		CollectionUtils.printf(evenNumbers);*/
		
		System.out.println("===============");
		
		// Stream<T> --> collect(Collectors.toList()) = List<T>
		// IntStream -->         X                    = List<Int> 
		// IntStream --> Stream<Integer> --> collect
		
		// convert int[] -> List<Ingeger>
		List<Integer> numbers = Arrays.stream(digits).boxed().collect(Collectors.toList());
		
		List<Integer> uniqueNbr =  numbers.stream()
			  .filter(nbr -> Collections.frequency(numbers, nbr) == 1) // Stream<Integer>
			  .collect(Collectors.toList());
		
		CollectionUtils.printf(uniqueNbr);
		
		System.out.println("================");
		
		// K: Checked Element
		// V: amount of checked element
		numbers.stream()
		       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		       .entrySet() // Set<Entry<Integer, Long>>
		       .stream()   // Stream<Entry<Integer, Long>>
		       .filter(entry -> entry.getValue() == 1)
		       .map(Entry::getKey) // Stream<Integer>
		       .collect(Collectors.toList()) // List<Integer>
		       .forEach(System.out::println);
	}
}
