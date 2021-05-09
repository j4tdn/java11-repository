package bean;

public class Car {
	private String serial;
	private String color;
	private String model;

	public Car() {
	}

	public Car(String serial, String color, String model) {
		this.serial = serial;
		this.color = color;
		this.model = model;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Car)) {
			return false;
		}
		Car that = (Car) o;
		return this.getSerial().equals(that.getSerial());
	}

	@Override
	public String toString() {
		return "Car [serial=" + serial + ", color=" + color + ", model=" + model + "]";
	}

}