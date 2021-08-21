package ex02;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class App {
	public static void main(String[] args) {
		//		Comparator<CDStore> comp = Comparator.comparing(CDStore::getPrice).reversed();
		Set<CDStore> CD = new TreeSet<>();

		CD.add(new CDStore(3, "A", "Adele", 5, 12));
		CD.add(new CDStore(1, "X", "Taylor", 4, 10));
		CD.add(new CDStore(2, "C", "Justin", 7, 20));
		CD.add(new CDStore(7, "E", "Giao", 8, 17));

		if (CDStoreUtils.addCD(CD, new CDStore(2, "B", "Taylor", 4, 10)) == true) {
			System.out.println("Add CD successfully!");
		} else {
			System.out.println("Add CD fail due to duplicate the ID");
		}

		System.out.println("Mount of CDs: " + CDStoreUtils.getMountOfCD(CD));

		System.out.println("Total price of CDs: " + CDStoreUtils.getTotalPrice(CD));
		
		System.out.println("===Sort by Price decreasing===");
		CDStoreUtils.sortByPrice(CD);
		System.out.println("===Sort by Type increasing===");
		CDStoreUtils.sortByType(CD);

	}
}
