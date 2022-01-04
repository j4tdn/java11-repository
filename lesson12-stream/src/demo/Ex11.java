package demo;

import java.util.Arrays;
import java.util.OptionalInt;

public class Ex11 {
	public static void main(String[] args) {
		int[] arr = {1,2,10,20,4,5,8,10,4,12, 15, 25};
		// is there any element that is divisible by 10
		boolean e1 = Arrays.stream(arr).anyMatch(e -> e % 10 == 0) ;
		// find the first element that is divisible by 4
		OptionalInt e2 = Arrays.stream(arr).filter(e -> e % 4 == 0).findFirst();
		// find the element that is divisible by 5 in the list
		OptionalInt e3 = Arrays.stream(arr).filter(e -> e % 5 == 0).findAny();
		System.out.println(e3);
		// does all element less than 100
		boolean e4 = Arrays.stream(arr).allMatch(e -> e < 100);
		//does all element great than 0
		boolean e5 = Arrays.stream(arr).noneMatch(e -> e > 0);
		System.out.println(e5);
	}
}
