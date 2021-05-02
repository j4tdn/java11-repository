
import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
//		System.out.println("result: " + FindMaxOdd());
		int result = FindMaxOdd();
		if (result != Integer.MIN_VALUE) {
			System.out.println("Result = " + result);
		} else {
			System.out.println("Not exists odd number");
		}
	}

	private static int FindMaxOdd() {
		int max = Integer.MIN_VALUE;
		Scanner rd = new Scanner(System.in);
		String str = rd.nextLine();

		for (int i = 0; i < str.length(); i++) {
			if (!(Character.isDigit(str.charAt(i)))) {
				continue;
			}
			for (int j = i + 1; j <= str.length(); j++) {
				if (j == str.length() || (!Character.isDigit(str.charAt(j)))) {
					int temp = Integer.parseInt(str.substring(i, j));
					max = (temp % 2 == 1 && max < temp) ? temp : max;
					i = j - 1;
					break;
				}
				if (j == str.length())
					return max;
			}
		}

		return max;
	}
}
