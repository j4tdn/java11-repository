package collection.list;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		//generic type: >=1.5
		// catch error at compile time
		
		List<Integer> digits = new ArrayList<>();
		List<String> sequences = new ArrayList<>();
		
		
		digits.add(123);
		digits.add(234);

		for (Integer digit : digits) {
			System.out.println("double: " + (digit * 2));
		}

	}
}
