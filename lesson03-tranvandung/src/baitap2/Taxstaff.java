package baitap2;

public class Taxstaff {
	private User user;
	private Vehicle vehicle;
		
	public Taxstaff() {
	
	}

	public Taxstaff(User user, Vehicle vehicle) {
		this.user = user;
		this.vehicle = vehicle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Taxstaff [user=" + user + ", vehicle=" + vehicle + "]";
	}
	
}
