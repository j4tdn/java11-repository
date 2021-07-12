import java.util.Scanner;

public class Ex03 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Nhập độ dày của mảng: ");
		int index = Integer.parseInt(sc.nextLine());
		System.out.println("=====================");
		String[] strings = input(index);
		System.out.println("=====================");
		output(strings);
		System.out.println("\n=====================");
		System.out.println("Sắp xếp tăng dần:");
		sortAscArray(strings);
		output(strings);
		System.out.println("\n=====================");
		System.out.println("Sắp xếp giảm dần:");
		sortArrayDes(strings);
		output(strings);
		System.out.println("\n=====================");
	}

	private static void sortAscArray(String[] strings) {
		for (int i = 0; i < strings.length - 1; i++) {
			for (int j = i + 1; j < strings.length; j++) {
				if (strings[i].equals("Special")) {
					break;
				}
				if (strings[j].equals("Special")) {
					swap(strings, i, j);
					break;
				}
				if (isNumber(strings[i]) && isNumber(strings[j])) {
					if (Integer.parseInt(strings[i]) > Integer.parseInt(strings[j])) {
						swap(strings, i, j);
					}
				} else if (strings[i].compareTo(strings[j]) > 0) {
					swap(strings, i, j);
				}
			}
		}
	}

	private static void sortArrayDes(String[] strings) {
		for (int i = 0; i < strings.length / 2; i++) {
			String tmp = strings[i];
			strings[i] = strings[strings.length - i - 1];
			strings[strings.length - i - 1] = tmp;
		}
	}

	private static boolean isNumber(String strings) {
		if (strings.substring(0, 1).equals("-") && strings.length() > 1) {
			String tmp = strings.substring(1);
			if (number(tmp)) {
				return true;
			}
		} else {
			if (number(strings)) {
				return true;
			}
		}
		return false;
	}

	private static boolean number(String strings) {
		for (int i = 0; i < strings.length(); i++) {
			if (!"0123456789".contains(strings.substring(i, i + 1))) {
				return false;
			}
		}
		return true;
	}

	private static void swap(String[] strings, int i, int j) {
		String tmp = strings[i];
		strings[i] = strings[j];
		strings[j] = tmp;
	}

	private static String[] input(int index) {
		String[] strings = new String[index];
		for (int i = 0; i < index; i++) {
			strings[i] = sc.nextLine();
		}
		return strings;
	}

	private static void output(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.print(strings[i] + " ");
		}
	}
}
