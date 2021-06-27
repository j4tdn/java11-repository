package ex07;

public class App {
	public static void main(String[] args) {
		String str = "aaabaaabbbaaaaa";
		char firstCharAt = str.charAt(0);
		String[] subString = new String[20];
		int count = 0;
		String tmp = "";
		tmp = tmp + firstCharAt;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == firstCharAt) {
				tmp = tmp + str.charAt(i);
				if (i == str.length() - 1) {
					subString[count++] = tmp;
					break;
				}
				continue;
			}
			subString[count++] = tmp;
			firstCharAt = str.charAt(i);
			tmp = "" + firstCharAt;
			if (i == str.length() - 1) {
				subString[count++] = "" + str.charAt(i);
				break;
			}
		}

		/**
		 * find string max & string small of subString
		 */
		int maxChar = subString[0].length();
		int minChar = subString[0].length();
		for (String item : subString) {
			if (item == null) {
				break;
			}
			if (item.length() > maxChar)
				maxChar = item.length();
			if (item.length() < minChar)
				minChar = item.length();
		}

		/**
		 * print string max & string small of subString
		 */
		for (String item : subString) {
			if (item == null)
				break;
			if (item.length() == maxChar) {
				System.out.print(maxChar + " ");
				System.out.println(item);
			}
			if (item.length() == minChar) {
				System.out.print(minChar + " ");
				System.out.println(item);
			}
		}
	}
}
