package view;

import java.util.Scanner;

import bean.Book;
import bean.Customer;
import bean.ReferenceBook;
import bean.TextBook;

public class Ex05 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Book[] books = { new TextBook(), new TextBook(), new TextBook(), new ReferenceBook(), new ReferenceBook() };
		createData(books);
		search(books);
		find(books);
		findTextBook(books);
		buyBook(books);
	}

	private static void buyBook(Book[] books) {
		Customer cus = new Customer(1, "Hoang Thai Son", "0123456789", "KTX DMC");
		float totalMoney = 0;
		Book[] handBag = { books[0], books[1] };
		for (Book book : handBag) {
			if (book instanceof TextBook) {
				totalMoney += (float) (((TextBook) book).isStatus() == true ? book.getCost()
						: book.getCost() - book.getCost() * 0.3);
			} else {
				totalMoney += ((ReferenceBook) book).getCost() * (1 + ((ReferenceBook) book).getTax() / 100);
			}
		}
		System.out.print("Tổng tiền " + cus.getName() + " là: " + totalMoney + " VND");
	}

	private static void findTextBook(Book[] books) {
		System.out.println("toàn bộ sách giáo khoa có đơn giá từ 100 đến 200: ");
		for (Book book : books) {
			if (book.getCost() <= 200 && book.getCost() >= 100 && book instanceof TextBook) {
				System.out.println(book);
			}
		}
	}

	private static void find(Book[] books) {
		System.out.println("toàn bộ sách có đơn giá nhỏ hơn 50: ");
		for (Book book : books) {
			if (book.getCost() < 50) {
				System.out.println(book);
			}
		}
	}

	private static void search(Book[] books) {
		System.out.println("toàn bộ sách thuộc nhà xuất bản Nhi Đồng: ");
		for (Book book : books) {
			if ("Nhi Đồng".equals(book.getProducer())) {
				System.out.println(book);
			}
		}
	}

	private static void createData(Book[] books) {
		for (Book book : books) {
			if (book instanceof TextBook) {
				inputTextBook(book);
			} else {
				inputReferenceBook(book);
			}
		}
	}

	private static void input(Book book) {
		System.out.print("Nhập ID: ");
		String id = sc.nextLine();
		book.setId(id);
		System.out.print("Nhập giá: ");
		int cost = Integer.parseInt(sc.nextLine());
		book.setCost(cost);
		System.out.print("Nhập NXB: ");
		String nxb = sc.nextLine();
		book.setProducer(nxb);
	}

	private static void inputTextBook(Book book) {
		input(book);
		System.out.print("Nhập tình trạng: ");
		String status = sc.nextLine();
		((TextBook) book).setStatus("mới".equals(status) ? true : false);
	}

	private static void inputReferenceBook(Book book) {
		input(book);
		System.out.print("Nhập thuế: ");
		float tax = Float.parseFloat(sc.nextLine());
		((ReferenceBook) book).setTax(tax);
	}

}
