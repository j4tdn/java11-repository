package ex07;

public class Ex07 {
	public static void main(String[] args) {
		String s = "aaabaaabbaaaaaaa";
		String[] arr = { "a", "a", "a", "b", "a", "a", "a", "b", "b", "a", "a", "a", "a", "a", "a", "a" };
		int l = s.length();
		
		String[] str = new String[l * l];
		String[] strs = new String[l * l * l * l];
		
		int c = 0;
		int d = 0;

		for (int i = 0; i <= s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				if (s.contains(s.substring(i, j))) {
					str[c++] = s.substring(i, j);
				}
			}
		}

		for (String st : str) {
			for (int i = 0; i < s.length(); i++) {
				if (st != null && st.matches(arr[i] + "+") == true) {
					strs[d++] = st;
				}
			}
		}
		
		int max = strs[0].length();
		int min = strs[0].length();
		
		for (String z : strs) {
			if (z != null && z.length() > max) {
				max = z.length();
			}

		}

		for (String z : strs) {
			if (z != null && z.length() < min) {
				min = z.length();
			}
		}
		
		System.out.println("Do dai lon nhat : " + max);
		System.out.println("Do dai nho nhat : " + min);
	}
}
