package demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import utils.ArrayUtils;
import utils.CollectionUtils;

public class Ex08 {
	public static void main(String[] args) {
		//source: List<E>, E[]
		int[] digits = {1,2,2,3,1,4,3, 7 };
		
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
		System.out.println("============================");
		//Stream<T> --> collect(Collectors.toList()) = List<T>
		//IntStream -->              X               = List<int>
		//IntStream --> Stream<Integer> --> collect
		
		//convert int[] -> List<Integer>
		 List<Integer> numbers = Arrays.stream(digits).boxed().collect(Collectors.toList());
		 
		 List<Integer> uniqueNumbers = numbers.stream()
				 						.filter(nbr -> Collections.frequency(numbers, nbr) == 1)
				 						.collect(Collectors.toList());
		 CollectionUtils.printf(uniqueNumbers);
		 
		 System.out.println("=======================================");
		
		 //K: Checked Element
		 //V: amount of checked element
		  numbers.stream()
		 		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet() //Set<Entry<Integer,Long>>
				.stream()	//Stream<Entry<Integer,Long>>
				.filter(entry -> entry.getValue() == 1)
				.map(Entry::getKey) //Stream<Integer>
				.collect(Collectors.toList()) //List<Integer>
				.forEach(System.out::println);
				
	}
}
