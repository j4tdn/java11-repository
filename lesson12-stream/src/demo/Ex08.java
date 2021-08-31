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
		// source: :List<E>, E[]

		int[] digits = { 1, 2, 1, 7, 3, 3, 2, 4, 3 };

		int[] evenNumbers = Arrays.stream(digits).filter(digit -> digit % 2 == 0).distinct().toArray();

		ArrayUtils.printf(evenNumbers);

//		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
//
//		Set<Integer> evenNumbers = numbers.stream().filter(d -> d % 2 == 0)
//				// .distinct() // set, map, hashtable >>
//				// overide hashcode , equal
//				// .collect(Collectors.toList());
//				.collect(Collectors.toSet());
//
//		System.out.println("Runtime class: " + evenNumbers.getClass().getSimpleName());
//
//		evenNumbers.forEach(System.out::println);

		// convert int[] -> List[Interger]

		System.out.println("===============");
		List<Integer> numbers = Arrays.stream(digits).boxed().collect(Collectors.toList());

		List<Integer> uniqueNbrs = numbers.stream().filter(nbr -> Collections.frequency(numbers, nbr) == 1)
				.collect(Collectors.toList());

		CollectionUtils.printf(uniqueNbrs);

		System.out.println("===========");

		numbers.stream()
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet()
		.stream()
			.filter(entry -> entry.getValue() == 1)
			.map(Entry::getKey).collect(Collectors.toList());

	}

}
