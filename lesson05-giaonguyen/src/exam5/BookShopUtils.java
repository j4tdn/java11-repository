package exam5;

public class BookShopUtils {
	public static void findBookByPubCom(Book book) {
		if (book.getPubCompany() == "Nhi Dong") {
			System.out.print(book.getBookId() + "\t");
		}
	}
	
	public static void findBookByBill1(Book book) {
		if (book.getBill() < 50) {
			System.out.print(book.getBookId() + "\t");
		}
	}
	
	public static void findBookByBill2(Book book) {
		if (book.getBill() < 200 && book.getBill() > 100) {
			System.out.print(book.getBookId() + "\t");
		}
	}
	
	public static double exportTotalBill(Book[] book) {
	
		double cost = 0.0d;
		for (Book bk : book) {
			String[] parts = bk.getBookId().split("-");
			System.out.println(parts[0] + " " + bk.getStatus());	
			if (parts[0] == "SGK") {
				if (bk.getStatus() == "old")
				{
					cost += bk.getBill()*0.7;
				}
				else cost += bk.getBill();
			}
			else cost += bk.getBill()*(1+bk.getTax());
		
		}
		return cost;
	}
} 
