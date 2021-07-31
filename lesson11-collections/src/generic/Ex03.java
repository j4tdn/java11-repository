package generic;

import java.util.function.Predicate;

public class Ex03 {
	public static void main(String[] args) {
		IList<String> sequences = new JavaList<>();
		
		sequences.add("how are you?");
		sequences.add("enjoy our page");
		sequences.add("stay safe");

		System.out.println(sequences.size());

		Predicate<String> cond = e -> e.startsWith("how");
		System.out.println(sequences.count(cond));
	}

}
