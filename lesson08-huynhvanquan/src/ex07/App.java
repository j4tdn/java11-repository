package ex07;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		String s = "aaabaaabbaaaaa";
		char tmp = s.charAt(0);
		int max = 0, max_index = 0;
		int min = 100, min_index = 0;
		int count = 1;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == tmp) {
				++count;
			} else {
				if (count > max) {
					max = count;
					max_index = i - count;
				}
				if (count < min) {
					min = count;
					min_index = i - count;
				}
				count = 1;
				tmp = s.charAt(i);
			}

		}
		if (count > max) {
			max = count;
			max_index = s.length() - count;
		}
		System.out.println("Độ dài lớn nhất dãy con đúng: " + max + " \"" + s.substring(max_index, max_index + max)
				+ "\" [" + (max_index) + "]");
		System.out.println("Độ dài nhỏ nhất dãy con đúng: " + min + " \"" + s.substring(min_index, min_index + min)
				+ "\" [" + min_index + "]");
	}
}
