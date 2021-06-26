package bt;

import java.util.Scanner;

public class Bt03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name: ");
		String name = null;
		do {
			name = scanner.nextLine();
			try {
				if (isValidName(name)) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (true);
		scanner.close();

		System.out.println("==> " + transform(name));
	}

	private static String transform(String name) {
		if (name == null) {
			return null;
		}
		String a[] = name.split(" ");
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i].substring(0, 1).toUpperCase() + a[i].substring(1).toLowerCase();
		}
		return new String().join(" ", a);
	}

	private static boolean isValidName(String name) {
		if (!name.matches("[A-Za-z\\s]+")) {
			throw new RuntimeException("Enter again!");
		}
		return true;
	}
}