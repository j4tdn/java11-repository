package bai02;

public class TaxUtil {
	public static double tax(Vehicle vehicle) {
		double tax = 0;
		if (vehicle.getCapacity() < 100)
			return tax = vehicle.getPrice() * 0.01;
		if (vehicle.getCapacity() > 100 && vehicle.getCapacity() <= 200)
			return tax = vehicle.getPrice() * 0.03;
		return tax = vehicle.getPrice() * 0.05;
	}
}
