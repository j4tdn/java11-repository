package collection.list;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		//Generic type >= java 1.5
		//catch error at compile
		List<Integer> digits = new ArrayList<>();
		List<String> sequences = new ArrayList<>();
		digits.add(10);
		digits.add(234);
		
		for (Integer digit: digits) {
			System.out.println(digit + " ");
		}
	}
}
