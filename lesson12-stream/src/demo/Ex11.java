package demo;

import java.util.Arrays;
import java.util.OptionalInt;

public class Ex11 {
	public static void main(String[] args) {
		int[] digits = { 9, 2, 1, 4, 5, 8, 10, 4, 12};
		
		// return findFirst
		int a = Arrays.stream(digits)
				.findFirst().getAsInt();
		System.out.println(a);
		
		//
		boolean b = Arrays.stream(digits)
				.anyMatch(p -> p%10 == 0);
		System.out.println(b);
		
		OptionalInt optInt = Arrays.stream(digits).filter(p -> p% 4 ==0).findFirst();
		if(optInt.isPresent()) {
			System.out.println("fist D4 "+ optInt.getAsInt());
		}
		OptionalInt optIntD5 = Arrays.stream(digits).filter(item -> item % 5 ==0).findAny();
			if(optIntD5.isPresent()) {
				System.out.println("anyD5" +optIntD5.getAsInt());
			}
			
		boolean alt100 = Arrays.stream(digits).allMatch(item -> item <100);
		System.out.println("alt100" + alt100);
		
		//
		boolean  noneT100 = Arrays.stream(digits).noneMatch(item -> item >100);
		System.out.println("nonT100: " +noneT100);
	}
}
