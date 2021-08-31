package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import functional.Calculator;

public class Ex12 {
	public static void main(String[] args) {
		// Operations: sum, subtract, multiply, divide, max, min, average of stream
		// elements
		// Auto Boxing, Auto Unboxing
		List<Integer> digits = Arrays.asList(1, 2, 7, 3, 4, 5);

		// traditional way
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (Integer digit : digits) {
			sum += digit;
			if (max < digit) {
				max = digit;
			}
		}
		System.out.println("sum: " + sum);
		System.out.println("max: " + max);

		System.out.println("======================");

		// stream way >> reduce
		int total = reduce(0, digits, (a, b) -> a + b);
		int maximun = reduce(Integer.MIN_VALUE, digits, (a, b) -> a > b ? a : b);
		int minium = reduce(Integer.MAX_VALUE, digits, (a, b) -> a < b ? a : b);

		System.out.println("total: " + total);
		System.out.println("maximun: " + maximun);
		System.out.println("minium: " + minium);

		System.out.println("======================");

		int totalAll = digits.stream().reduce(0, Integer::sum);
		int maxAll = digits.stream().reduce(Integer.MIN_VALUE, Integer::max);
		int minAll = digits.stream().reduce(Integer.MAX_VALUE, Integer::min);

		System.out.println("totalAll: " + totalAll);
		System.out.println("maxAll: " + maxAll);
		System.out.println("minAll: " + minAll);

		System.out.println("======================");
		
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
