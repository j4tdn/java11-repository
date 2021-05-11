package bai02;

public class DanhSach {
      public static void main(String[] args) {
		
    	Customer c1 = new Customer("Nguyen Thu Loan");
		Customer c2 = new Customer("Le Minh Tinh");
		Customer c3 = new Customer("Nguyen Minh Triet");
		
		Vehicle v1 = new Vehicle("Future Neo", 100, 35000000);
		Vehicle v2 = new Vehicle("Ford Ranger", 3000, 250000000);
		Vehicle v3 = new Vehicle("Landscape", 1500, 1000000);
		
		System.out.println("Ten chu xe\tLoai xe \t Dung Tich\tTri Gia \t "+ "" + "Thue phai nop");
		System.out.println("================================================================="
				+ "");
		System.out.println(
		c1.toString()+  
		v1.toString()+ "\n" +
		c2.toString()+  
		v2.toString()+ "\n" +
		c3.toString()+  
		v3
		.toString()
		);
	}
}
