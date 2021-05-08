package homework1;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Scanner;
public class Ex04 {	
	 static Scanner ip = new Scanner(System.in);
	 public static void main(String[] args) {
		int[] array = new int[10];
		inArray(array);
		System.out.println("so le lon nhat la: " + findMax(array));
		System.out.println("so le lon nhi la:" + findnearMax(array));
	}
	 private static int findMax(int[] array) {
		 int max = 0;
		 for( int i =0; i< array.length; i++) {
			 if (array[i]%2!=0) {
				 if (array[i] >max) {
				 max = array[i];
			 }
			}
		 }
		 return max;
	 }
	 
	 private static int findnearMax(int[] array) {
		 int nearMax= 0;
		 int maxLe = findMax(array);
		 for (int i =0; i < array.length; i++) {
			 if (array[i]%2 != 0 && array[i] < maxLe) {
				 nearMax = array[i];
			 }
		 }
		 return nearMax;
	 }
	 
	 
	 
	 private static void inArray(int[] array) {
		 System.out.println("nhap mang: ");
		 for(int i= 0; i< array.length; i++) {
			 System.out.println("array[" +i+ "]= " );
			 array[i] = ip.nextInt();
		 }
		
	 }
	 
	 
}