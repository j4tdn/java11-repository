package collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex01 {
	public static void main(String[] args) {
		Set<Integer> digits = new HashSet<>();
		digits.add(15);
		digits.add(22);
		digits.add(33);
		digits.add(22);
		
		System.out.println(digits.size());
		// Set ko dùng for index
		
		for(Integer digit: digits) {
			System.out.println(digit);
		}
		
		Iterator<Integer> each = digits.iterator();
		while (each.hasNext()) {
			System.out.println(each.next());
		}

	}
}
