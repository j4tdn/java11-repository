package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import utils.ArraysUtils;
import utils.CollectionUtils;

public class Ex08 {
	public static void main(String[] args) {
		// source : list<T>, E[]
		List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
		int[] digits = {1,2,1,3,3,2,4};
		
		int[] evenNbrs =  Arrays.stream(digits).filter(d -> d % 2 == 0).distinct().toArray();
		ArraysUtils.printf(evenNbrs);
		
		System.out.println("=======================");
		
		Set<Integer> evenNumbers = numbers.stream()
				.filter(d -> d % 2 == 0)
				//.distinct() // Set, Map, HashTable >> hashcode, equals
				.collect(Collectors.toSet());
		
		CollectionUtils.printf(evenNumbers);
		
		
		List<Integer> numberss = Arrays.stream(digits).boxed().collect(Collectors.toList());
		
		numberss.stream()
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet()
		.stream()
		.filter(entry -> entry.getValue() == 1)
		.map(Entry::getKey).collect(Collectors.toList())
		.forEach(System.out::println);
		
		
	}
}
