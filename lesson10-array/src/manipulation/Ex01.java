package manipulation;

import java.util.Arrays;

import bean.Tuple;
import utils.ArrayUtils;

public class Ex01 {
	/**
	 * Ex01: Give an array int[] = {1, 9, 5, 36, 12, 33}; With k from 0 - (length-1)
	 * + Calculate sum of odd numbers + Find max, min in one loop + Add element to
	 * index k + Remove element from index k +Update element at index k
	 */
	public static void main(String[] args) {
		int[] ditgits = { 1, 9, 5, 36, 12, 33 };
		
		int[] inserted = add(ditgits, 15, 1);
		ArrayUtils.printf(inserted);
		
		int[] remove = remove(ditgits, 2);
		ArrayUtils.printf(remove);
	}

	private static int sum(int[] ditgits) {
		int sum = 0;
		for (int ditgit : ditgits) {
			if (ditgit % 2 != 0) {
				sum += ditgit;
			}
		}
		return sum;
	}

	private static Tuple getMaxMin(int[] ditgits) {
		if (ditgits.length == 0) {
			throw new IllegalArgumentException("Difits array shoul not be empty");
		}
		int max = ditgits[0];
		int min = ditgits[0];
		for (int ditgit : ditgits) {
			if (max < ditgit) {
				max = ditgit;
			}
			if (min > ditgit) {
				min = ditgit;
			}
		}
		return new Tuple(max, min);
	}

		// shift right: loop from RIGHT to LEFT
		//       left :           LEFT     RIGHT
		// pos = 2 >< newElement = 15
		// 1, 9, 5, 36, 12, 33      origin
		// 1, 9, 5, 36, 12, 33, 0   B1: copy
		// 1, 9, 5,  5, 36, 12, 33  B2: shift right one unit
		
		// 1, 9, 15, 5, 36, 12, 33  expected result
	private static int[] add(int[] origin, int newElement, int pos) {
		int[] result = new int[origin.length + 1];
		//copy
		for (int i = 0; i < origin.length; i++) {
			result[i] = origin[i];
		}
		//shift right one unit
		for (int i =result.length-1; i > pos ; i--) {
			result[i] = result[i-1];
		}
		//assign newElement
		result[pos] = newElement;
		return result;
		
//		for (int i = 0; i < pos; i++) {
//			result[i] = origin[i];
//		}
//		result[pos] = newElement;
//		for (int i = pos+1; i < result.length; i++) {
//			result[i] = origin[i-1];
//		}
	}
	private static int[] remove(int[] origin, int pos) {
		int [] tmp = Arrays.copyOfRange(origin, 0, origin.length);
		
		for(int i =pos; i< origin.length-1; i++ ) {
			tmp[i] = tmp[i+1];
		}
	
		return Arrays.copyOfRange(origin, 0, origin.length-1);
	}
	
	
}
