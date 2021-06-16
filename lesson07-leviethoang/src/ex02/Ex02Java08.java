package ex02;

import java.time.LocalDateTime;
import java.util.Scanner;

import utils.DateException;
import utils.DateUtils;
import utils.LocalDateTimeUtils;

public class Ex02Java08 {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		LocalDateTime dateStart = LocalDateTime.of(2021, 3, 8, 10, 20, 10);
		LocalDateTime dateEnd = LocalDateTime.now();
		System.out.println("Are you break up ? ");
		System.out.println("Enter 1 for YES || 2 for NO");
		int chon;
		while (true) {
			chon = Integer.parseInt(ip.nextLine());
			if (chon == 1 || chon == 2) {
				break;
			}
			System.out.println("Enter 1 for YES || 2 for NO");
		}
		switch (chon) {
		case 1: {
			dateEnd = LocalDateTime.of(2022, 3, 6, 8, 22, 30);
			break;
		}
		case 2: {
			break;
		}
		default:
			return;
		}

		System.out.println(LocalDateTimeUtils.between(dateStart, dateEnd));
	}
}
