package baitap;

import java.util.Scanner;

public class Bt04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap n: ");
		int n = sc.nextInt();
		Digit[] arr = new Digit[n]; // 3 null, null, null
		for(int i= 0; i<n;i++) {
			System.out.println("arr[" + i + "] = ");
			arr[i] = new Digit(sc.nextInt());
			
			
		}
		System.out.println("So le lon nhat: "+ find(arr,n));
	}
	private static int find ( Digit[] arr, int n) {
		int k=0;
          for(int i = 0 ; i < n ; i++) {
        	  for(int j = i+1 ; j < n ; j++) {
        	     if(arr[j].value > arr[i].value) {
        		     swap(arr[i],arr[j]);
        	     }
        	  }
          }
          for(int i = 0 ; i < n ; i++) {
        	  if((arr[i].value % 2) == 1)
        		  k = arr[i].value;
          }
		  return k;
		
	}
	private static void swap(Digit a, Digit b ) {
		int temp = a.value;
		a.value = b.value;
		b.value= temp;
	}

}
