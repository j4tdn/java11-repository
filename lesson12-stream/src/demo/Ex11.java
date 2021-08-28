package demo;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class Ex11 {
	public static void main(String[] args) {
		int[] digits = { 1, 2, 1, 4, 5, 8, 10, 4, 12 };
		
		boolean test = Arrays.stream(digits)
		.anyMatch(item -> item % 10 == 0);
		
		OptionalInt test1 = Arrays.stream(digits)
		.filter(item -> item % 4 == 0)
		.findFirst();
		if(test1.isPresent()) {
			System.out.println("firstD4 : " + test1.getAsInt());
		}
		
		 OptionalInt test2 =  Arrays.stream(digits)
		 .filter(item -> item % 5 == 0)
		 .findAny();
		 if(test2.isPresent()) {
				System.out.println("anyD5 : " + test2.getAsInt());
			}
		 
		 
		 boolean test3 = Arrays.stream(digits)
		.allMatch(item -> item <= 100);
		 
		 boolean test4 = Arrays.stream(digits)
		.noneMatch(item -> item > 0);
	}
}
