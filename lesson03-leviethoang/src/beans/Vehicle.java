package beans;

public class Vehicle {
	private String rov; // range of vehicle
	private int capacity;
	private long prize;
	
	public Vehicle() {
	}

	public Vehicle(String rov, int capacity, long prize) {
		super();
		this.rov = rov;
		this.capacity = capacity;
		this.prize = prize;
	}

	public String getRov() {
		return rov;
	}

	public void setRov(String rov) {
		this.rov = rov;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public long getPrize() {
		return prize;
	}

	public void setPrize(long prize) {
		this.prize = prize;
	}

	@Override
	public String toString() {
		return this.getRov() + "\t" + this.getCapacity()  + "\t\t" + this.getPrize() + "\t";
	}
	
	
}
