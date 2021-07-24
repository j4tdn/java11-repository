package collection.list;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		// Generic type: >= 1.5
		// Catch error at compile time
		
		List<Integer> digits = new ArrayList<>();
		List<String> sequences = new ArrayList<String>();
		
		digits.add(123);
		digits.add(345);
		
		sequences.add("tran");
		sequences.add("hung");
		
		for (Integer digit : digits) {
			System.out.println("double: " + (digit * 2));
		}
	}
}
