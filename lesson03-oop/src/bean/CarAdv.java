package bean;

public class CarAdv {
	public static String model;
	private int serial;
	private String color;
	
	public CarAdv() {
	}

	public CarAdv(int serial, String color) {
		this.serial = serial;
		this.color = color;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Car)) {
			return false;
		}
		Car that = (Car)o;
		return getSerial() == that.getSerial();	
	}
	
	@Override
	public String toString() {
		return "Car [serial=" + serial + ", model= " + model + " color=" + color + "]";
	}
}
