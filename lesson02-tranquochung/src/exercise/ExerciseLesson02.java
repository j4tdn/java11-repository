package exercise;

import java.util.Random;
import java.util.Scanner;

public class ExerciseLesson02 {
	public static void main(String[] args) {
		// 1
		System.out.println("=== Exercise 1 ===");
		if (exercise1(16))
			System.out.println("is the power of 2");
		else
			System.out.println("is not the power of 2");

		// 2
		System.out.println("=== Exercise 2 ===");
		System.out.println("Gai thua : " + exercise2(4, 7, 12, 18));

		// 3
		System.out.println("=== Exercise 3 ===");
		if (exercise3()) {
			System.out.println("la so doi xung");
		} else {
			System.out.println("khoong la so doi xung");
		}

		// 4
		System.out.println("=== Exercise 4  ===");
		System.out.println(exercise4());

		// 5
		System.out.println("=== Exercise 5 ===");
		System.out.println(exercise5());

		// 6
		System.out.println("=== Exercise 6 ===");
		System.out.println(exercise6(200));

		// 7
		System.out.println("=== Exercise 7 ===");
		exercise7(20, 30);
	}

	// exercise 1
	private static boolean exercise1(int number) {
		int tmp = 2;
		while (true) {
			if (tmp > number)
				return false;
			if (tmp == number)
				return true;
			if (tmp < number)
				tmp *= 2;
		}
	}

	// exercise 2
	private static long exercise2(int number1, int number2, int number3, int number4) {
		long tong = exercise2Inherit(number1) + exercise2Inherit(number2) + exercise2Inherit(number3)
				+ exercise2Inherit(number4);
		return tong;
	}

	// exercise 2 - find inherit
	private static long exercise2Inherit(int number) {
		long tmp = 1;
		for (int i = 2; i <= number; i++) {
			tmp *= i;
		}
		return tmp;
	}

	// exercise 3
	private static boolean exercise3() {
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter number = ");
		int n = ip.nextInt();
		int tmp = n % 10;
		for (int i = n / 10; i > 0; i /= 10) {
			tmp = tmp * 10 + i % 10;
		}
		if (tmp != n)
			return false;
		return true;
	}

	// exercise 4
	private static int exercise4() {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap so phan tu = ");
		int n = ip.nextInt();
		int oddmax = 0;
		int tmp;
		for (int i = 0; i < n; i++) {
			System.out.print("Enter number = ");
			tmp = ip.nextInt();
			if (odd(tmp)) {
				if (oddmax < tmp)
					oddmax = tmp;
			}
		}
		return oddmax;
	}

	// exercise 4- odd
	private static boolean odd(int number) {
		if (number % 2 == 0)
			return false;
		return true;
	}

	// exercise 5
	private static String exercise5() {
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter number = ");
		int n = ip.nextInt();
		return Integer.toBinaryString(n);
	}

	// exercise 6
	private static int exercise6(int n) {
		int dem = 0;
		int number = 2;
		while (dem < n) {
			if (checknt(number))
				dem++;
			number++;
		}
		return number - 1;
	}

	// ex6 checknt
	private static boolean checknt(int n) {
		int count = 0;
		if (n < 2) {
			return false;
		}
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	// exercise 7
	private static int[] exercise7(int rdfirst, int rdend) {
		Random rd = new Random();
		int[] listnumber = new int[5];
		int i = 0;
		int number;
		do {
			// random one number
			number = rdfirst + rd.nextInt(rdend - rdfirst);
			// check list
			if (check(number, listnumber, i)) {
				listnumber[i] = number;
				System.out.println("number " + i + " = " + listnumber[i]);
				i++;
			}
		} while (i < 5);
		return listnumber;
	}

	// exercise7--check
	private static boolean check(int n, int[] list, int nollnull) {
		for (int i = 0; i < nollnull; i++) {
			if (list[i] == n)
				return false;
		}
		return true;
	}
}
