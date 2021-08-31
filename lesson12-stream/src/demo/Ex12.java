package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import functional.Calculator;

public class Ex12 {
	public static void main(String[] args) {
		// Operations : sum, subtract, multiply, divide, max, average of stream elements
		// Auto Boxing, Auto UnBoxing
		List<Integer> digits = Arrays.asList(1, 2, 7, 3, 4, 5);

		int total = reduce(0, digits, (a, b) -> a + b);
		int maximum = reduce(Integer.MIN_VALUE, digits, (a, b) -> a > b ? a : b);
		int minimum = reduce(Integer.MAX_VALUE, digits, (a, b) -> a < b ? a : b);

		System.out.println("total: " + total);
		System.out.println("maximum: " + maximum);
		System.out.println("minimum: " + minimum);

		System.out.println("===================");
		// stream way >> reduce
		// (a,b) -> a+b <==> Integer::sum
		int totalAll = digits.stream().reduce(0, Integer::sum);
		int maxAll = digits.stream().reduce(Integer.MIN_VALUE, Integer::max);
		int minAll = digits.stream().reduce(Integer.MAX_VALUE, Integer::min);

		System.out.println("totalAll: " + totalAll);
		System.out.println("maxAll: "+ maxAll);
		System.out.println("minAll: "+ minAll);

		System.out.println("============");
		Optional<Integer> opInt = digits.stream().reduce(Integer::max);
		opInt.ifPresent(value -> System.out.println("max: " + value));

		if (opInt.isPresent()) {
			System.out.println("max: " + opInt.get());
		}


	}

	private static Integer reduce(Integer initial, List<Integer> digits, Calculator c) {
		Integer result = initial;
		for (Integer digit : digits) {
			result = c.perform(result, digit);
		}
		return result;
	}

}
