package bai_02_03;

import java.util.ArrayList;

public class bai02 {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		a.add(3);
		a.add(5);
		a.add(21);
		a.add(8);
		a.add(10);
		a.add(3);
		a.add(25);
		a.add(7);
		a.add(49);
		a.add(42);
		a.add(14);
		a.add(70);
		a.add(9);
		a.add(1);
		a.add(2);

		System.out.println("phan tu trong arr la: ");
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + "  ");
		}
		System.out.println("\n sau khi chay chuong trinh:");

		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) % 7 == 0 && a.get(i) % 5 != 0) {
				arr.add(a.get(i));
			}

		}

		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) % 7 != 0 && a.get(i) % 5 != 0 || a.get(i) % 7 == 0 && a.get(i) % 5 == 0) {
				arr.add(a.get(i));
			}

		}
		for (int i = 0; i < a.size(); i++) {
			if (  a.get(i) % 5 == 0 && a.get(i)%7!=0) {
				arr.add(a.get(i));
			}

		}
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + "  ");
		}

	}

}
