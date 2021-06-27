package ex07;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		
		String str = "aaabaaabbaaaaa";
        String[] result = detachString(str); 

		int posMax = max(result);
		int posMin = min(result);

		System.out.println(result[posMax].length() + " " + result[posMax] + " " + position(result, posMax));
		System.out.println(result[posMin].length() + " " + result[posMin] + " " + position(result, posMin));
	}

	public static String[] detachString(String str) {
		String[] result = new String[str.length()];
		int count = 0;
		int tmp = 1;

		while (tmp < str.length()) {
			if (str.charAt(tmp) == str.charAt(tmp-1)) {
				tmp++; 
			}
			else {
				result[count++] = str.substring(0, tmp);
				str = str.substring(tmp);
				tmp = 1;
			}

			if (tmp == str.length()) result[count++] = str.substring(0, tmp);
		}

		return Arrays.copyOfRange(result, 0, count); 
	}

	public static int max(String[] result) {
		int max = result[0].length();
		int pos = 0;
		for (int i = 0; i < result.length; ++i) {
			if (max < result[i].length()) {
				max = result[i].length();
				pos = i;
			}
		}

		return pos;
	}

	public static int min(String[] result) {
		int min = result[0].length();
		int pos = 0;
		for (int i = 0; i < result.length; ++i) {
			if (min > result[i].length()) {
				min = result[i].length();
				pos = i;
			}
		}

		return pos;
	}

	public static int position(String[] s,int pos) {
		int result = 0;

		for (int i = 0; i < pos; ++i) {
			result += s[i].length();
		}

		return result;
	}
}
