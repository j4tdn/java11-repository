package colections.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex01 {
	public static void main(String[] args) {
		// Map<K, V> >> hashcode, equals of KEY
		// Set<E>    >>                  of E 
		// Set<E> #add(e) >> Map.put(e, PRESENT);
		Set<Integer> digits = new TreeSet<>();
		digits.add(15);
		digits.add(22);
		digits.add(null);
		digits.add(18);
		digits.add(22);
		
		System.out.println(digits.size());
		
		for (Integer digit: digits) {
			System.out.println(digit);
		}
		
		Iterator<Integer> each = digits.iterator();
		while(each.hasNext()) {
			System.out.println("next: " + each.next());
		}
	}
}
