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
		Set<CD> disks = getDisk();
		int key;
		Scanner ip = new Scanner(System.in);
		System.out.println(" Enter your Selection ");
		System.out.println(" ADD DISK CD ");
		System.out.println(" AMOUNT DISK CD ");
		System.out.println(" TOTAL PRICE ALL DISK CD ");
		System.out.println(" Sort Price Reduction ");
		System.out.println(" Sort Type CD");
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
			add(disks, new CD(8, "SweetMelody", "Taylor Switch", 3, 25.5));
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
			List<CD> afterSortPrice = sortPriceReduction(disks);
			printf(afterSortPrice);
			break;
		}
		case 5: {
			List<CD> afterSortType = sortTypeCD(disks);
			printf(afterSortType);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}
	}

	private static List<CD> sortTypeCD(Set<CD> disks) {
		List<CD> listDisk = new ArrayList<CD>(disks);
		listDisk.sort(comparing(CD::getTypeCD));
		return listDisk;
	}
	private static List<CD> sortPriceReduction(Set<CD> disks) {
		List<CD> listDisk = new ArrayList<CD>(disks);
		listDisk.sort(comparing(CD::getPrice).reversed());
		return listDisk;
	}

	private static double totalPrice(Set<CD> disks) {
		double result = 0d;
		for (CD disk : disks) {
			result += disk.getPrice();
		}
		return result;
	}

	private static int diskAmount(Set<CD> disks) {
		return disks.size();
	}

	private static boolean add(Set<CD> disks, CD diskAdd) {
		Objects.requireNonNull(disks);
		return disks.add(diskAdd);
	}

	private static Set<CD> getDisk() {
		Set<CD> disks = new HashSet<>();
		disks.add(new CD(1, "Nhac tre", "Son Tung MTP", 3, 25.5));
		disks.add(new CD(2, "Hien dai", "Ung Hoang Phuc", 2, 45.5));
		disks.add(new CD(3, "Nhac rap", "Karik", 5, 40.5));
		disks.add(new CD(4, "Pop", "Raccy", 1, 30.2));
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
