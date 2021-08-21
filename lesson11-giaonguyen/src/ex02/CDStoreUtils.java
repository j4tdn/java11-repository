package ex02;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class CDStoreUtils {
	private CDStoreUtils() {

	}

	public static <E> boolean addCD(Set<E> e, E CD) {
		Objects.requireNonNull(CD);
		if (e.add(CD) == true)
			return true;
		else 
			return false;
	}

	public static <E> int getMountOfCD(Set<E> e) {
		Objects.requireNonNull(e);		
		return e.size();
	}
	
	public static int getTotalPrice(Set<CDStore> CDs) {
		Objects.requireNonNull(CDs);
		int result = 0;
		for (CDStore CD: CDs) {
			result += CD.getPrice();
		}
	
		return result;
	}
	
	public static void sortByPrice(Set<CDStore> CDs) {
		Comparator<CDStore> comp = Comparator.comparing(CDStore::getPrice).reversed();
		Set<CDStore> result = new TreeSet<>(comp);
		for (CDStore cd: CDs) {
			result.add(cd);
		}
		for (CDStore cd: result) {
			System.out.println(cd);
		}
	}
	
	public static void sortByType(Set<CDStore> CDs) {
		Comparator<CDStore> comp = Comparator.comparing(CDStore::getType);
		Set<CDStore> result = new TreeSet<>(comp);
		for (CDStore cd: CDs) {
			result.add(cd);
		}
		for (CDStore cd: result) {
			System.out.println(cd);
		}
	}
}
