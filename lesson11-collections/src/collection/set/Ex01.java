package collection.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex01 {
	public static void main(String[] args) {
		Set<Integer> digits = new TreeSet<>();
		digits.add(15);
		digits.add(22);
		digits.add(18);
		digits.add(15);
	
		digits.forEach(t->System.out.println(t));
		Iterator<Integer> each = digits.iterator();
		while(each.hasNext())
		{
			System.out.println("next: "+each.next());
		}
		System.out.println("size: " + digits.size());
		
	}
}
