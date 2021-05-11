package beans;

import utils.VehicleUtils;

public class Register {
	private Citizen citizen;
	private Vehicle vehicle;

	public Register() {
	}

	public Register(Citizen citizen, Vehicle vehicle) {
		super();
		this.citizen = citizen;
		this.vehicle = vehicle;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return this.citizen.getName() + "\t\t" + this.vehicle.toString() + VehicleUtils.tax(this.getVehicle());
	}
	
	
}
