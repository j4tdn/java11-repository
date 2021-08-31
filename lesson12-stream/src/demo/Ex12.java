package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import functional.Caculator;

public class Ex12 {
	public static void main(String[] args) {
		List<Integer> digits = Arrays.asList(1, 2, 7, 3, 4, 5);
		
		// traditional way
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(Integer digit : digits) {
			sum += digit;
			if(max < digit) {
				max = digit;
			}
		}
		
		System.out.println("sum : " + sum);
		System.out.println("max : " + max);
		
		System.out.println("=================");
		
		// stream way >> reduce
		int total = reduce(digits, 0, (a,b) -> a + b);
		int maximum = reduce(digits, 0, (a,b) -> a > b ? a : b );
		int minimum = reduce(digits, 0, (a,b) -> a < b ? a : b );
		
		System.out.println("sum : " + total);
		System.out.println("maximum : " + maximum);
		System.out.println("minimum : " + minimum);
		
		Optional<Integer> totalAll = digits.stream().reduce(Integer::sum);
		int maxAll = digits.stream().reduce(Integer.MIN_VALUE, Integer::max);
		int minAll = digits.stream().reduce(Integer.MAX_VALUE, Integer::min);
		
		System.out.println("========================");
		if(totalAll.isPresent()) {
			System.out.println("totalAll : " + totalAll.get());
		}
		System.out.println("maxAll : " + maxAll);
		System.out.println("minAll : " + minAll);
		
		
	}
	
	private static <T> Integer reduce(List<Integer> digits, Integer initial, Caculator cal) {
		Integer result = initial;
		for(Integer digit : digits) {
			result = cal.perform(result,digit);
		}
		
		return result;
	}
}
