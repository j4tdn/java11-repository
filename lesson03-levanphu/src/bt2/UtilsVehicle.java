package bt2;
import bt2.Vehicle;
public class UtilsVehicle {
     public UtilsVehicle() {
    	 
     }
 

	public static long tax(Vehicle vehicle) {
			long tax = 0;
			long prize = vehicle.getPrize();
			int  CC = vehicle.getCapacity();
			
			if(CC < 100) {
				tax = (long) ( prize * 0.01);
			}else if(CC < 200) {
				tax = (long) ( prize * 0.03);
			}
			else {
				tax = (long) ( prize * 0.05);
			}
		
		return tax;
	}
}
