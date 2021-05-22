package exercise5;

public class App {
	public static void main(String[] args) {
		TextBook t1 = new TextBook("01", 20000, "Kim Dong", true);
		TextBook t2 = new TextBook("02", 15000, "Nhi Dong", true);
		TextBook t3 = new TextBook("03", 10000, "Thanh Nien", true);
		
		ReferenceBook r1 = new ReferenceBook("04", 13000, "Nhi Dong", 10);
		ReferenceBook r2 = new ReferenceBook("05", 10000, "Nhi Dong", 9);
		
		Book[] book = new Book[5];
		book[0] = t1;
		book[1] = t2;
		book[2] = t3;
		book[3] = r1;
		book[4] = r2;
	}
	public Book[] isNhiDongPublisher(Book[] book) {
		int n = 0;
		int j = 0;
		for(int i = 0; i <= book.length; i++) {
			if((book[i].getPublisher()).equals("Nhi Dong")) {
				++n;
			}
		}
		Book[] nhiDongBook = new Book[n];
		for(int i = 0; i <= book.length; i++) {
			if((book[i].getPublisher()).equals("Nhi Dong")) {
				nhiDongBook[j++] = book[i];
			}
		}
		return nhiDongBook;
	}
	public Book[] bookValueSmaller50(Book[] book) {
		int n = 0;
		int j = 0;
		for(int i = 0; i <= book.length; i++) {
			if((book[i].getPrice() < 50)) {
				++n;
			}
		}
		Book[] tempBookList = new Book[n];
		for(int i = 0; i <= book.length; i++) {
			if((book[i].getPrice() < 50)) {
				tempBookList[j++] = book[i];
			}
		}
		return tempBookList;
	}
	public Book[] bookValueFrom100To200(Book[] book) {
		int n = 0;
		int j = 0;
		for(int i = 0; i <= book.length; i++) {
			if((100 <= book[i].getPrice() && book[i].getPrice() <= 200 )) {
				++n;
			}
		}
		Book[] tempBookList = new Book[n];
		for(int i = 0; i <= book.length; i++) {
			if((100 <= book[i].getPrice() && book[i].getPrice() <= 200)) {
				tempBookList[j++] = book[i];
			}
		}
		return tempBookList;
	}
}
