package ex03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Ex03 {

	public static void main(String[] args) {
		String s = "xyz";
		String[] outputs = permutation(s);
		for (int i = 0; i < outputs.length; i++) {
			System.out.print(outputs[i]);
			if (i != outputs.length - 1) {
				System.out.print(", ");
			}
		}

	}

	public static String[] permutation(String s) {
		long total = 1;
		ArrayList<Character> letters = new ArrayList<Character>();
		Set<StringBuilder> output = new HashSet<StringBuilder>();

		for (int i = 0; i < s.length(); i++) {
			total *= (i + 1);
			letters.add(s.charAt(i));
		}

		while (output.size() < total) {
			Collections.shuffle(letters);
			StringBuilder sb = new StringBuilder();
			for (Character ct : letters) {
				sb.append(ct);
			}
			System.out.println(sb);
			output.add(sb);
		}

		return new String[0];

	}

}