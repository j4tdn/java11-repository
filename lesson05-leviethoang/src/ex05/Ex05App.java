package ex05;

public class Ex05App {
	public static void main(String[] args) {
		Store store = new Store( new TextBook[] {
			new TextBook("SGK01",50000,"Nhi Dong", true),
			new TextBook("SGK02",15000,"Tre", true),
			new TextBook("SGK03",25000,"Nhi Dong", false)}  
		, new ReferenceBooks[]{
			new ReferenceBooks("STK01", 34000, "Kim Dong", 10),
			new ReferenceBooks("STK02", 50000, "Nhi Dong", 10),
		});
		
		
	}
}
