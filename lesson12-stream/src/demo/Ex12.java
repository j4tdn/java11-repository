package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

import functional.Calculator;

public class Ex12 {
	public static void main(String[] args) {
		// Operations: add, subtract, multiply, divide, max, min, average of stream elements
		// Auto Boxing, Auto UnBoxing
		List<Integer> digits = Arrays.asList(1, 2, 7, 3, 4, 5);
		
		// traditional way
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (Integer digit: digits) {
			sum += digit;
			if (max < digit) {
				max = digit;
			}
		}
		System.out.println("sum: " + sum);
		System.out.println("max: " + max);
		
		System.out.println("=======================");
		
		// stream way >> reduce
		
		int total = operate(0, digits, (a, b) -> a + b);
		int maximum = operate(Integer.MIN_VALUE, digits, (a, b) -> a > b ? a : b);
		int minimum = operate(Integer.MAX_VALUE, digits, (a, b) -> a < b ? a : b);
		
		System.out.println("total: " + total);
		System.out.println("maximum: " + maximum);
		System.out.println("minimum: " + minimum);
		
		System.out.println("===========================");
		
		// (a, b) -> a + b <==> (a, b) -> Ex12.sum(a, b) <==> Ex12::sum <==> Integer::sum
		int totalAll = digits.stream().reduce(0, Integer::sum);
		int maxAll = digits.stream().reduce(Integer.MIN_VALUE, Math::max);
		int minAll = digits.stream().reduce(Integer.MAX_VALUE, Math::min);
		
		System.out.println("totalAll: " + totalAll);
		System.out.println("maxAll: " + maxAll);
		System.out.println("minAll: " + minAll);
		
		System.out.println("===================");
		
		Optional<Integer> optInt= digits.stream().reduce(Integer::max);
		optInt.ifPresent(value ->  System.out.println("max: " + optInt.get()));
		
		if (optInt.isPresent()) {
			System.out.println("max: " + optInt.get());
		}
	}
	
	private static int sum(int a, int b) {
		return a + b;
	}
	
	private static Integer operate(Integer initial,List<Integer> digits, Calculator c) {
		Integer result = initial;
		for (Integer digit: digits) {
			result = c.perform(result, digit);
		}
		return result;
	}
}
