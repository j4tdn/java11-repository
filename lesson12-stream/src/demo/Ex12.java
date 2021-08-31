package demo;

import java.util.Arrays;
import java.util.List;

import functional.Calculator;

public class Ex12 {
	public static void main(String[] args) {
		List<Integer> digits = Arrays.asList(1, 2, 3, 4, 5);
		//traditional way 
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (Integer digit : digits) {
			sum = sum + digit;
			if(max < digit) {
				max = digit;
			}
		}
		System.out.println("sum: " + sum);
		System.out.println("max: " + max);
		System.out.println("======================");
		
		// stream way >> reduce
		//int total = reduce(0, digits, null)
		
		int total = reduce(0, digits, (a, b) -> a + b);
		int maximum = reduce(Integer.MIN_VALUE, digits, (a, b) -> a > b ? a : b);
		int minimum = reduce(Integer.MAX_VALUE, digits, (a, b) -> a < b ? a : b);
		
		System.out.println("total: " + total);
		System.out.println("maximum: " + maximum);
		System.out.println("minimum: " + minimum);
		
		System.out.println("===========================");
		
		// (a, b) -> a+b <==> (a, b) -> Ex12.sum(a,b) <--> Ex12::sum <==> Integer::sum
		int totalAll = digits.stream().reduce(0, Integer::sum);
		int maxAll = digits.stream().reduce(Integer.MIN_VALUE, Integer::max);
		int minAll = digits.stream().reduce(Integer.MAX_VALUE, Integer::min);
		
		System.out.println("total all: " + totalAll);
		System.out.println("max all: " + maxAll);
		System.out.println("min all: " + minAll);
		
		System.out.println("=============");
		
	}
	
	private static Integer reduce(Integer initial, List<Integer> digits, Calculator c) {
		Integer result = initial;
		for (Integer digit : digits) {
			result = c.perform(result, digit);
		}
		return result;
		
	}
}
