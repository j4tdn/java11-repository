package ex02;

public class RegistrationDetails {
	public RegistrationDetails(Owner owner, Vehicle vehicle) {
		super();
		this.owner = owner;
		this.vehicle = vehicle;
	}

	private Owner owner;
	private Vehicle vehicle;

	public RegistrationDetails() {

	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return this.owner.toString() + "\t\t" + this.vehicle.toString() + VehicleUtils.tax(this.getVehicle());
	}

}
