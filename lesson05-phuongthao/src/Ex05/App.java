package Ex05;

public class App {
	public static void main(String[] args) {

		Book[] books = getAll();
		getBooks(books, "Nhi Dong");
		
		show(books);
	}

	private static Book[] getBooks(Book[] books, String publisher) {
		Book[] result = new Book[books.length];
		int i = 0;
		for (Book book : books) {

			if (book.getPublisher().contains(publisher)) {
				result[i++] = book;
			}

		}
		Book[] actualResult = new Book[i];
		for(int ic= 0; ic<actualResult.length;ic++) {
			actualResult[ic] = result[ic];
		}
		return actualResult;
	}
	
	private static void show(Book[] books) {
		for(Book book: books) {
			System.out.println(book);
		}
	}

	private static Book[] getAll() {
		Book t1 = new TextBook("SGK01", 20, "Au Co", Status.NEW);
		Book t2 = new TextBook("SGK02", 20, "Nhi Dong", Status.NEW);
		Book t3 = new TextBook("SGK03", 20, "Nhi Dong", Status.OLD);
		Book t4 = new TextBook("SGK04", 20, "Viet Nam", Status.OLD);
		Book t5 = new TextBook("SGK05", 20, "Au Co", Status.NEW);

		Book r1 = new ReferenceBook("STK01", 68, "Nhi Dong", 6);
		Book r2 = new ReferenceBook("STK01", 68, "Nhi Dong", 6);
		Book r3 = new ReferenceBook("STK01", 68, "Nhi Dong", 6);
		Book r4 = new ReferenceBook("STK01", 68, "Nhi Dong", 6);
		Book r5 = new ReferenceBook("STK01", 68, "Nhi Dong", 6);

		return new Book[] { t1, t2, t3, t4, t5, r1, r2, r3, r4, r5 };
	}

}
