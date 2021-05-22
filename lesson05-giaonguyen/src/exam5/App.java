package exam5;

public class App {
	public static void main(String[] args) {
		Book[] book = {new Textbook("SGK-1", 10, "Nhi Dong", "old"), 
				new Textbook("SGK-2", 20, "Nhi Dong", "new"),
				new Textbook("SGK-3", 70, "Giao Duc", "old"),
				new RefBook("STK-4", 300, "ABC", 0.1 ),
				new RefBook("STK-5", 150, "Nhi Dong", 0.15 )
		};
		System.out.println("The books of Nhi Dong publish company is: ");		
		for (Book bk : book) {	
			BookShopUtils.findBookByPubCom(bk);
		}

		System.out.println("\n");

		System.out.println("The bill of books has cost under 50 is: ");		
		for (Book bk : book) {	
			BookShopUtils.findBookByBill1(bk);
		}

		System.out.println("\n");

		System.out.println("The bill of books has cost under 200 and over 100 is: ");		
		for (Book bk : book) {	
			BookShopUtils.findBookByBill2(bk);
		}
		
		System.out.println("\n");
		
		System.out.println("Total bill is: " + BookShopUtils.exportTotalBill(new Book[] {new Textbook("SGK-1", 10, "Nhi Dong", "old"),
				new RefBook("STK-4", 300, "ABC", 0.1 )
		}));
	}
}
