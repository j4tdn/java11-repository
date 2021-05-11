package ex2;

public class Vehicle {
	private String hostName = "";
	private String model = "";
	private int volume;
	private double value;
	private double tax;
	public Vehicle() {}
	public Vehicle(String hostName, String model, int volume, double value, double tax) {
		this.hostName = hostName;
		this.model = model;
		this.volume = volume;
		this.value = value;
		this.tax = tax;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	@Override
	public String toString() {
		return "Vehicle[hostName= " + hostName + ", model= " + model + ", volume= " 
	                       + volume + ", value= " + value + ", tax= " + tax + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if(!(obj instanceof Vehicle)) {
			return false;
		}
		
		Vehicle vehicle = (Vehicle) obj;
		return this.getHostName() == vehicle.getHostName() &&
			   this.getModel() == vehicle.getModel() && 
			   this.getVolume() == vehicle.getVolume() &&
			   this.getValue() == vehicle.getValue() &&
			   this.getTax() == vehicle.getTax();
	}
	
}
