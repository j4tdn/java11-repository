package demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import bean.Dish;
import utils.ArrayUtils;
import utils.CollectionUtils;
import utils.DishUtils;

public class Ex08 {
	public static void main(String[] args) {
		// source: List<E>, E[]
		int[] digits = { 1, 2, 1, 3, 3, 2, 4, 5, 4, 7 };

		// Stream Object; Stream<T>
		// Stream Primitive: IntStream, DoubleStream, LongStream
		// IntStream
		int[] evenNubmers = Arrays.stream(digits).filter(digit -> digit % 2 == 0).distinct().toArray();

		ArrayUtils.prinf(evenNubmers);

		System.out.println("========================== ");

		/*
		 * List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		 * 
		 * Set<Integer> evenNubmers = numbers.stream() .filter(number -> number % 2 ==
		 * 0) //.distinct() // Set, Map, HashTable >> hash code, equals
		 * .collect(Collectors.toSet());
		 * 
		 * CollectionUtils.printf(evenNubmers); System.out.println("runtime class: " +
		 * evenNubmers.getClass().getSimpleName());
		 */

		// Idea one
		System.out.println("========================");
		// Stream<T> --> collect(Collectors.toList()) = List<T>
		// IntStream -->
		// IntStream --> Stream<Integer> --> collect

		// convert int[] -> List<Integer>
		List<Integer> numbers = Arrays.stream(digits).boxed().collect(Collectors.toList());

		List<Integer> uniqueNumber = numbers.stream().filter(nbr -> Collections.frequency(numbers, nbr) == 1) // IntStream
				.collect(Collectors.toList());
		CollectionUtils.printf(uniqueNumber);
		
		// Idea Two
		// Key: Checked Element
		// Value: amount of checked element
		System.out.println("========================");
		numbers.stream()
  			   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
  			   .entrySet()	// Set<Entry<Integer, Long>>
  			   .stream()	// Stream<Entry<Integer, Long>>
  			   .filter(entry -> entry.getValue() == 1)
  			   .map(Entry::getKey) // Stream<Integer>
  			   .collect(Collectors.toList()) // List<Integer>
  			   .forEach(System.out::println);
		
	}

}