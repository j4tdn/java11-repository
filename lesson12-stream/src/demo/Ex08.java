package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import utils.ArrayUtils;

public class Ex08 {
	public static void main(String[] args) {
		// source: :List<E>, E[]

		int[] digits = { 1, 2, 1, 3, 3, 2, 4 };

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
	}

}
