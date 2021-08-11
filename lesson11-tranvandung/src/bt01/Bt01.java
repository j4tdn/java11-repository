package bt01;

import java.util.Scanner;

public class Bt01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		int n = ip.nextInt();
		int col=0;
		int row=0 ;
		int [][] array = new int [row][col];
		for (int row = 0; row < w.length; row++) {
			for (int col = 0; col < w[row].length; col++) {
				System.out.print(w[row][col] + " ");
			}
			System.out.println(); // break line
		}
	}
}
