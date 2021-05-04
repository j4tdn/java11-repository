package bean;

public class Car {
	private String serial;
	private String model;
	private String color;
	
	public Car() {
	
	}

	public Car(String serial, String model, String color) {
		this.serial = serial;
		this.model = model;
		this.color = color;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
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

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Car)) {
			return false;
		}
		Car that = (Car) obj;
		return this.getSerial().equals(that.getSerial());
	}

	@Override
	public String toString() {
		return "Car [serial=" + serial + ", model=" + model + ", color=" + color + "]";
	}
}
