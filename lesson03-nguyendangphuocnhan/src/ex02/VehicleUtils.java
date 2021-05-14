package ex02;

public class VehicleUtils {
	public static long tax(Vehicle vehicle) {
		long tax = 0;
		long price = vehicle.getPrice();
		int capacity = vehicle.getCapacity();

		if (capacity < 100) {
			tax = Math.round((price * 0.01));
		} else if (capacity <= 200) {
			tax = (long) (price * 0.03);
		} else {
			tax = (long) (price * 0.05);
		}

		return tax;
	}
}
