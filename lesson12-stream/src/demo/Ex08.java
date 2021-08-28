package demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import utils.ArrayUtils;
import utils.CollectionUtils;

public class Ex08 {
	public static void main(String[] args) {
		// source: List<E>
		List<Integer>  numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		Set<Integer> evenNumbers = numbers.stream()
								   .filter(num -> num % 2 == 0)
								   //.distinct() // Set, Map, HashTable >> hashCode, equal
								   .collect(Collectors.toSet());
		System.out.println("runtime class: " + evenNumbers.getClass().getSimpleName());
		CollectionUtils.printf(evenNumbers);
		
		// E[]
		int[] digits = {1, 2, 1, 3, 3, 2, 4};
		// Stream object: Stream<T>
		// Stream Primitive: IntStream, DoubleStream, LongStream
		// IntStream
		int[] evenNumbers1 = Arrays.stream(digits)
							.filter(digit -> digit % 2 == 0)
							.toArray();
		ArrayUtils.printf(evenNumbers1);		
		
		// 1. Select unique elements from input list of numbers
		// Print unique number in list
		// Convert int[] -> List<Integer>
		// Way 1: Counting appearance
		System.out.println("Way 1: Counting appearance");
		List<Integer> digitsList = Arrays.stream(digits).boxed().collect(Collectors.toList());
		List<Integer> uniqueNbrs = numbers.stream()
										.filter(nbr -> Collections.frequency(numbers, nbr) == 1)
										.collect(Collectors.toList());
		

		// Way 2: Using groupingBy
		// K: Check Element
		// V: amount of checked element
		System.out.println("Way 2: Using groupingby");
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
