package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.sun.jdi.Value;

import functional.Calculator;

public class Ex12 {
public static void main(String[] args) {
	// Operations: add, subtract, multiply, divide, max, min, average of stream elements
	// Auto Boxing, Auto UnBoxing
	List<Integer> digits = Arrays.asList(1,2,7,3,4,5);
	
	System.out.println("==================");
	// stream way >> reduce
	int total =  reduce(0, digits,(a,b)-> a+b);
	int maximum = reduce(Integer.MIN_VALUE, digits,(a,b) -> a > b ? a: b);
	int minimum = reduce(Integer.MAX_VALUE, digits,(a,b) -> a < b ? a: b);
	
	System.out.println("total: " + total);
	System.out.println("maximum: " + maximum);
	System.out.println("minimum: " + minimum);
	
	System.out.println("==================");
	// (a,b) -> a+ b <==> (a,b) -> Ex12.sum(a,b) <==> Ex12::sum <==> Integer::sum
	int totalAll = digits.stream().reduce(0, Integer::sum);
	int maxAll = digits.stream().reduce(Integer.MIN_VALUE, Integer::max);
	int minAll = digits.stream().reduce(Integer.MAX_VALUE, Integer::min);
	
	System.out.println("totalAll: " + totalAll);
	System.out.println("maxAll: " + maxAll);
	System.out.println("minall: " + minAll);
	
	System.out.println("=========="); 
	Optional<Integer> optInt = digits.stream().reduce(Integer::max);
	optInt.ifPresent(Value -> System.out.println("max: " + Value));
	if(optInt.isPresent()) {
		System.out.println("max: " + optInt.get());
	}
}
private static Integer reduce(Integer initial, List<Integer> digits,Calculator c) {
	int result = initial;
	for(Integer digit: digits) {
		// result = result + digit;
		// max >> result = digit > result ? digit : result;
		// min << result = digit < result ? digit : result;
		result = c.perform(result, digit);
	}
	return result;
}
}
