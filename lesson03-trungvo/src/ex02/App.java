package ex02;

public class App {
	public static void main(String[] args) {
		Customer c1 = new Customer("Nguyen Thu Loan");
		Customer c2 = new Customer("Le Minh Tinh");
		Customer c3 = new Customer("Nguyen Minh Triet");
		
		Vehicle v1 = new Vehicle("Future Neo", 35000000, 100);
		Vehicle v2 = new Vehicle("Ford",  250000000, 3000 );
		Vehicle v3 = new Vehicle("Landscape", 100000000, 1500);
		
		Register r1 = new Register(c1,v1);
		Register r2 = new Register(c2,v2);
		Register r3 = new Register(c3,v3);
		
		System.out.print("Ten chu xe\t\t");
		System.out.print("Loai xe\t\t");
		System.out.print("Dung tich\t");
		System.out.print("Tri gia\t\t");
		System.out.print("Thue");
		System.out.println("\n===================================================================");
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
	}
}
