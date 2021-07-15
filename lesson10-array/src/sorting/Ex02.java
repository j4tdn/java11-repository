package sorting;

import utils.ArrayUtils;

public class Ex02 {
	public static void main(String[] args) {
		String[] sequences = {"a", null, "2", null, "c", "B", "0", null};
		
		// null first, null last
		for(int i = 0; i < sequences.length; i++) {
			for(int j = 0; j < sequences.length - i - 1; j++) {
				
				if(sequences[j] == null && sequences[j+1] != null) {
					swap(sequences, j , j+1);
					continue;
				}
				if(sequences[j+1] == null) {
					
					continue;
				}
				if (sequences[j].compareTo(sequences[j+1]) > 0) {
					swap(sequences, j, j+1);
				}
			}
		}
		ArrayUtils.printf(sequences);
	}
	public static void swap(String[] str, int i, int j) {
		String tmp = str[i];
		str[i] = str[j];
		str[j] = tmp;
	}

}
