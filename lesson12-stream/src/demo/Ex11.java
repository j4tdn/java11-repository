package demo;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

import utils.CollectionUtils;

public class Ex11 {
	public static void main(String[] args) {
		int[] digits = {1,2,12,4,3,8,5,10,6,7};
		//1st: is there any element that is divisible by 10
		boolean d10 = Arrays.stream(digits).anyMatch(item -> item % 10 ==0);
		System.out.println("anyD10: " + d10);;
		
		//2nd: find the first element that is divisible by 4
		OptionalInt optInt = Arrays.stream(digits).filter(item -> item % 4 == 0).findFirst();
		if(optInt.isPresent()) {
			System.out.println("first D4: " + optInt.getAsInt() );
		}
		//3rd: find the element that is divisible by 5 in the list
		//findFrist = FindAny
		OptionalInt optIntD5 = Arrays.stream(digits).filter(item -> item % 5 == 0).findAny();
		if(optIntD5.isPresent()) {
			System.out.println("first D5: " + optIntD5.getAsInt() );
		}	
		//4th: does all elements less than 100
		boolean allLt100  = Arrays.stream(digits).allMatch(item -> item < 100);
		System.out.println("allLt100: " + allLt100);

		//5th: does no elements greater than 0
		boolean allGreaterZero  = Arrays.stream(digits).noneMatch(item -> item > 0);
		System.out.println("allGreaterZero: " + allGreaterZero);
	}
}
