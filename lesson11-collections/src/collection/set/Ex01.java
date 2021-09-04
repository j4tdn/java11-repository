package collection.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex01 {
	public static void main(String[] args) {
		//Map<K,V> >> hashcode, equals of Key
		//Set<E>   >>                     E    
		//Set<E> #add(e) >> Map.put(e, PRESENT); ban chat cua Set la cung tu map	
		Set<Integer> digits = new HashSet<>();
		digits.add(15);
		digits.add(4);
		digits.add(30);
		digits.add(22);
		digits.add(15);
		
		System.out.println("size: " + digits.size());
		
		for(Integer digit: digits) {
			System.out.println(digit);
		}
		
	Iterator<Integer> each = digits.iterator(); //duyệt từng phần tử
	while(each.hasNext()) {
		System.out.println("next: " + each.next() );
	}
	}
	
}
