package demo;

import beans.Citizen;
import beans.Register;
import beans.Vehicle;

public class Ex02App {
	public static void main(String[] args) {
		Citizen c1 = new Citizen("01", "Nguyen Thu Loan", "123");
		Citizen c2 = new Citizen("02", "Le Minh Tinh", "243");
		Citizen c3 = new Citizen("03", "Le Van An", "345");
		
		Vehicle x1 = new Vehicle("Future Neo", 100, 35000000);
		Vehicle x2 = new Vehicle("Ford Ranger", 3000, 250000000);
		Vehicle x3 = new Vehicle("Landscape", 1500, 100000000);
		
		Register rg1 = new Register(c1, x1);
		Register rg2 = new Register(c2, x2);
		Register rg3 = new Register(c3, x3);
		
		System.out.print("Ten chu xe\t\t");
		System.out.print("Loai xe\t\t");
		System.out.print("Dung Tich\t");
		System.out.print("Tri gia\t\t");
		System.out.print("Thue phai nop");
		System.out.println("\n=============================================================================================");
	
		System.out.println(rg1);
		System.out.println(rg2);
		System.out.println(rg3);
		
		
	
	}
	
	
}
