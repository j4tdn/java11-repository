package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import functional.Calculator;

public class Ex12 {
	public static void main(String[] args) {
		// Operations: add, subtract, multiply, divide, max, min, average of stream
		// elements
		// Auto Boxing, Auto UnBoxing
		List<Integer> digits = Arrays.asList(1, 2, 3, 4, 5, 6, 8);

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

		System.out.println("====================");

		// stream way >> reduce
		int total = reduce(0, digits, Integer::sum);
		int maximun = reduce(Integer.MIN_VALUE, digits, Integer::max);
		int minmun = reduce(Integer.MAX_VALUE, digits, Integer::min);

		System.out.println("total: " + total);
		System.out.println("max: " + maximun);
		System.out.println("min: " + minmun);

		// (a, b) -> a + b <==> (a, b) -> Ex12.sum(a,b) <==> Ex12::sum <==> Integer::sum
		int totalStream = digits.stream().reduce(0, Integer::sum);
		int maxStream = digits.stream().reduce(Integer.MIN_VALUE, Integer::max);
		int minStream = digits.stream().reduce(Integer.MAX_VALUE, Integer::min);

		System.out.println("total: " + totalStream);
		System.out.println("max: " + maxStream);
		System.out.println("min: " + minStream);
		
		System.out.println("===========");
		Optional<Integer> opInt = digits.stream().reduce(Integer::sum);
		opInt.ifPresent(value -> System.out.println("max: " + value));
		if (opInt.isPresent()) {
			System.out.println("max: " + opInt.get());
		}
	}

	public static <T> T reduce(T initial, List<T> digits, Calculator<T> c) {
		T result = initial;
		for (T digit : digits) {
			result = c.perform(digit, result);
		}
		return result;
	}

}
