package generic;

import java.util.function.Predicate;

public class Ex03 {
	public static void main(String[] args) {
		IList<String> sequences = new JavaList<>();
		sequences.add("how are you");
		sequences.add("fine ");
		sequences.add("how arfde");
		sequences.add("how are sdfsdyou");
		sequences.add("how arfdfe you");
		sequences.add("how assdfsdre you");

		
		System.out.println(sequences.size() + "size");
		sequences.show();
		
		Predicate<String> cond = e -> e.startsWith("how");
		System.out.println(sequences.count(cond));
	}
}
