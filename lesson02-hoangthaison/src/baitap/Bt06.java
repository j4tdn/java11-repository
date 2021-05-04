package baitap;

import java.util.Scanner;

public class Bt06 {
	public static void main (String[] args) {
	    int N = 3000;
	    
	    boolean[] check = new boolean[N + 1];
	    for (int i = 2; i <= N; i++) {
	      check[i] = true;
	    }
	 
	    for (int i = 2; i <= N; i++) {
	      if (check[i] == true) {
	        for (int j = 2 * i; j <= N; j += i) {
	          check[j] = false;
	        }
	      }
	    }
	    int k = 0;
	    for (int i = 2; i <= N; i++) {
	      if (check[i] == true) {
	    	  k++;
	      }
	      if(k == 200) {
	    	  System.out.println(i);
	    	  break;
	      }
	    }
	  }
}
