package ex03;

import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		String str = "xyz";
		System.out.println("input: " + str);
		System.out.println("output: " + permutation(str));
	}

	public static ArrayList<String> permutation(String input) {
		ArrayList<String> s = new ArrayList<String>();
		if (input == "")
			return s;
		Character a = input.charAt(0);
		if (input.length() > 1) {
			input = input.substring(1);

			ArrayList<String> permSet = permutation(input);

			for (String x : permSet) {
				for (int i = 0; i <= x.length(); i++) {
					s.add(x.substring(0, i) + a + x.substring(i));
				}
			}
		} else {
			s.add(a + "");
		}
		return s;
	}
}
