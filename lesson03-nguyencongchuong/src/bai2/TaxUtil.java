package bai2;

public class TaxUtil {
	private TaxUtil() {
	}
	
	public static double exportTax (TaxManager taxManager) {
		double tax = 0;
		
		if (taxManager.getVehicle().getCapacity() < 100) {
			tax += taxManager.getVehicle().getCost() * 0.01;
			return tax;
		}
		if (taxManager.getVehicle().getCapacity() >= 100 || taxManager.getVehicle().getCapacity() <= 200) {
			tax += taxManager.getVehicle().getCost() * 0.03;
			return tax;
		}
			return tax += taxManager.getVehicle().getCost() * 0.05;
	}
}
