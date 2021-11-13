package collection.list;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		List<Integer> digits = new ArrayList<>();
		List<String> sequences = new ArrayList<String>();
		digits.add(123);
		digits.add(234);

		for (Integer digit : digits) {
			System.out.println("double: " + digit * 2);
		}
	}
}
