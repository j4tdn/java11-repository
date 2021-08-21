package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import utils.ArrayUtils;
import utils.collectionUtils;

public class Ex08 {
	public static void main(String[] args) {
		// source: List<E> , E[]
		
		int[] digits = {1,2,1,3,3,2,4};
		
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
	}
}
