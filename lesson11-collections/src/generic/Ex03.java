package generic;

import java.util.function.Predicate;

public class Ex03 {
	public static void main(String[] args) {
		IList<String> sequences = new JavaList<>();
		sequences.add("how are you");
		sequences.add("enjoy our page");
		sequences.add("how is it going today");
		sequences.add("how are you");
		
		System.out.println("size: " + sequences.size());
		//sequences.show();
		sequences.remove(2);
		System.out.println("size: " + sequences.size());
		sequences.show();

		
//		
//	Predicate<String> cond = e -> e.startsWith("how");
//	 	int count = sequences.count(cond);
//	 	System.out.println("count :" + count);
	}
}
