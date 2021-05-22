package ex05;

import java.util.ArrayList;
import java.util.List;


public class App {
	public static void main(String[] args) {
		List<Book> books = createNewBooks();
	    List<Book> boughtBook = new ArrayList<Book>();
	    boughtBook.add(books.get(2));
	    boughtBook.add(books.get(4));
	
	    float totalPrice = caculateTotalPrice(boughtBook);
	    System.out.println("Tong tien mua sach la: " + totalPrice);
	}
		
	private static float caculateTotalPrice(List<Book> boughtBook) {
		float sum = 0;
		for(Book book : boughtBook) {
			sum += book.getLastPrice();
		}
		return sum;
	}

	private static List<Book> createNewBooks() {
		List<Book> books = new ArrayList<Book>();
		TextBook t1 = new TextBook(BookType.SACH_GIAO_KHOA, "33", 11000, "Nhi Dong", "moi");
		TextBook t2 = new TextBook(BookType.SACH_GIAO_KHOA, "56", 43000, "Giao Duc", "moi");
		TextBook t3 = new TextBook(BookType.SACH_GIAO_KHOA, "76", 58000, "Xay Dung", "cu");
		ReferenceBook r1 = new ReferenceBook(BookType.SACH_THAM_KHAO, "23", 50500, "Nhi Dong", 0.1f);
		ReferenceBook r2 = new ReferenceBook(BookType.SACH_THAM_KHAO, "12", 34000, "Hoa Binh", 0.2f);
		
		books.add(t1);
		books.add(t2);
		books.add(t3);
		books.add(r1);
		books.add(r2);
		return books;
	}
}