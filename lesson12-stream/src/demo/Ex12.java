package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import functional.Calculator;

public class Ex12 {
	public static void main(String[] args) {
		//Operations: sum, sub, mul, divide, max, min, average 
		//auto Boxing, Auto unboxing
		List<Integer> digits = Arrays.asList(1,2,3,7,5,6,9);
		
		//stream way >>reduce 
		int total = reduce(0, digits, (a,b) -> a + b);
		int max = reduce(Integer.MIN_VALUE, digits, (a,b) -> a > b ? a : b);
		int min = reduce(Integer.MAX_VALUE, digits, (a,b) -> a < b ? a : b);
		System.out.println("total: " + total);
		System.out.println("max: " + max);
		System.out.println("min: " + min);
		
		System.out.println("==========================");
		
		//(a,b) -> a + b  <==> (a,b) -> Ex12.sum(a,b) <==> Ex12::sum 	<==> Integer::sum
		int totalAll = digits.stream().reduce(0, Integer::sum);
		int maxValue = digits.stream().reduce(Integer.MIN_VALUE, Integer::max);
		int minValue = digits.stream().reduce(Integer.MAX_VALUE, Integer::min);
		
		System.out.println("totalAll: " + totalAll);
		System.out.println("maxValue: " + maxValue);
		System.out.println("minValue: " + minValue);
		
		System.out.println("========================");
			
		Optional<Integer> optInt = digits.stream().reduce(Integer::max);
			optInt.ifPresent(value -> System.out.println("max: " + value));
		
			if(optInt.isPresent()) {
				System.out.println("max: " + optInt.get());
	
			}
	}
	
	private static Integer reduce(Integer initial, List<Integer> digits, Calculator c ) {
		Integer result = initial;
		for(Integer digit: digits) {
			//sum >> result = result + digit;
			//max >> result = digit > result ? digit : result;
			//min >> result = digit < result ? digt : result;
			result = c.perform(result, digit);
		}
		return result;
	}
		
}
