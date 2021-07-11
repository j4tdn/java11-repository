package ex03;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		String[] str = {"-2", "-6", "10", null, "4", "8", null, "Special", "a", "c", "b", "xx"};
		int[] digits = new int[str.length];
		String[] characters = new String[str.length];
		int count = 0;
		int count2 = 0;

		String[] result = new String[str.length];

		for (String s: str) {
			if (s != null) {
				if (s.equalsIgnoreCase("special")) {
					result[0] = s;
				}
				else {
					if (s.matches("[a-zA-Z]+")) {
						characters[count2++] = s;
					}
				}
				
				if (s.matches("[0-9-]+")) {
					digits[count++] = Integer.parseInt(s);
				}
			}
		}
		
		int[] digitSort = Arrays.copyOfRange(digits, 0, count);
		String[] charSort = Arrays.copyOfRange(characters, 0, count2);

		Arrays.sort(digitSort);
		Arrays.sort(charSort);

		for (int i = 0; i < count; i++) {
			result[i+1] = Integer.toString(digitSort[i]);
		}
		
		for (int i = 0; i < count2; i++) {
			result[count+1+i] = charSort[i];
		}
		
		for (String r: result) {
			System.out.print(r + "  ");
		}
	}
}
