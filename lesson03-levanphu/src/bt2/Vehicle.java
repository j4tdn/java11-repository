package bt2;

public class Vehicle {
	private String rov;
	private int CC;
	private long prize;
	
	public Vehicle() {
	}

	public Vehicle(String rov, int cc, long prize) {
		super();
		this.rov = rov;
		this.CC = cc;
		this.prize = prize;
	}

	public String getRov() {
		return rov;
	}

	public void setRov(String rov) {
		this.rov = rov;
	}

	public int getCapacity() {
		return CC;
	}

	public void setCapacity(int cc) {
		this.CC = cc;
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
