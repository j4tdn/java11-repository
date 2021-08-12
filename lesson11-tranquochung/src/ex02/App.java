package ex02;

import java.util.ArrayList;
import java.util.Comparator;
import static java.util.Comparator.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class App {
	public static void main(String[] args) {
		Set<DiskCD> disks = getDisk();
		int key;
		Scanner ip = new Scanner(System.in);
		System.out.println("<<=== Enter your Selection ===>>");
		System.out.println("1: <<=== ADD DISK CD ===>>");
		System.out.println("2: <<=== AMOUNT DISK CD ===>>");
		System.out.println("3: <<=== TOTAL PRICE ALL DISK CD ===>>");
		System.out.println("4: <<=== Sort Price Reduction ===>>");
		System.out.println("5: <<=== Sort Type CD===>>");
		while (true) {
			try {
				System.out.print("Enter key = ");
				key = Integer.parseInt(ip.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		}

		switch (key) {
		case 1: {
			add(disks, new DiskCD(8, "SweetMelody", "Taylor Switch", 3, 25.5));
			printf(disks);
			break;
		}
		case 2: {
			System.out.println("Result = " + diskAmount(disks));
			break;
		}
		case 3: {

			System.out.println("Result = " + totalPrice(disks));
		}
		case 4: {
			List<DiskCD> afterSortPrice = sortPriceReduction(disks);
			printf(afterSortPrice);
			break;
		}
		case 5: {
			List<DiskCD> afterSortType = sortTypeCD(disks);
			printf(afterSortType);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}
	}

	private static List<DiskCD> sortTypeCD(Set<DiskCD> disks) {
		List<DiskCD> listDisk = new ArrayList<DiskCD>(disks);
		listDisk.sort(comparing(DiskCD::getTypeCD));
		return listDisk;
	}

	private static List<DiskCD> sortPriceReduction(Set<DiskCD> disks) {
		List<DiskCD> listDisk = new ArrayList<DiskCD>(disks);
		listDisk.sort(comparing(DiskCD::getPrice).reversed());
		return listDisk;
	}

	private static double totalPrice(Set<DiskCD> disks) {
		double result = 0d;
		for (DiskCD disk : disks) {
			result += disk.getPrice();
		}
		return result;
	}

	private static int diskAmount(Set<DiskCD> disks) {
		return disks.size();
	}

	private static boolean add(Set<DiskCD> disks, DiskCD diskAdd) {
		Objects.requireNonNull(disks);
		return disks.add(diskAdd);
	}

	private static Set<DiskCD> getDisk() {
		Set<DiskCD> disks = new HashSet<>();
		disks.add(new DiskCD(1, "SweetMelody", "Taylor Switch", 3, 25.5));
		disks.add(new DiskCD(2, "Pop", "justin bieber", 2, 50.5));
		disks.add(new DiskCD(3, "Pop", "selena gomez", 5, 25.5));
		disks.add(new DiskCD(4, "SweetMelody", "ariana grande", 4, 30.5));
		disks.add(new DiskCD(5, "Pop", "Charlie Puth", 1, 28.5));
		disks.add(new DiskCD(6, "SweetMelody", "Michael Jackson", 3, 25.8));
		return disks;
	}

	private static <E> void printf(Set<E> elements) {
		for (E e : elements) {
			System.out.println(e);
		}
	}

	private static <E> void printf(List<E> elements) {
		for (E e : elements) {
			System.out.println(e);
		}
	}
}
