package ex03;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao 1 chuoi: ");
		String s = sc.nextLine();
		permutation(s.toCharArray(), 0, s.length()-1);
	}

	 private static void permutation(char[] arr, int startIndex, int endIndex) {
	        if(startIndex == endIndex){
	            System.out.println(String.valueOf(arr));
	        }else{
	            for(int i=startIndex;i<=endIndex;i++) {
	                 swap(arr, startIndex, i );
	                 permutation(arr, startIndex+1, endIndex);
	                 swap(arr, startIndex, i );
	            }
	        }
	 }

	 private static void swap(char[] arr, int x, int y) {
	        char temp = arr[x];
	        arr[x] = arr[y];
	        arr[y] = temp;
	 }
	

}
