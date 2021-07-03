package ex07;

import java.util.Arrays;

public class Ex07 {
	public static void main(String[] args) {
		String input = "aaabaaabbaaaaa";
		printf(input);
	}

	private static String[] getString(String input) {
		String str = input + "@";
		String[] result = new String[str.length()];
		int index = 0;
		int i = 0;
		int j = i + 1;
		for (i = 0; i < str.length() - 1; i++) {
			for (j = i + 1; j < str.length(); j++) {
				if (input.charAt(i) != str.charAt(j)) {
					result[index++] = str.substring(i, j);
					i = j;
				}
			}
		}
		return Arrays.copyOfRange(result, 0, index);
	}
	
	private static void printf(String input) {
		String[] str = getString(input);
		int posMax = 0;
		int posMin = 0;
		String max = str[0];
		String min = str[0];
		for(int i = 0; i < str.length; i++) {
			if(max.length() < str[i].length()) {
				max = str[i];
				posMax = i;
			}

			
			if(str[i].length() < min.length()) {
				min = str[i];
				posMin = i;
			}
		}
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < posMax ; i++) {
			x = x + str[i].length();
		}
		
		for(int i = 0; i < posMin; i++) {
			y = y + str[i].length();
		}
		
		
		System.out.print("Độ dài lớn nhất dãy con đúng : " + max.length()
		+ " " + max + " [" + x + "]");
		
		System.out.println();
		System.out.print("Độ dài nhỏ nhất dãy con đúng : " + min.length()
		+ " " + min + " [" + y + "]");
		
	}

}
