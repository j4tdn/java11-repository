package sorting;

import java.util.Arrays;
import java.util.Comparator;

import utils.ArrayUtils;

public class Ex06 {
	public static void main(String[] args) {
		String[] sequences = { "a", null, "d", "c", "b", null, "e" };
		// null null "" "" >> null first
		// "" "" null null >> null last
		
		Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// o1: previous element
				// o2: next elements
				// compare(o1, o2) > 0 ==> swap(o1, o2)
				
				// handle null >> null first, null last
				// null first: null elements always less than non-null elements
				// null last : null elements always greater than non-null elements
				
				// Requirement: NULL FIRST
				if (o1 == null) {
					return -1; // o1=null >> cho o1<o2
				}
				
				// o1 != null
				if (o2 == null) {
					return 1; // o2=null >> cho o1>o2
				}
				
				// o1!=null
				// o2!=null
				return o1.compareTo(o2);
			}
		};
		
		// Comparator
		Arrays.sort(sequences, comparator);
		ArrayUtils.printf(sequences);
		
		
		// Comparable
		
		// X[] sequences
		// Required: X implements Comparable<X>
		// >> incompatible with java.lang.Comparable
		// Arrays.sort(sequences); 
		// ArrayUtils.printf(sequences);
		
		// Tuple no implementation from Comparable
		// Tuple[] tuples = {new Tuple(5, 2), new Tuple(2,3)};
		// Arrays.sort(tuples); 
		// System.out.println(tuples);
	}

}