package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import functional.Calculator;

public class Ex12 {
	public static void main(String[] args) {
		// Auto boxing
		List<Integer> digits = Arrays.asList(1, 2, 3, 4, 5);

		// Stream way >> reduce
		Integer sum = reduce(0, digits, (a, b) -> Integer.sum(a, b));
		System.out.println("Sum" + sum);

		// (a,b) -> a+b <==> (a,b) -> Ex12.sum(a,b) => Ex12:sum
		int totalAll = digits.stream().reduce(0, Integer::sum);
		System.out.println("totalAll: " + totalAll);

		System.out.println("==================");
		int max = digits.stream().reduce(Integer.MIN_VALUE, Integer::max);
		int min = digits.stream().reduce(Integer.MAX_VALUE, Integer::min);
		System.out.println("maxAll: " + max);
		System.out.println("minAll: " + min);

		System.out.println("==================");
		Optional<Integer> optInt = digits.stream().reduce(Integer::max);
		if (optInt.isPresent()) {
			System.out.println("optInt: " + optInt.get());
		}
	}

	private static <T> T reduce(T initial, List<T> digits, Calculator<T> c) {
		T result = initial;
		for (T digit : digits) {
			result = c.perform(result, digit);
		}
		return result;
	}
}
