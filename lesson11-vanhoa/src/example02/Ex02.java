package example02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import utils.ExUtils;

public class Ex02 {
	public static void main(String[] args) {
		List<DiskCD> albums = getAll();
		DiskCD cd1 = new DiskCD(4, "hip hop", "Lil Pump", 2, 450d);
		DiskCD cd2 = new DiskCD(11, "hip hop", "Chris Brown", 8, 350d);
		int key = 1;

		switch (key) {
		case 1:
			System.out.println("*** Add 1 CD to albums if not same id ***");
			addDiffCD(albums, cd2);
			addDiffCD(albums, cd1);
			System.out.println("size: " + albums.size());
			ExUtils.printf(albums);

			break;
		case 2:
			System.out.println("*** Total CD in albums ***");
			albums.add(null);
			System.out.println("total CD: " + totalDisk(albums));
			System.out.println("size: " + albums.size());

			break;
		case 3:
			System.out.println("*** Total price ***");
			System.out.println("total price: " + totalPrice(albums));

			break;
		case 4:
			System.out.println("*** Sorting by price ***");

			Comparator<DiskCD> c1 = Comparator.nullsFirst(Comparator.comparing(DiskCD::getPrice));
			sortBy(albums, c1);
			ExUtils.printf(albums);

			break;
		case 5:
			System.out.println("*** Sorting by type CD ***");

			Comparator<DiskCD> c2 = Comparator.nullsFirst(Comparator.comparing(DiskCD::getType));
			sortBy(albums, c2);
			ExUtils.printf(albums);
			System.out.println();

			break;
		default:
			break;
		}

	}

	private static List<DiskCD> getAll() {
		List<DiskCD> getDisk = new ArrayList<>();
		getDisk.add(new DiskCD(1, "rock", "The Wall", 7, 200d));
		getDisk.add(new DiskCD(3, "pop", "Bruno", 12, 300d));
		getDisk.add(new DiskCD(8, "opera", "Mozart", 8, 550d));
		getDisk.add(new DiskCD(4, "rap", "Eminem", 3, 250d));
		getDisk.add(new DiskCD(9, "bolero", "Le Quyen", 9, 100d));

		return getDisk;
	}

	private static List<DiskCD> addDiffCD(List<DiskCD> disks, DiskCD diskAdd) {

		if (!disks.contains(diskAdd)) {
			disks.add(diskAdd);
		}

		return disks;
	}

	private static int totalDisk(List<DiskCD> disks) {
		int t = 0;
		for (DiskCD disk : disks) {
			if (!(disk == null)) {
				t++;
			}
		}

		return t;
	}

	private static double totalPrice(List<DiskCD> disks) {
		double t = 0d;

		for (DiskCD disk : disks) {
			if (disk != null) {
				t += disk.getPrice();
			}
		}

		return t;
	}

	private static List<DiskCD> sortBy(List<DiskCD> disks, Comparator<DiskCD> comparator) {
		Collections.sort(disks, comparator);

		return disks;
	}

}
