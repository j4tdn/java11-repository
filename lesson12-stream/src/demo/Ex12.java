package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import functional.Calculator;

public class Ex12 {
	public static void main(String[] args) {
		List<Integer> digits = Arrays.asList(1, 2, 3, 4, 5);
		
		int total = operate(0, digits, (a, b) -> a + b);
		int maximum = operate(Integer.MIN_VALUE, digits, (a, b) -> a > b ? a : b);
		System.out.println("total: " + total);
		System.out.println("maximum: " + maximum);
		
		// (a, b) -> a + b <==> (a,b) -> Ex12.sum(a,b) <==> Ex12::sum <==> Integer::sum
		int totalAll = digits.stream().reduce(0, Integer::sum);
		int maxAll = digits.stream().reduce(Integer.MIN_VALUE, Integer::max);
		int minAll = digits.stream().reduce(Integer.MAX_VALUE, Integer::min);
		
		System.out.println("total: " + totalAll);
		System.out.println("max: " + maxAll);
		System.out.println("min: " + minAll);
		
		System.out.println("=============");
		
		Optional<Integer> opInt = digits.stream().reduce(Integer::max);
		opInt.ifPresent(value -> System.out.println("max: " + value));
	}
	
	private static Integer operate(Integer initial, List<Integer> digits, Calculator c) {
		Integer result = initial;
		for(Integer digit: digits) {
			result = c.perform(result, digit);
		}
		return result;
	}
}
