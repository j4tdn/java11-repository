package Ex02_Tax;

public class ScheduleUtils {
	public static double Schedule(Vehicle vehicle) {
		double tax=0;
		if(vehicle.getCylinder()<100) {
			tax= vehicle.getCost()*1/100;
		}
		if(100<= vehicle.getCylinder() && vehicle.getCylinder() <=200) {
			tax= vehicle.getCost()*3/100;
		}
		if(vehicle.getCylinder()>200) {
			tax= vehicle.getCost()*5/100;
		}
		return tax;
		
	}
}
