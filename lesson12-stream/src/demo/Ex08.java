package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import utils.ArrayUtils;
import utils.CollectionUtils;

public class Ex08 {
	public static void main(String[] args) {
		//source: List<E>, E[]
		int[] digits = {1,2,2,3,1,4,3};
		
		//Stream Objects: Stream<T>
		//Stream primitive: IntStream, DoubleStream, LongStream
		
		//IntStream
		int[] evenNumber = Arrays.stream(digits)
			   .filter(digit -> digit %2 ==0)
			   .distinct()
			   .toArray();
		
		
		ArrayUtils.printf(evenNumber);
		
		/*
		List<Integer> numbers = Arrays.asList(1,2,1,3,3,4, 4,5);
	
		Set<Integer> evenNumbers = numbers.stream()
											.filter(number -> number%2 == 0)
											//.distinct() //Set, Map, HashTable >> hashcode, equals
											.collect(Collectors.toSet());
		System.out.println( evenNumbers.getClass().getSimpleName());
		CollectionUtils.printf(evenNumbers);
	*/
	}
	
	
}
