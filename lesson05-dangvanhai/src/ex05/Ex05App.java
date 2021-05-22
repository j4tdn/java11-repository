package ex05;

import java.util.ArrayList;

public class Ex05App {
	public static void main(String[] args) {

		ArrayList<Book> listBook = new ArrayList<Book>();
		listBook.add(new TextBook("SGK1", 35000, "Nha XB Giao Duc", true));
		listBook.add(new TextBook("SGK2", 78000, "Nha XB Tre", true));
		listBook.add(new TextBook("SGK1", 175000, "Nha XB Dai Hoc Quoc Gia", false));
		listBook.add(new ReferBook("STK1", 110000, "Nha XB Nhi Dong", 4));
		listBook.add(new ReferBook("STK2", 150000, "Nha XB Hoi Nha Van", 6));

		findNhiDong(listBook);
		findLt50(listBook);
		findTextBookFrom100to200(listBook);

		Customer customer = new Customer("KH1", "Nguyen Van A", "0335146852", "Hung Vuong, Ha Dong", null);
	}

	private static void findNhiDong(ArrayList<Book> list) {
		ArrayList<Book> result = new ArrayList<Book>();
		for (var i : list) {
			if (i.getPublisher().equals("Nha XB Nhi Dong")) {
				result.add(i);
			}
		}
		System.out.println("Nha XB Nhi Dong");
		for (var i : result) {
			System.out.println(i);
		}
	}

	private static void findLt50(ArrayList<Book> list) {
		ArrayList<Book> result = new ArrayList<Book>();
		for (var i : list) {
			if (i.calPricePay() < 50000) {
				result.add(i);
			}
		}
		System.out.println();
		System.out.println("Sach gia it hon 50000");
		for (var i : result) {
			System.out.println(i);
		}
	}

	private static void findTextBookFrom100to200(ArrayList<Book> list) {
		ArrayList<Book> result = new ArrayList<Book>();
		for (var i : list) {
			if (i.calPricePay() > 100000 && i.calPricePay() < 200000) {
				if (i.getClass().getSimpleName().equals("TextBook")) {
					result.add(i);
				}
			}
		}
		System.out.println();
		System.out.println("SGK gia tu 100-200");
		for (var i : result) {
			System.out.println(i);
		}
	}
}
