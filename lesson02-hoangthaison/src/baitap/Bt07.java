package baitap;

import java.util.Random;

public class Bt07 {
	public static void main(String[] args) {
	       int[] temp = bt07(20, 30, 5);
	       for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
	       }
	    }
	    public static int[] bt07(int start, int end, int count) {
	        Random rng = new Random();

	        int[] result = new int[count];
	        int cur = 0;
	        int remaining = end - start;
	        for (int i = start; i < end && count > 0; i++) {
	            double probability = rng.nextDouble();
	            if (probability < ((double) count) / (double) remaining) {
	                count--;
	                result[cur++] = i;
	            }
	            remaining--;
	        }
	        return result;
	    }
}
