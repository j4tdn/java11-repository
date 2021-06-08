package ex05;

public class App {
	public static void main(String[] args) {
		Book[] books = getAll();
	}
	
	private static void show(Book[] books) {
		for(Book book:books) {
			System.out.println(book);
		}
	}
	
	private static Book[] getAll() {
		Book t1 = new TextBook("SGK01", 20, "AUCO", Status.NEW);
		Book t2 = new TextBook("SGK02", 10, "NhiDong", Status.NEW);
		Book t3 = new TextBook("SGK03", 50, "VietNam", Status.OLD);
		
		Book r1 = new ReferenceBook("STK1", 12, "NhiDong", 6);
		Book r2 = new ReferenceBook("STK2", 10, "CongAn", 2);
		
		return new Book[]{t1,t2,t3,r1,r2};
		
	}
}
