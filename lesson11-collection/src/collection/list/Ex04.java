package collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Ex04 {
	public static void main(String[] args) {
		List<String> elements = new ArrayList<>();
		// Kiem tra hasNext() co khong, neu co thi nhay den
		elements.add("Item - 5");
		elements.add("Item - 1");
		elements.add("Item - 2");
		elements.add("Item - 0");

//		Predicate<String> pre = new Predicate<String>() {
//			@Override
//			public boolean test(String item) {
//				return Integer.parseInt("" + item.charAt(item.length() - 1)) <= 3;
//			}
//		};
		
// 		way 3: Duyet tung phan tu, neu thoa man dieu kien test thi se xoa
		Predicate<String> pre = item -> Integer.parseInt("" + item.charAt(item.length() - 1)) <= 3;
		elements.removeIf(pre);
		
		System.out.println("contains: " + elements.contains("Item - 5"));
		System.out.println("==========");
		for (String element : elements) {
			System.out.println(element);
		}
		
//		way 1: 
// 		remove() of ArrayList: Remove and shift left		
//		for (int i = 0; i < elements.size(); i++) {
//			String item = elements.get(i);
//			int remainingDays = Integer.parseInt("" + item.charAt(item.length() - 1));
//			if (remainingDays <= 3) {
//				System.out.println("removed element: " + remainingDays);
//				elements.remove(item);
//				i--;
//			}
//		}
		
// 		way 2: 
// 		Iterator<String> iterator = elements.iterator();
//		while(iterator.hasNext()) {
//			String item = iterator.next();
//			int remainingDays = Integer.parseInt("" + item.charAt(item.length() - 1));
//			if (remainingDays <= 3) {
//				System.out.println("removed element: " + remainingDays);
//				elements.remove(item);
//			}
//		}
	}
}
