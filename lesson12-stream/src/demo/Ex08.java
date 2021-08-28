package demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import java.util.function.Function;

import java.util.stream.Collectors;


import utils.ArrayUtils;
import utils.collectionUtils;

public class Ex08 {
	public static void main(String[] args) {
		// source: List<E> , E[]
		
		int[] digits = {1,7,2,1,3,3,2,4};
		
		// Stream Object: Stream<T>
		// Stream Primitive: IntStream, DoubleStream, Long Stream
		
		
		int[] evenNumbers = Arrays.stream(digits)
								  .filter(digit -> digit % 2==0)
								  .distinct()
							      .toArray();
		
		ArrayUtils.printf(evenNumbers);
	/*	List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
		
		Set<Integer> evenNumbers = numbers.stream()
				 					.filter(n -> n %2 == 0)
				 					.collect(Collectors.toSet());
		System.out.println("runtime: " + evenNumbers.getClass().getSimpleName());
		collectionUtils.printf(evenNumbers);
		
		// Set Map, HashTable >> hashcode, equals = distinct*/
		// Stream<T> -> collect(collectors.toList()) = List<T>
		// IntStream ->           x                  = List<int>
		// IntStream  int[] -> List<Integer>
		
		List<Integer> numbers = Arrays.stream(digits).boxed().collect(Collectors.toList());
		List<Integer> uniqueNbrs = numbers.stream().
											filter(i -> Collections.frequency(numbers, i)==1).collect(Collectors.toList());
		System.out.println("phan tu xuat hien 1 lan: ");
		collectionUtils.printf(uniqueNbrs);
		
		System.out.println("=====================");
		numbers.stream().collect(Collectors
				.groupingBy(Function.identity(),Collectors.counting()))
		        .entrySet()
		        .stream()
		        .filter(e->e.getValue() == 1)
		        .map(Entry::getKey)
		        .collect(Collectors.toList())
		        .forEach(System.out::println);
		
	
	}
}
