package bean;

public class Car {
	
	@Override
	public String toString() {
		return "Car [serial=" + serial + ", model=" + model + ", color=" + color + "]";
	}
	private int serial;
	private String model;
	private String color;
	
	public Car() {
	}

	public Car(int serial, String model, String color) {
		this.serial = serial;
		this.model = model;
		this.color = color;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}	
	public void setColor(String Color)
	{
		this.color=Color;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj) return true;
		if(!(obj instanceof Car)) return false;
		Car that =(Car) obj;
		return getSerial() == that.getSerial();
	}
	}