package exercise02;

public class Manager {
	private Owner owner;
	private Vehicle vehicle;

	public Manager() {
	}

	public Manager(Owner owner, Vehicle vehicle) {
		this.owner = owner;
		this.vehicle = vehicle;
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
		return "Manager [owner=" + owner + ", vehicle=" + vehicle + "]";
	}

}
