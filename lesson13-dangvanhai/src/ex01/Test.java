package ex01;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors; 

public class Test {
	public static void main(String[] args) {
//		int[] digits = { 1, 2, 3, 4, 5, 6, 5, 5, 3, 1 }; 	// get unique
		
		
		
		// Done 
		String str = "aaaabbbabbbddc";
		List<Character> chars = str.chars().mapToObj(e -> (char)e)
		.collect(Collectors.toList());
		
		Character a =  chars.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream()
		.sorted((o1,o2) -> (int)(o2.getValue() - o1.getValue()))
		.map(e -> e.getKey())
		.collect(Collectors.toList()).get(0);
		
		Character result = chars.stream().sorted((o1,o2) -> (Collections.frequency(chars, o2) - Collections.frequency(chars, o1)))
			.collect(Collectors.toList()).get(0);
				
		System.out.println(result);
		
	}
}
