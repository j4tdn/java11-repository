package bai02;

public class App {
	public static void main(String[] args) {
		Owner o1 = new Owner("Nguyen Thu Loan");
		Owner o2 = new Owner("Le Minh Tinh");
		Owner o3 = new Owner("Nguyen Minh Triet");
		
		Vehicle v1 = new Vehicle("Future Neo", 100, 350);
		Vehicle v2 = new Vehicle("Ford Ranger", 3000, 2500);
		Vehicle v3 = new Vehicle("Landscape", 1500, 350);
		
		System.out.printf("\n%-20s%-20s%10s%15s%15s\n","Ten chu xe", "Loai xe", "Dung tich", "Tri gia", "Thue");
		System.out.println("=================================================================================");
		System.out.printf("\n%-20s%-20s%10s%15s%15s\n", o1.getOwner(), v1.getModel(), v1.getCapacity(), v1.getPrice(), TaxUtil.tax(v1));
		System.out.printf("\n%-20s%-20s%10s%15s%15s\n", o2.getOwner(), v2.getModel(), v2.getCapacity(), v2.getPrice(), TaxUtil.tax(v2));
		System.out.printf("\n%-20s%-20s%10s%15s%15s\n", o3.getOwner(), v3.getModel(), v3.getCapacity(), v3.getPrice(), TaxUtil.tax(v3));
	}
}
