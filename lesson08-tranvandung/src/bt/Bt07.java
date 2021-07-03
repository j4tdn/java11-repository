package bt;

public class Bt07 {
	public static void main(String[] args) {
		String str = "aaabaaabbaaaaa";
		int current = 0;
		int count = 1;
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) != str.charAt(i + 1)) {
				if (count > max) {
					max = count;
					maxIndex = current;
				}
				current = i + 1;
				count = 1;
			} else {
				count++;
			}
		}
		if (count > max) {
			max = count;
			maxIndex = current;
		}

		for (int i = maxIndex; i < maxIndex + max; i++) {
			System.out.print(str.charAt(i));
		}
		System.out.println(" maxsubstring:" + count);
	}
}
