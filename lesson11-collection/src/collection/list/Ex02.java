package collection.list;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		// Generic type => 1.5 
		// Catch error at compile  
		
		List<Integer> digits = new ArrayList<>();
		List<String> sequences = new ArrayList<>();
		
		
		digits.add(12);
		digits.add(123);
		
		for(Integer digit : digits) {
			System.out.println("digit : " + digit * 2);
		}
		
	}
}
