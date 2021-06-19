package ex01;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = {3,19,21,0,15,17,21};
		int [] uniqueArray = getUniqueElements(digits);
		
		sort(uniqueArray);
		printf(digits);
		System.out.println("\n===========");
		printf(uniqueArray);
	}
	
	private static int []getUniqueElements(int[] elements){
		//fixed-length
		int[] result = new int[elements.length];
		boolean[] isDupFlags = new boolean[elements.length];
		//iterate an array with 2 ways
		//for index
		//for each 1 2 4 1 3 2
		for (int out =0; out < elements.length; out++) {
			for(int in =0; in <elements.length; in++ ) {
				if (!isDupFlags[out]) {
					if(out != in && elements[out] == elements[in]) {
						isDupFlags[out] = true;
						isDupFlags[in] = true;
					}
				}
			}
		}
		//iterate an array with 2 ways
		//for index  T T F F T F T T : flags
		//for each   1 2 4 O 1 3 2 1 : elements
		//result     0 0 0 O 0 0 0 0
		//           4 O 3 0 0 0 0 0
		int count = 0;
		for(int i = 0; i<elements.length; i++) {
			if(!isDupFlags[i]) {
				result[count] =elements[i];
				count++; //count =3
			}
		}
		
		return Arrays.copyOfRange(result, 0, count);
	}
	private static void printf (int[] elements) {
		for (int element: elements) {
			System.out.print(element + " ");
		}
	}
	private static void sort(int[] elements) {
		// 0 19 7  5 3
		//           19
		//        17 19
		//     15 17 19
		//bubble sort: sap sep noi bot
		//after a loop => a bubble element will be selected
		for(int out = elements.length-1; out > 0; out--) {
			for(int in =0; in <= out; in++) {
				if(elements[in] > elements[out]) {
					int tmp = elements[in];
					elements[in] = elements[out];
					elements[out] = tmp;
				}
			}
		}
		
	}
	
}
