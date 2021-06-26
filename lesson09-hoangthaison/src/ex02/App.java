package ex02;

import java.util.Scanner;

public class App {
	private static int n;
	
	public static void main(String[] args) {
		
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Nhap n");
		int n = Integer.parseInt(sc.nextLine());
		String text[] = new String[n];
		for(int i = 0; i < n; i++) {		
			text[i] = sc.nextLine();
		}
		for(int i = 0; i< n; i++) {
			check(text[i]);
		}
		*/
		check("4545sdasdf4433d33233223");
	}
	private static void check(String text) {
        String regex = "[^\\d]+";

        int[] isDigit = new int[text.length()];
        
        String[] str = text.split(regex);
        System.out.println("K");
        for(int i = 0; i < str.length; i++) {
        	isDigit[i] = Integer.parseInt(str[i]);
        }
        System.out.println(maximum(isDigit));
        
	}
	private static int maximum(int[] number) {
		int max =number[0];
		for(int i = 0; i<number.length; i++) {
			if(number[i] > max ) {
				max = number[i];
			}
		}
		return max;
	}



}
