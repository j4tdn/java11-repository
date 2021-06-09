package homework;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exericise4 {
	private static String[] num = { "không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín", "mười" };

	public static void main(String[] args) {

		int n = input();
		readNum(n);

	}

	public static int input() {
		int n;
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.print("Enter n: ");
				n = sc.nextInt();
				if (!String.valueOf(n).matches("^[0-9]{1,3}$")) {
					throw new RuntimeException();
				}
				return n;
			} catch (Exception e) {
				System.out.println("Number is invalid! Please enter again!");
			}
		}
	}

	public static void readNum(int n) {
		String strnum = String.valueOf(n);
		String strNumReversed = "";
		String result = "";
		StringBuilder sb;
		int count = 0;
		// Add 0 to create 3 digits in numbers
		if (strnum.length() == 1) {
			strnum = "00" + strnum;
		}
		if (strnum.length() == 2) {
			strnum = "0" + strnum;
		}
		// Reverse number
		for (int i = strnum.length() - 1; i >= 0; i--) {
			strNumReversed += strnum.charAt(i);
		}
		n = Integer.parseInt(strNumReversed);

		while (count <= 3) {
			++count;
			int tmp = n % 10;
			n = n / 10;
			switch (count) {
			case 1: // Handle hundres
				if (tmp >= 1) {
					result += num[tmp] + " trăm";
					continue;
				}
				break;
			case 2: // Hanle handle dozens
				if (tmp == 0 && result != "" && n % 10 != 0) {
					result += " lẻ";
					continue;
				}
				if (tmp == 1) {
					result += " mười";
					continue;
				}

				if (tmp >= 2) {
					result += " " + num[tmp] + " mươi";
					continue;
				}
				break;
			default: // Handle unit
				if (tmp == 0 && result.isEmpty()) {
					result += "không";
					continue;
				}
				if (tmp == 1 && (result.contains("lẻ") || result.contains("mười") || result.isEmpty())) {
					result += " một";
					continue;
				}
				if (tmp == 1) {
					result += " mốt";
					continue;
				}
				if (tmp == 5) {
					result += " lăm";
					continue;
				}
				if (tmp >= 2) {
					result += " " + num[tmp];
					continue;
				}
				break;
			}
		}
		sb = new StringBuilder(result.trim());
		char c = sb.charAt(0);
		sb.setCharAt(0, (char) (sb.charAt(0) - 32));
		System.out.println(sb);
	}
}
