package bt2;
import bt2.Owner;
import bt2.Vehicle;
import bt2.Rigister;

public class App {

	public static void main(String[] args) {
		Owner c1 = new Owner("01", "Nguyen Thu Loan");
		Owner c2 = new Owner("02", "Le Minh Tinh");
		Owner c3 = new Owner("03", "Nguyen Minh Triet");

		Vehicle x1 = new Vehicle("Future Neo", 100, 35000000);
		Vehicle x2 = new Vehicle("Ford Ranger", 3000, 250000000);
		Vehicle x3 = new Vehicle("Landscape", 1500, 100000000);

		Rigister r1 = new Rigister(c1, x1);
		Rigister r2 = new Rigister(c2, x2);
		Rigister r3 = new Rigister(c3, x3);
		
		System.out.print("Owner\t\t");
		System.out.print("Modle\t\t");
		System.out.print("CC\t");
		System.out.print("Price\t\t");
		System.out.print("Tax");
		System.out.println("\n======================================");

		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);

	}
}
