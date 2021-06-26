package bt02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bt02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = Integer.parseInt(sc.nextLine());
		int i = 0;
		List<String> strs = new ArrayList<String>();
		while (i++ < n) {
			System.out.print("Enter str " + i + ": ");
			strs.add(sc.nextLine());
		}

		for (String str : strs) {
			System.out.println(findMaxNumbers(str));
		}
	}

	public static int findMaxNumbers(String str) {
		List<Integer> numbers = new ArrayList<>();
		Pattern patt = Pattern.compile("[\\d]+");
		Matcher matcher = patt.matcher(str);

		while (matcher.find()) {
			numbers.add(Integer.parseInt(str.substring(matcher.start(), matcher.end())));
		}

		// find max number in list
		Collections.sort(numbers);
		if (numbers.size() > 0) {
			return numbers.get(numbers.size() - 1);
		}
		return 0;
	}

}
