package collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ex01 {
	public static void main(String[] args) {
		Set<Integer> digits = new LinkedHashSet<>();
		digits.add(15);
		digits.add(22);
		digits.add(18);
		digits.add(22);
		digits.add(null);
		
		System.out.println(digits.size());
		
		for (Integer digit : digits) {
			System.out.println(digit);
		}
		
		Iterator<Integer> each = digits.iterator();
		while(each.hasNext()) {
			System.out.println("next: " + each.next());
		}
	}
}
