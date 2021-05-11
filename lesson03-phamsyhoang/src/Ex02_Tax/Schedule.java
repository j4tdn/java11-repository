package Ex02_Tax;

public class Schedule {
	private Person person;
	private Vehicle vehicle;
	private double tax;
	
	public Schedule() {
	}
	
	public Schedule(Person person, Vehicle vehicle, double tax) {
		super();
		this.person = person;
		this.vehicle = vehicle;
		this.tax = tax;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "Schedule [person=" + person + ", vehicle=" + vehicle + ", tax=" + tax + "]";
	}
	
	
}
