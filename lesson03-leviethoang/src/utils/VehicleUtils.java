package utils;


import beans.Vehicle;

public class VehicleUtils {
	
	private VehicleUtils() {
		
	}
	
	public static long tax(Vehicle vehicle) {
			long tax = 0;
			long prize = vehicle.getPrize();
			int  capacity = vehicle.getCapacity();
			
			if(capacity < 100) {
				tax = (long) (prize - prize * 0.99);
			}else if(capacity < 200) {
				tax = (long) (prize - prize * 0.97);
			}
			else {
				tax = (long) (prize - prize * 0.95);
			}
		
		return tax;
	}
}
