package demo;

import java.util.Arrays;
import java.util.List;

import functional.Calculator;

public class Ex12 {
	public static void main(String[] args) {
		//Auto Boxing, Auto Unboxing
		int a = 5;
		Integer b = a;//boxing
		int c = b;    //unboxing
		
		//Oprations: add, sub, mul, div, max, min, average
		List<Integer> digits = Arrays.asList(1, 2, 3, 7, 4, 5);
		
		//tradition way
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(Integer digit: digits) {
			sum += digit;
			if(max < digit) {
				max = digit;
			}
		}
		System.out.println("sum: "+sum);
		System.out.println("max: "+max);
		
		//stream way with reduce
		int total = reduce(0, digits,((d1,d2)->d1+d2));
		int maximum = reduce(Integer.MIN_VALUE, digits, Integer::max);
		int minimum = reduce(Integer.MAX_VALUE, digits, Integer::min);
			
		System.out.println("total: "+total);
		System.out.println("maximum: "+maximum);
		System.out.println("minimum: "+minimum);
		
		System.out.println("===========");
		
		int totalAll = digits.stream().reduce(0, Integer::sum); 
		int maxAll = digits.stream().reduce(Integer.MIN_VALUE, Integer::max); 
		int minAll = digits.stream().reduce(Integer.MAX_VALUE, Integer::min); 

		System.out.println("totalAll: "+totalAll);
		System.out.println("maxAll: "+maxAll);
		System.out.println("minAll: "+minAll);
		
		System.out.println("===========");
		
		
		
	}
	
	private static Integer reduce(Integer initial, List<Integer> digits, Calculator c) {
		Integer result = initial;
		for(Integer digit: digits) {
			result = c.perform(result, digit);
		}
		return result;
		
	}
	
}