package demo;

import java.util.Arrays;

import utils.ArrayUtils;

public class Ex08 {
	public static void main(String[] args) {
		// source: List<E>, E[]
		int[] digits = {1, 2, 1, 3, 3, 2, 4};
		
		// Stream Object: Stream<T>
		// Stream Primitive: IntStream, Double Stream, Long Stream
		
		// IntStream
		int[] evenNumbers = Arrays.stream(digits)
								.filter(digit -> digit % 2 == 0)
								.distinct()
								.toArray();
		ArrayUtils.printf(evenNumbers);
		
		// List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		
		/* Set<Integer> evenNumbers = numbers.stream()
										   .filter(nbr -> nbr % 2 == 0)
										   //.distinct() // Set, Map, HashTable >> hashcode, equals
										   .collect(Collectors.toSet()); 
		System.out.println("runtime class " + evenNumbers.getClass());
		CollectionUtils.printf(evenNumbers); */
	}							
}
