package demo;

import java.util.Arrays;
import java.util.OptionalInt;

public class Ex11 {
	public static void main(String[] args) {
		int[] digits = {1,2,1,4,5,8,10,4,12};
		// is there any element that is divisible by 10
		boolean d10 = Arrays.stream(digits) //Stream<Int[]>
				.anyMatch(item -> item %10 == 0);
			
		System.out.println("anyD10: " + d10);
		// is there first element that is divisible by 4
		OptionalInt d4 = Arrays.stream(digits).filter(item -> item %4 == 0)
					.findFirst();
		if(d4.isPresent()) {
				System.out.println("firstD4: "+d4.getAsInt());
		}
		// find the element that is divisible by 5
		// findAny = findFirst
		OptionalInt d5 = Arrays.stream(digits).filter(item -> item %5 == 0)
								.findAny();
		if(d5.isPresent()) {
			System.out.println("anyD5: "+d5.getAsInt());
		}	
		// is there all elements less than 100
		boolean allLT100 = Arrays.stream(digits) //Stream<Int[]>
						.allMatch(item -> item < 100);
					
		System.out.println("allLT100: " + allLT100);		
		
		// does no elements greater than 0
		boolean noneGT0 = Arrays.stream(digits) //Stream<Int[]>
						.noneMatch(item -> item > 0);
					
		System.out.println("noneGT100: " + noneGT0);		
				
	
	}
}