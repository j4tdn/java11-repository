package demo;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

import utils.CollectionUtils;

public class Ex11 {
	public static void main(String[] args) {
		int[] digits = {1,2,4,3,8,5,10,6,7};
		
		boolean d10 = Arrays.stream(digits).anyMatch(item -> item % 10 ==0);
		System.out.println("anyD10" + d10);;
		
		OptionalInt optInt = Arrays.stream(digits).filter(item -> item % 4 == 0).findFirst();
		if(optInt.isPresent()) {
			System.out.println("first D4: " + optInt.getAsInt() );
		}
		//findFrist = FindAny
		OptionalInt optIntDs = Arrays.stream(digits).filter(item -> item % 5 == 0).findAny();
		if(optIntDs.isPresent()) {
			System.out.println("first D5: " + optIntDs.getAsInt() );
		}
		
		boolean allLt100  = Arrays.stream(digits).allMatch(item -> item >100);
		System.out.println("allLt100: " + allLt100);

		
	}
}
