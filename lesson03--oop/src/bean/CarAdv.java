package bean;

public class CarAdv{

	@Override
	public String toString() {
		return "Car [serial=" + serial + ", model=" + model + ", color=" + color + "]";
	}

	private int serial;
	private static String model;
	public static String getModel() {
		return model;
	}

	public static void setModel(String model) {
		CarAdv.model = model;
	}

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

	public void setColor(String Color) {
		this.color = Color;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
			return true;
		if (!(obj instanceof Car))
			return false;
		Car that = (Car) obj;
		return getSerial() == that.getSerial();
	}
}