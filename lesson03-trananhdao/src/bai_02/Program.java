package bai_02;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Menu n = new Menu();
		Scanner s = new Scanner(System.in);
		int chon;
		do {
			System.out.println("moi chon 1.them moi 2.inds");
			chon = Integer.parseInt(s.nextLine());
			switch (chon) {
			case 1: {
				n.themmoi();
				break;
			}
			case 2: {
				n.inDS();
				break;
			}

			}
		} while (chon != 0);

	}
}