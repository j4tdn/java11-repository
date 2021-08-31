package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import functional.Calculation;

public class Ex12 {
	public static void main(String[] args) {
		// Operations: add, sub, mul, div, max, min, average of stream elements 
		// Auto Boxing, Auto UnBoxing
		List<Integer> digits = Arrays.asList(1, 2, 3, 4, 5);
		
		// traditional way
		int sum = 0;
		int max = digits.get(0);
		
		for (Integer digit : digits) {
			sum += digit;
			if(max < digit) {
				max = digit;
			}
		}
		System.out.println("sum: " + sum);
		System.out.println("max: " + max);
		
		System.out.println("=====================");
		
		// stream way >> reduce
		int total = reduce(0, digits, (a, b) -> a + b);
		int max1 = reduce(Integer.MIN_VALUE, digits, (a, b) -> a > b ? a : b);
		int min = reduce(Integer.MAX_VALUE, digits, (a, b) -> a < b ? a : b);
		
		
		System.out.println("total: " + total);
		System.out.println("max1: " + max1);
		System.out.println("min: " + min);
		
		System.out.println("=======================");
		
		// (a, b) -> a + b <==> (a, b) -> Ex12.sum(a, b) <==> Ex12.sum(a, b) == Integer::sum
		int totalAll = digits.stream().reduce(0, Integer::sum);
		int maxAll = digits.stream().reduce(Integer.MIN_VALUE, Integer::max);
		int minAll = digits.stream().reduce(Integer.MAX_VALUE, Integer::min);
		
		System.out.println("totalAll: " + totalAll);
		System.out.println("maxAll: " + maxAll);
		System.out.println("minAll: " + minAll);
		
		System.out.println("===============");
		Optional<Integer> optIn = digits.stream().reduce(Integer::max);
		optIn.ifPresent(value -> System.out.println("max: " + value));
		
		if(optIn.isPresent()) {
			System.out.println("max: " + optIn.get());
		}
		
	}
	
	private static Integer reduce(Integer initial, List<Integer> digits, Calculation c) {
		Integer result = initial;
		for (Integer digit : digits) {
			//result = result + digit;
			result = c.perform(result, digit);
		}
		
		return result;
	}
}
