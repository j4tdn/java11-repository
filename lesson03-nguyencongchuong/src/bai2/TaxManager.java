package bai2;

public class TaxManager {
	private Vehicle vehicle;
	private Owner owner;
	
	public TaxManager() {
	}

	public TaxManager(Vehicle vehicle, Owner owner) {
		super();
		this.vehicle = vehicle;
		this.owner = owner;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Tax [vehicle=" + vehicle + ", owner=" + owner + "]";
	}
	
	
}
