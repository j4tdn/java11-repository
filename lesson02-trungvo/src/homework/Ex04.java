package homework;

import java.util.Scanner;

public class Ex04 {
	static 
	Scanner ip = new Scanner(System.in);
	public static void main(String[] args) {
		int[] data = new int[10];
		nhapMang(data);
		System.out.println("so le lon nhat la: " + findMax(data));
	}
		
	
	private static int findMax(int[] data) {
		int max = data[0];
		for (int i =0; i< data.length; i++) {
			if(data[i]%2!=0) {
				if(data[i]> max) {
					max = data[i];
				}
			}
		} return max;
	}
	

	
	
	private static void nhapMang(int[] data) {
		System.out.println("nhap mang: ");
		for(int i = 0; i< data.length; i++) {
			System.out.println("data[" +i+ "]= ");
			
			data[i] = ip.nextInt();
		}
	}
}
