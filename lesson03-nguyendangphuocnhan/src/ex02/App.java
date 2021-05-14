package ex02;

public class App {

	public static void main(String[] args) {
		Owner o1 = new Owner("Nguyen Thu Loan");
		Owner o2 = new Owner("Le Minh Tinh");
		Owner o3 = new Owner("Nguyen Thu Loan");

		Vehicle v1 = new Vehicle("Future Neo", 100, 35000000);
		Vehicle v2 = new Vehicle("Ford Ranger", 3000, 250000000);
		Vehicle v3 = new Vehicle("Landscape", 1500, 100000000);

		RegistrationDetails rd1 = new RegistrationDetails(o1, v1);
		RegistrationDetails rd2 = new RegistrationDetails(o2, v2);
		RegistrationDetails rd3 = new RegistrationDetails(o3, v3);

		System.out.print("Owner's name:\t\t");
		System.out.print("Vehicle type:\t\t");
		System.out.print("Capacity:\t\t");
		System.out.print("Price\t\t");
		System.out.print("Tax");
		System.out.println(
				"\n=================================================================================================");

		System.out.println(rd1);
		System.out.println(rd2);
		System.out.println(rd3);
	}
}
