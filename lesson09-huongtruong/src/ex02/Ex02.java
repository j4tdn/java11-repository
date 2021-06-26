package ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ex02 {

	public static void main(String[] args) {
		String s1 = "01a2b3456cde478";
		String s2 = "aa6b546c6e22h";
		
		String output = "";
		int[] largestNumbers = getLargestNumbers(s1, s2);
		for (int i = 0; i < largestNumbers.length; i++) {
			output += largestNumbers[i];
			if (i != largestNumbers.length - 1) {
				output += ", ";
			}
		}

		System.out.println(output);

	}

	public static int[] getLargestNumbers(String... inputs) {
		ArrayList<Integer> largestNumbers = new ArrayList<Integer>();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		String number;
		for (String input : inputs) {
			number = "";
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
					number += input.charAt(i);
				} else {
					if (!number.equals("")) {
						numbers.add(Integer.parseInt(number));
					}
					number = "";
				}
			}
			if (!number.equals("")) {
				numbers.add(Integer.parseInt(number));
				number = "";
			}
			if (numbers.size() == 0) {
				numbers.add(0);
			}
			largestNumbers.add(Collections.max(numbers));
			numbers = new ArrayList<Integer>();
		}
		int[] output = new int[largestNumbers.size()];
		int index = 0;
		for (Integer largestNumber : largestNumbers) {
			output[index++] = largestNumber;
		}
		Arrays.sort(output);
		return output;
	}
}