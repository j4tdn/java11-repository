package bt2;
import bt2.UtilsVehicle;
public class Rigister {
	private Owner owner;
	private Vehicle vehicle;
	
	public Rigister() {
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
	public Vehicle setVehicle() {
		return vehicle;
	}
	
	

	public Rigister(Owner owner, Vehicle vehicle) {
		super();
		this.owner = owner;
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Rigister [owner=" + owner + ", vehicle=" + vehicle + "]";
	}
	
	

}
