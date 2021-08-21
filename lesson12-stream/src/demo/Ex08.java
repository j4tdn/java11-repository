package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
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
	}
}
