package sorting;

import java.util.Arrays;
import java.util.Comparator;

import utils.ArrayUtils;


public class Ex06 {
	public static void main(String[] args) {
		String[] sequences = {"a", "b",null, "c", "e", null , "f"};
		
		Comparator<String> comparator = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				// o1: previous element
				// o2: next elements
				// compare(o1, o2) > 0 ==> swap(o1, o2)
				
				//handle null >> null first, null last
				//null first: null elements always less than not null elements
				// null last: null elements always greater than non-null elesments
				
				// Requirement: Null first
				if(o1 == null) {
					return -1;
				}
				if(o2 == null) {
					return 1;
				}
				else return 0;
			}
		};
		//Comparator
		Arrays.sort(sequences, comparator);
		ArrayUtils.printf(sequences);
		
		//Arrays.sort(sequences);
		//X[] sequences
		// Required : X implements Comparable<X>
		//Throw cannot case to Comparable<X>
		//================================================
		// Not handle null elements
		//Arrays.sort(sequences);
		/*
		Arrays.sort(sequences, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				// o1: previous
				// o2: next
				// ascending
				// compare(o1, o2) = X as below
				// positive: o1 > o2
				// zero    : o1 == o2
				// negative: o1 < o2
				
				// null first
				if(o1 == null) {
					return -1;
				}
				//01 != null
				if(o2 == null) {
					return 1;
				}
				
				return o1.compareTo(o2);
			}
		});
		*/
		//ArrayUtils.printf(sequences);
	}
	

}
