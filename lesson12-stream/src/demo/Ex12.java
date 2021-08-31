package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import functional.Calculator;

public class Ex12 {
	public static void main(String[] args) {
		// Operations : sum, subtract, multiply, divide, max, minimum, average of stream elements
		
		// Auto Boxing, Auto UnBoxing
		List<Integer> digits = Arrays.asList(1, 2, 3, 4, 5);
		
		// traditional way
		
		// stream way >> reduce
		int total = reduce(0, digits, (a, b) ->  a+b );
		int maximm = reduce(Integer.MAX_VALUE, digits, (a,b) -> a>b ? a: b);
		int minimum = reduce(Integer.MIN_VALUE, digits , (a, b)-> a > b ? b:a);
		
		System.out.println("total: " + total);
		System.out.println("Max: " + maximm);
		System.out.println("Min: " + minimum);
		
		System.out.println("=========");
		
		int totalAll = digits.stream().reduce(0,Integer::sum);
		int maxAll = digits.stream().reduce(Integer.MIN_VALUE, Integer::max);
		int minAll = digits.stream().reduce(Integer.MAX_VALUE, Integer::min);
		
		System.out.println("totalAll" + totalAll);
		System.out.println("maxAll" + maxAll);
		System.out.println("minAll" + minAll);
		
		System.out.println("=========");
		
		Optional<Integer> optInt = digits.stream().reduce(Integer::max);
		optInt.ifPresent(value -> System.out.println("max: "+ value));
		
		
	}
	private static Integer reduce(Integer initial, List<Integer> digits, Calculator c) {
		Integer result = initial;
		for(Integer digit: digits) {
			result = c.perfporm(result, digit);
		}
		return result;
	}
}
